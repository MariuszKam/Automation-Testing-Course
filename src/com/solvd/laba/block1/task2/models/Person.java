package com.solvd.laba.block1.task2.models;

public abstract class Person {

    private final long id;
    private final String NAME;
    private final String LASTNAME;

    public Person(long id, String NAME, String LASTNAME) {
        this.id = id;
        this.NAME = NAME;
        this.LASTNAME = LASTNAME;
    }

    public long getId() {
        return id;
    }

    public String getNAME() {
        return NAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }
}
