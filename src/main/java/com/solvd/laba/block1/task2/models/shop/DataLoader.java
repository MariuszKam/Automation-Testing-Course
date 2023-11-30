package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.shop.components.Item;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataLoader {


    private static <T> List<T> loadData(String filePath, DataParser<T> parser) {
        List<T> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(filePath))){
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(",");
                data.add(parser.parse(splitLine));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    //Item loader
    private static Item parseItem(String[] itemsData) {
        long id = Long.parseLong(itemsData[0]);
        double price = Double.parseDouble(itemsData[2]);
        int quantity = Integer.parseInt(itemsData[3]);
        return new Item(id, itemsData[1], price, quantity);
    }

    public static List<Item> itemLoader(String filePath) {
        return loadData(filePath, DataLoader::parseItem);
    }

    //Employees loader

}
