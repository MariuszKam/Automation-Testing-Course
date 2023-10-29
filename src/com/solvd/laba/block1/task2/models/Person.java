package com.solvd.laba.block1.task2.models;

public abstract class Person {

    private final long id;
    private final String name;
    private final String lastname;

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
