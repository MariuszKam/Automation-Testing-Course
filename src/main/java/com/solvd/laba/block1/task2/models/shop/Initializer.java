package com.solvd.laba.block1.task2.models.shop;


import com.solvd.laba.block1.task2.models.shop.components.dataloader.DataLoader;
import com.solvd.laba.block1.task2.models.shop.components.discount.PromoCode;

import java.util.Map;

public final class Initializer {
    private static final Shop shop;
    private static final String URL = "src/main/resources/task2/";

    static {
        shop = new Shop();
        initializeEmployees();
        initializeItems();
        initializeCustomers();
    }

    public static Shop getShop() {
        return shop;
    }

    private static void initializeEmployees() {
        //Creating employees
        shop.setEmployees(DataLoader.employeesLoader(URL + "employees.csv"));
    }

    private static void initializeItems() {
        //Creating products
        shop.getStorage().setItems(DataLoader.itemLoader(URL + "items.csv"));
    }

    private static void initializeCustomers() {
        //Creating customers in with carts
        DataLoader.customersLoader(URL + "customers.csv").forEach(shop::assignCart);
    }

    public static Map<String, PromoCode> initializePromoCodes() {
        //Creating promo codes
        return DataLoader.promoCodesLoader(URL + "promocodes.csv");
    }
}
