package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.persons.employees.Accountant;
import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.shop.components.*;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.AccountantNotFoundException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.CartEmptyException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InsufficientFundsException;
import com.solvd.laba.block1.task2.models.shop.components.inquiry.Inquiry;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Balanceable;
import com.solvd.laba.block1.task2.models.shop.components.payment.Payment;
import com.solvd.laba.block1.task2.models.shop.components.payment.PaymentMethod;
import com.solvd.laba.block1.task2.models.shop.components.shopping.CartActions;

import java.util.*;

import static com.solvd.laba.block1.task2.Main.logger;

public final class Shop implements Balanceable {
    private List<Employee> employees;
    private final Storage storage;
    private List<Customer> customers;
    private final Set<Inquiry> inquiries;
    private final Payment payment;
    private double balance;

    public Shop() {
        this.employees = new ArrayList<>();
        this.storage = new Storage();
        this.customers = new LinkedList<>();
        this.inquiries = new LinkedHashSet<>();
        this.payment = new Payment();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Storage getStorage() {
        return storage;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Set<Inquiry> getInquiries() {
        return inquiries;
    }

    public void addInquiry(Inquiry inquiry) {
        inquiries.add(inquiry);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void showBalance() {
        System.out.printf("Shop balance is %.2f$%n", balance);
    }

    @Override
    public void increaseBalance(double amount) {
        balance += amount;
    }

    @Override
    public void decreaseBalance(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException();
        }
    }

    public void processInquiries() {
        for (Inquiry inquiry : inquiries) {
            for (Employee employee : employees) {
                if (employee instanceof CustomerService customerservice) {
                    customerservice.solveInquiry(inquiry, storage);
                    inquiries.remove(inquiry);
                }
            }
        }
    }

    public void paySalaries() {
        try {
            decreaseBalance(getAccountant().calculatePayroll(employees));
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }

    private Accountant getAccountant() throws AccountantNotFoundException {
        Optional<Employee> accountant = employees.stream()
                .filter(employee -> employee instanceof Accountant)
                .findFirst();
        return accountant.map(employee -> (Accountant) employee)
                .orElseThrow(AccountantNotFoundException::new);
    }

    public void printStorage() {
        storage.getItems().forEach(logger::info);
    }

    public void checkout(Customer customer, PaymentMethod paymentMethod) throws CartEmptyException {
        if (customer.getCart().getItems().isEmpty()) {
            throw new CartEmptyException();
        }
        payment.makePayment(customer, this, paymentMethod);
        //Successful apply to storage and clear the cart
        CartActions.ORDER_CONFIRM.accept(customer.getCart());
    }

}
