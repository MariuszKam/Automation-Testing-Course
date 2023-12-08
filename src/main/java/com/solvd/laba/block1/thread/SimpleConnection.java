package com.solvd.laba.block1.thread;


public class SimpleConnection {

    private final long id;

    public SimpleConnection(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Connection #%d", getId());
    }
}
