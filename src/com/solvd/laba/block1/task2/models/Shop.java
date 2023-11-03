package com.solvd.laba.block1.task2.models;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.persons.employees.Position;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Employee> employees;
    private final Storage storage;
    private Cart cart;
    private final PromoCode promoCode;
    private double balance;

    public Shop() {
        this.employees = new ArrayList<>();
        this.storage = new Storage();
        this.promoCode = new PromoCode();
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void assignCart(Customer customer) {
        cart = new Cart(customer);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void handleInquiry(Inquiry inquiry) {
        for (Employee employee : employees) {
            if (employee.getPosition() == Position.CUSTOMER_SERVICE && employee instanceof CustomerService) {
                ((CustomerService) employee).solveInquiry(inquiry, storage);
                return;
            }
        }
        System.out.println("No customer service available");
    }

    public void printStorage() {
        storage.getItems().forEach(System.out::println);
    }

    public void printCart() {
        if (cart.getItems().size() == 0) {
            System.out.println("Your cart is empty");
        }
        cart.getItems().forEach(System.out::println);
    }

    public void showTotalPrice() {
        System.out.printf("Total price of your cart is: %.2f$%n", cart.getTotalPrice());
    }

    public void addItem(String itemName, int quantity) {
        //Check if item exists in storage to avoid NPE
        if (storage.getItems().stream().noneMatch(item -> item.getName().equals(itemName))) {
            System.out.printf("We do not have %s in our store%n", itemName);
            return;
        }
        //Retrieve item from storage
        Item item = storage.getItemByName(itemName);
        //Check if storage has ordered quantity
        if (item.getQuantity() < quantity) {
            System.out.printf("We have only %s %s%n", item.getQuantity(), item.getName());
            return;
        }
        Item toCart = new Item(item.getId(), item.getName(), item.getPrice(), quantity);
        cart.addItem(toCart);
    }

    public void removeItem(String itemName, int quantity) {
        //Check if item exists in cart
        if (cart.getItems().stream().noneMatch(item -> item.getName().equals(itemName))) {
            System.out.printf("You do not have %s in your cart%n", itemName);
            return;
        }
        //Retrieve item from cart
        Item item = cart.getItemByName(itemName);
        //Check quantity
        if (item.getQuantity() < quantity) {
            System.out.printf("You do not have %s %s in your cart%n", quantity, item.getName());
            return;
        }
        //Removing item if equals to quantity
        if (item.getQuantity() == quantity) {
            cart.removeItem(item);
            return;
        }
        cart.decreaseQuantity(item, quantity);
    }

    public void applyPromoCode(String code) {
        if (promoCode.getCode().equals(code)) {
            cart.setTotalPrice(cart.getTotalPrice() * 0.9);
            System.out.printf("Congratulation! You applied a promo code. You new total price is %.2f$", cart.getTotalPrice());
        } else {
            System.out.printf("%s promo code is invalid!", code);
        }
    }
}
