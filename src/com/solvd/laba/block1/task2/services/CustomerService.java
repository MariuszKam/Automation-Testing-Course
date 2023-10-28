package com.solvd.laba.block1.task2.services;

import com.solvd.laba.block1.task2.models.Customer;
import com.solvd.laba.block1.task2.models.Item;
import com.solvd.laba.block1.task2.models.Shop;

public class CustomerService {

    //Has to be @Transactional
    public void putToCart(Customer customer, Shop shop, Item item, int amount) {
        //Check if Shop(Storage contains said item) - If does put to Customer cart if not inform Customer
        //If item gets to Cart should be removed as well from storage
        //If transaction is finished add said price to Shop balance, do reverse do Customer balance(Made in different method?)

    }
}
