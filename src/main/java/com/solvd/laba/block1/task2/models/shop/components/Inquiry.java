package com.solvd.laba.block1.task2.models.shop.components;

import com.solvd.laba.block1.task2.models.persons.Customer;

import java.util.Objects;

public class Inquiry {
    private final Customer from;
    private final String itemName;
    private boolean pending;
    private String reply;

    public Inquiry(Customer from, String itemName) {
        this.from = from;
        this.itemName = itemName;
        this.pending = true;
        this.reply = "";
    }

    public Customer getFrom() {
        return from;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquiry inquiry = (Inquiry) o;
        return pending == inquiry.pending && Objects.equals(from, inquiry.from) && Objects.equals(itemName, inquiry.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, itemName, pending);
    }

    @Override
    public String toString() {
        return "Inquiry From: " + from.getName() + " " + from.getLastname() + " regarding the quantity of " + itemName + " in stock." +
                "\nStatus: " + (pending ? "pending" : "solved") +
                (pending ? "" : "\nReply: " + reply);
    }
}
