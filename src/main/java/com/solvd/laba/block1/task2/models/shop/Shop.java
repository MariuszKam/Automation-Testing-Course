package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.shop.components.*;
import com.solvd.laba.block1.task2.models.shop.components.discount.DiscountService;
import com.solvd.laba.block1.task2.models.shop.components.discount.PromoCode;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.CartEmptyException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidQuantityException;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Balanceable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.Discountable;
import com.solvd.laba.block1.task2.models.shop.components.interfaces.QuantityChecker;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static com.solvd.laba.block1.task2.Main.logger;

public final class Shop implements Balanceable/*, Discountable*/ {
    private MyLinkedList<Employee> employees;
    private final Storage storage;
    private final Map<Customer, Cart> customerCart;
    private final Set<Inquiry> inquiries;
    private final DiscountService discountService;
    private final Payment payment;
    private double balance;
    private final QuantityChecker<Item> isEnough = (item, requiredQuantity) -> item.getQuantity() >= requiredQuantity;
    private final QuantityChecker<Item> isEqual = ((item, requiredQuantity) -> item.getQuantity() == requiredQuantity);

    public Shop() {
        this.employees = new MyLinkedList<>();
        this.storage = new Storage();
        this.customerCart = new HashMap<>();
        this.inquiries = new LinkedHashSet<>();
        this.discountService = new DiscountService();
        this.payment = new Payment();
    }

    public MyLinkedList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(MyLinkedList<Employee> employees) {
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

    public Set<Inquiry> getInquiries() {
        return inquiries;
    }

    public void addInquiry(Inquiry inquiry) {
        inquiries.add(inquiry);
    }

    public DiscountService getDiscountService() {
        return discountService;
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

    public void printCart(Customer customer) {
        Cart cart = customerCart.get(customer);
        if (cart.getItems().isEmpty()) {
            logger.warn("Your cart is empty");
        }
        cart.getItems().forEach(logger::info);
    }

    public void showTotalPrice(Customer customer) {
        Cart cart = customerCart.get(customer);
        String price = String.format("%.2f", cart.getTotalPrice());
        logger.info("Total price of your cart is: {}", price);
    }

    public void addItemToCustomerCart(Customer customer, String itemName, int quantity) {
        if (hasCart(customer)) {
            Cart cart = customerCart.get(customer);
            //Retrieve item from storage
            Item item = storage.getItemByName(itemName);
            if (!isEnough.checkQuantity(item, quantity)) {
                throw new InvalidQuantityException("add to cart");
            }
            item.setQuantity(item.getQuantity() - quantity);
            Item toCart = new Item(item.getId(), item.getName(), item.getPrice(), quantity);
            cart.addItem(toCart);
        } else {
            logger.warn("{} {} does not have a cart! Please assign a cart first", customer.getName(), customer.getLastname());
        }

    }

    public void removeItemFromCustomerCart(Customer customer, String itemName, int quantity) {
        if (hasCart(customer)) {
            Cart cart = customerCart.get(customer);
            //Retrieve item
            Item inCart = cart.getItemByName(itemName);
            //Change in Storage
            Item inStorage = storage.getItemByName(itemName);
            inStorage.setQuantity(inStorage.getQuantity() + quantity);
            //Removing item if equals to quantity
            if (isEqual.checkQuantity(inCart, quantity)) {
                cart.removeItem(inCart);
                return;
            }
            if (!isEnough.checkQuantity(inCart, quantity)) {
                throw new InvalidQuantityException("remove from cart");
            }
            cart.decreaseQuantity(inCart, quantity);
        } else {
            logger.warn("{} {} does not have a cart! Please assign a cart first", customer.getName(), customer.getLastname());
        }
    }

//    public void applyPromoCode(Customer customer, String code) throws InvalidPromoCodeException {
//        Cart cart = customerCart.get(customer);
//        if (promoCode.getCode().equals(code)) {
//            double newTotalPrice = cart.getTotalPrice() * 0.9;
//            newTotalPrice = (double) Math.round(newTotalPrice * 100) / 100;
//            cart.setTotalPrice(newTotalPrice);
//            logger.info("Congratulation! You applied a promo code. You new total price is {}", cart.getTotalPrice());
//        } else {
//            throw new InvalidPromoCodeException();
//        }
//
//    }

    public void checkout(Customer customer) throws CartEmptyException {
        if (customerCart.get(customer).getItems().isEmpty()) {
            throw new CartEmptyException();
        }
        if (payment.makePayment(this, customer)) {
            //Successful apply to storage and clear the cart
            confirmOrder(customer);
        }
    }

    private void confirmOrder(Customer customer) {
        Cart cart = customerCart.get(customer);
        cart.getItems().clear();
        logger.info("Thank you for choosing our shop!");
    }

    public void rejectOrder(Customer customer) {
        Cart cart = customerCart.get(customer);
        for (Item item : cart.getItems()) {
            Item inStorage = storage.getItemByName(item.getName());
            inStorage.setQuantity(inStorage.getQuantity() + item.getQuantity());
        }
        cart.getItems().clear();
        logger.warn("Order rejected!");
    }

    private boolean hasCart(Customer customer) {
        return customerCart.containsKey(customer);
    }

}
