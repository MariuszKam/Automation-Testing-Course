package com.solvd.laba.block1.task2.models.persons;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

    @Override
    public String toString() {
        return "Person: " +
                "ID: " + id +
                "\nName: " + name +
                "\nLastname: " + lastname;
    }
}
