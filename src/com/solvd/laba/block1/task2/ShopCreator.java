package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.models.Employee;
import com.solvd.laba.block1.task2.models.Shop;
import com.solvd.laba.block1.task2.services.ShopService;


import java.util.Random;


public class ShopCreator {


    public static void createStaff(Shop shop) {
        String[] name = {"Amelia", "Jackson", "Olivia", "Ethan", "Sophia", "Liam", "Mia", "Noah", "Ava", "Lucas"};
        String[] lastname = {"Parker", "Bennett", "Mitchell", "Cooper", "Anderson", "Johnson", "Turner", "Collins", "Davis", "Wilson"};
        ShopService shopService = new ShopService(shop);
        Random random = new Random();

        for (int i = 1; i < 12; i++) {
            //Same length for both arrays
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
}
