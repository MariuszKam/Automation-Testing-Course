package com.solvd.laba.block1.task2.models;

public abstract class Person {

    protected final long id;
    protected final String name;
    protected final String lastname;

    public Person(long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

}
