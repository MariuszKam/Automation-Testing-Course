package com.solvd.laba.block1.task2.services;

import com.solvd.laba.block1.task2.models.Customer;
import com.solvd.laba.block1.task2.models.Item;
import com.solvd.laba.block1.task2.models.Shop;

public class CustomerService {

    public void putToCart(Customer customer, Shop shop, Item item) {
        if (isAvailable(item, shop)) {
            //Gets to Cart
            customer.getCart().addItem(item);
            //Removed from Storage
            int index = (int) item.getId() - 1;
            int newAmount = shop.getStorage().getItems().get(index).getAmount() - item.getAmount();
            shop.getStorage().getItems().get(index).setAmount(newAmount);
            //Change Shop balance
            shop.setBalance(shop.getBalance() + item.getPrice());
        } else {
            System.out.println("Product currently unavailable");
        }
    }

    private boolean isAvailable(Item item, Shop shop) {
        if (shop.getStorage().getItems().contains(item)) {
            int index = (int) item.getId() - 1;
            return shop.getStorage().getItems().get(index).getAmount() >= item.getAmount();
        }
        return false;
    }
}
