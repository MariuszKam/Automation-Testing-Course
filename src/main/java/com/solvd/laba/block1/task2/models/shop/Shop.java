package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.shop.components.*;
import com.solvd.laba.block1.task2.models.shop.components.discount.DiscountService;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.CartEmptyException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidQuantityException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Balanceable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Discountable;
import com.solvd.laba.block1.task2.models.shop.components.shopping.Cart;
import com.solvd.laba.block1.task2.models.shop.components.shopping.CartAction;
import com.solvd.laba.block1.task2.models.shop.components.shopping.ShoppingService;

import java.util.*;

import static com.solvd.laba.block1.task2.Main.logger;

public final class Shop implements Balanceable/*, Discountable*/ {
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
    public boolean isPositive() {
        return balance >= 0;
    }

    @Override
    public void increaseBalance(double amount) {
        balance += amount;
    }

    @Override
    public void decreaseBalance(double amount) {
        double savePoint = balance;
        balance -= amount;
        if (!isPositive()) {
            balance = savePoint;
            logger.warn("Insufficient funds for operation");
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

    public void printStorage() {
        storage.getItems().forEach(logger::info);
    }


    public void performCartAction(Customer customer, CartAction cartAction, String itemName, int quantity) {
        cartAction.perform(customer.getCart(), storage.getItemByName(itemName), quantity);
    }

    public void printCart(Customer customer) {
        if (customer.getCart().getItems().isEmpty()) {
            logger.warn("Your cart is empty");
        }
        customer.getCart().getItems().forEach(logger::info);
    }

    public void showTotalPrice(Customer customer) {
        String price = String.format("%.2f", customer.getCart().getTotalPrice());
        logger.info("Total price of your cart is: {}", price);
    }

    public void addItemToCustomerCart(Customer customer, String itemName, int quantity) {
        //Retrieve item from storage
        Item item = storage.getItemByName(itemName);
        if (item.getQuantity() < quantity) {
            throw new InvalidQuantityException("add to cart");
        }
        item.setQuantity(item.getQuantity() - quantity);
        Item toCart = new Item(item.getId(), item.getName(), item.getPrice(), quantity);
        customer.getCart().addItem(toCart);
    }

    public void removeItemFromCustomerCart(Customer customer, String itemName, int quantity) {
        //Retrieve item
        Item inCart = customer.getCart().getItemByName(itemName);
        //Change in Storage
        Item inStorage = storage.getItemByName(itemName);
        inStorage.setQuantity(inStorage.getQuantity() + quantity);
        //Removing item if equals to quantity
        if (inCart.getQuantity() == quantity) {
            customer.getCart().removeItem(inCart);
            return;
        }
        if (inCart.getQuantity() < quantity) {
            throw new InvalidQuantityException("remove from cart");
        }
        customer.getCart().decreaseQuantity(inCart, quantity);
    }

    public void applyPromoCode(Customer customer, String code) {
        //TODO: Make Try-catch and exception here for cart <if customer doesn't have one>
        try {
            customer.getCart().setTotalPrice(DiscountService.countPrice(code, customer.getCart()));
            logger.info("Code applied!");
            showTotalPrice(customer);
        } catch (InvalidPromoCodeException e) {
            logger.warn(e.getMessage());
        }
    }


//    public void checkout(Customer customer) throws CartEmptyException {
//        if (customerCart.get(customer).getItems().isEmpty()) {
//            throw new CartEmptyException();
//        }
//        if (payment.makePayment(this, customer)) {
//            //Successful apply to storage and clear the cart
//            confirmOrder(customer);
//        }
//    }

    private void confirmOrder(Customer customer) {
        customer.getCart().getItems().clear();
        logger.info("Thank you for choosing our shop!");
    }

    public void rejectOrder(Customer customer) {
        for (Item item : customer.getCart().getItems()) {
            Item inStorage = storage.getItemByName(item.getName());
            inStorage.setQuantity(inStorage.getQuantity() + item.getQuantity());
        }
        customer.getCart().getItems().clear();
        logger.warn("Order rejected!");
    }

}
