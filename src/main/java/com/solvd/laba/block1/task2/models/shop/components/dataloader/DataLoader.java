package com.solvd.laba.block1.task2.models.shop.components.dataloader;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.persons.employees.CustomerService;
import com.solvd.laba.block1.task2.models.persons.employees.Employee;
import com.solvd.laba.block1.task2.models.persons.employees.Manager;
import com.solvd.laba.block1.task2.models.persons.employees.Position;
import com.solvd.laba.block1.task2.models.shop.components.Item;
import com.solvd.laba.block1.task2.models.shop.components.discount.PromoCode;

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
    private static Employee parseEmployee(String[] employeesData) {
        long id = Long.parseLong(employeesData[0]);
        String firstName = employeesData[1];
        String lastName = employeesData[2];
        double salary = Double.parseDouble(employeesData[3]);
        Position position = Position.valueOf(employeesData[4]);

        switch (position) {
            case MANAGER -> {
                return new Manager(id, firstName, lastName, salary);
            }
            case CUSTOMER_SERVICE -> {
                return new CustomerService(id, firstName, lastName, salary);
            }
            default -> throw new IllegalArgumentException("Unknown position: " + position);
        }

    }

    public static List<Employee> employeesLoader(String filePath) {
        return loadData(filePath, DataLoader::parseEmployee);
    }

    //Customer loader
    private static Customer parseCustomer(String[] customersData) {
        long id = Long.parseLong(customersData[0]);
        String firstName = customersData[1];
        String lastName = customersData[2];
        return new Customer(id, firstName, lastName);
    }

    public static List<Customer> customersLoader(String filePath) {
        return loadData(filePath, DataLoader::parseCustomer);
    }

    //Promo codes loader
    private static PromoCode parsePromoCode(String[] promoCodesData) {
        long id = Long.parseLong(promoCodesData[0]);
        String code = promoCodesData[1];
        double value = Double.parseDouble(promoCodesData[2]);
        boolean flat = Boolean.parseBoolean(promoCodesData[3]);
        return new PromoCode(id, code, value, flat);
    }

    public static List<PromoCode> promoCodesLoader(String filePath) {
        return loadData(filePath, DataLoader::parsePromoCode);
    }

}
