package com.solvd.laba.block1.task2.models;

public class Customer extends Person {

    private final Cart cart;

    public Customer(long id, String NAME, String LASTNAME) {
        super(id, NAME, LASTNAME);
        cart = new Cart();
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
