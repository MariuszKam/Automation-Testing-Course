package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.models.Employee;
import com.solvd.laba.block1.task2.models.Item;
import com.solvd.laba.block1.task2.models.Shop;
import com.solvd.laba.block1.task2.services.ShopService;


import java.util.Random;


public class ShopCreator {
    private static Random random = new Random();


    private static void createStaff(Shop shop) {
        //Array of names and lastnames
        String[] name = {"Amelia", "Jackson", "Olivia", "Ethan", "Sophia", "Liam", "Mia", "Noah", "Ava", "Lucas"};
        String[] lastname = {"Parker", "Bennett", "Mitchell", "Cooper", "Anderson", "Johnson", "Turner", "Collins", "Davis", "Wilson"};
        ShopService shopService = new ShopService(shop);

        for (int i = 1; i < 12; i++) {
            //Number for an index to pick random name and lastname from array.
            int randomName = random.nextInt(name.length);
            int randomLastname = random.nextInt(lastname.length);
            double salary = random.nextDouble(2200.00 - 800.00 + 1) + 800.00;
            //Creating Manager
            if (i == 1) {
                shopService.hire(new Employee(i, name[randomName], lastname[randomLastname], salary, "Manager"));
                continue;
            }
            shopService.hire(new Employee(i, name[randomName], lastname[randomLastname], salary, "Customer Service"));
        }

    }

    private static void createInventory(Shop shop) {
        String[] items = {"Pencil", "Notebook", "Soccer Ball", "Teddy Bear", "Calculator", "Backpack", "Headphones",
                "Coffee Mug", "Smartphone Case", "Sunglasses", "Umbrella", "Water Bottle", "Wallet", "Watch", "Laptop",
                "T-shirt", "Sneakers", "Perfume", "Alarm Clock", "Kitchen Knife Set", "Yoga Mat", "Dumbbell Set",
                "Plant Pot", "Towel Set", "Picture Frame", "Candle Holder", "Bluetooth Speaker", "Desk Lamp",
                "Wall Clock", "Stationery Set"};
        ShopService shopService = new ShopService(shop);
        for (int i = 0; i < items.length; i++) {
            int id = i + 1;
            double price = random.nextDouble(30.00 - 5.00 + 1) + 5.00;
            int amount = random.nextInt(100);
            shopService.addItem(new Item(id, items[i], price, amount));
        }
    }

    public static void initializeShop(Shop shop) {
        createStaff(shop);
        createInventory(shop);
    }
}
