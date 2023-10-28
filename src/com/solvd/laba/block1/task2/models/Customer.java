package com.solvd.laba.block1.task2.models;

public class Customer extends Person {

    
    public Customer(long id, String NAME, String LASTNAME) {
        super(id, NAME, LASTNAME);
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getNAME() {
        return super.getNAME();
    }

    @Override
    public String getLASTNAME() {
        return super.getLASTNAME();
    }
}
