package com.solvd.laba.block1.task2.models.persons.employees;

import com.solvd.laba.block1.task2.models.Inquiry;
import com.solvd.laba.block1.task2.models.Item;
import com.solvd.laba.block1.task2.models.Storage;

public class CustomerService extends Employee {

    public CustomerService(long id, String name, String lastname, double salary) {
        super(id, name, lastname, salary);
        this.position = Position.CUSTOMER_SERVICE;
    }

    public void solveInquiry(Inquiry inquiry, Storage storage) {
        Item item = storage.getItemByName(inquiry.getItemName());
        inquiry.setReply("Currently we have " + item.getQuantity() + " in stock");
        inquiry.setPending(false);
    }

    //OPP - part 2 - Create and override at least one abstract method.
    @Override
    public void work() {
        System.out.println("Attend customer");
    }
}
