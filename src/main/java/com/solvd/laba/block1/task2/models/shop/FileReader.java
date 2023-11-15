package com.solvd.laba.block1.task2.models.shop;

import com.solvd.laba.block1.task2.models.shop.components.Item;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private static final String URL = "src/main/java/com/solvd/laba/block1/task2/resources/items.csv";

    public static List<Item> itemLoader() {
        List<Item> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(URL))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(",");
                long id = Long.parseLong(splitLine[0]);
                double price = Double.parseDouble(splitLine[2]);
                int quantity = Integer.parseInt(splitLine[3]);
                items.add(new Item(id, splitLine[1], price, quantity));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }
}
