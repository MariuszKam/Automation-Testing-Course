package com.solvd.laba.block1.reflection;


import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.components.shopping.Cart;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        String className = "com.solvd.laba.block1.task2.models.persons.Customer";

        try {
            //Getting class by using className
            Class<?> customerClass = Class.forName(className);
            //Fields of class
            System.out.println("Fields: ");
            Field[] fields = customerClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
            }
            //Getting constructor
            System.out.println("Constructor: ");
            Constructor<?>[] constructors = customerClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.print(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName());
                for (Class<?> parameterType : constructor.getParameterTypes()) {
                    System.out.print("  " + parameterType.getName());
                }
            }
            //Getting methods
            System.out.println("\nMethods: ");
            Method[] methods = customerClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + " " + method.getName());
                for (Class<?> parameterType : method.getParameterTypes()) {
                    System.out.print("  " + parameterType.getName() + "\n");
                }
            }
            //And finally creating instance from reflection
            Constructor<?> constructor = customerClass.getDeclaredConstructor(long.class, String.class, String.class);
            Object object = constructor.newInstance(1, "Name", "Lastname");
            Method method = customerClass.getMethod("getCart");
            System.out.println("\n" + method.invoke(object));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
