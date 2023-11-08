package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.shop.components.*;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Balanceable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Discountable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Shop implements Balanceable, Discountable {
    private List<Employee> employees;
    private final Storage storage;
    private final Map<Customer, Cart> customerCart;
    private final PromoCode promoCode;
    private final Payment payment;
    private double balance;

    public Shop() {
        this.employees = new ArrayList<>();
        this.storage = new Storage();
        this.customerCart = new HashMap<>();
        this.promoCode = new PromoCode();
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

    public Map<Customer, Cart> getCustomerCart() {
        return customerCart;
    }

    public void assignCart(Customer customer) {
        Cart cart = new Cart(customer);
        customerCart.put(customer, cart);
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
            System.out.println("Insufficient funds for operation");
        }
    }

    public void handleInquiry(Inquiry inquiry) {
        for (Employee employee : employees) {
            if (employee instanceof CustomerService customerservice) {
                customerservice.solveInquiry(inquiry, storage);
                return;
            }
        }
        System.out.println("No customer service available");
    }

    public void printStorage() {
        storage.getItems().forEach(System.out::println);
    }

    public void printCart(Customer customer) {
        Cart cart = customerCart.get(customer);
        if (cart.getItems().size() == 0) {
            System.out.println("Your cart is empty");
        }
        cart.getItems().forEach(System.out::println);
    }

    public void showTotalPrice(Customer customer) {
        Cart cart = customerCart.get(customer);
        System.out.printf("Total price of your cart is: %.2f$%n", cart.getTotalPrice());
    }

    public void addItemToCustomerCart(Customer customer, String itemName, int quantity) {
        if (hasCart(customer)) {
            Cart cart = customerCart.get(customer);
            //Check if item exists in storage to avoid NPE
            if (storage.getItems().stream().noneMatch(item -> item.getName().equals(itemName))) {
                System.out.printf("We do not have %s in our store%n", itemName); //ItemNotFoundException should work here instead be here
                return;
            }
            //Retrieve item from storage
            Item item = storage.getItemByName(itemName);
            item.setQuantity(item.getQuantity() - quantity);
            Item toCart = new Item(item.getId(), item.getName(), item.getPrice(), quantity);
            cart.addItem(toCart);
        } else {
            System.out.printf("%s %s does not have a cart! Please assign a cart first",
                    customer.getName(), customer.getLastname());
        }

    }

    public void removeItemFromCustomerCart(Customer customer, String itemName, int quantity) {
        if (hasCart(customer)) {
            Cart cart = customerCart.get(customer);
            //Check if item exists in cart
            if (cart.getItems().stream().noneMatch(item -> item.getName().equals(itemName))) {
                System.out.printf("You do not have %s in your cart%n", itemName); //ItemNotFoundException should be here
                return;
            }
            //Retrieve items
            Item inCart = cart.getItemByName(itemName);
            //Change in Storage
            Item inStorage = storage.getItemByName(itemName);
            inStorage.setQuantity(inStorage.getQuantity() + quantity);
            //Removing item if equals to quantity
            if (inCart.getQuantity() == quantity) {
                cart.removeItem(inCart);
                return;
            }
            cart.decreaseQuantity(inCart, quantity);
        } else {
            System.out.printf("%s %s does not have a cart! Please assign a cart first",
                    customer.getName(), customer.getLastname());
        }
    }

    public void applyPromoCode(Customer customer, String code) {
        Cart cart = customerCart.get(customer);
        try {
            if (promoCode.getCode().equals(code)) {
                double newTotalPrice = cart.getTotalPrice() * 0.9;
                newTotalPrice = (double) Math.round(newTotalPrice * 100) / 100;
                cart.setTotalPrice(newTotalPrice);
                System.out.printf("Congratulation! You applied a promo code. You new total price is %.2f$%n", cart.getTotalPrice());
            } else {
                throw new InvalidPromoCodeException("Invalid promo code: " + code);
            }
        } catch (InvalidPromoCodeException e) {
            System.out.printf("Error: %s%n", e.getMessage());
        }
    }

    public void checkout(Customer customer) {
        Cart cart = customerCart.get(customer);
        if (payment.makePayment(this, cart)) {
            //Successful apply to storage and clear the cart
            confirmOrder(customer);
        } else {
            //Nope! Do not apply to storage, but as well clear the cart
            rejectOrder(customer);
            System.out.printf("You have insufficient funds. Total cart price is %.2f$, but your account balance is %.2f$%n",
                    cart.getTotalPrice(),
                    cart.getCustomer().getBalance());
        }
    }

    private void confirmOrder(Customer customer) {
        Cart cart = customerCart.get(customer);
//        for (Item item : cart.getItems()) {
//            Item inStorage = storage.getItemByName(item.getName()); Try to do reverse action to upgrade
//            inStorage.setQuantity(inStorage.getQuantity() - item.getQuantity());
//        }
        cart.getItems().clear();
        System.out.println("Thank you for choosing our shop!");
    }

    public void rejectOrder(Customer customer) {
        Cart cart = customerCart.get(customer);
        for (Item item : cart.getItems()) {
            Item inStorage = storage.getItemByName(item.getName());
            inStorage.setQuantity(inStorage.getQuantity() + item.getQuantity());
        }
        cart.getItems().clear();
        System.out.println("Order rejected!");
    }

    private boolean hasCart(Customer customer) {
        return customerCart.containsKey(customer);
    }

}
