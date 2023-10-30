package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.models.Shop;
import com.solvd.laba.block1.task2.services.ShopService;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ShopCreator.initializeShop(shop);
        ShopService shopService = new ShopService(shop);
        shopService.showStaff();
        shopService.payroll();
        shopService.showInventory();


    }
}
