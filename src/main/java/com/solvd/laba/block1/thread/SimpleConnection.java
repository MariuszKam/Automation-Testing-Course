package com.solvd.laba.block1.thread;


public class SimpleConnection {

    private final long id;
    private boolean available;

    public SimpleConnection(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Connection #%d", getId());
    }
}
