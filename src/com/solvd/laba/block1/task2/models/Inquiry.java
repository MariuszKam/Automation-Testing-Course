package com.solvd.laba.block1.task2.models;

public class Inquiry {
    private final String from;
    private boolean pending;

    private String reply;

    public Inquiry(String from) {
        this.from = from;
        this.pending = true;
        this.reply = "";
    }

    public String getFrom() {
        return from;
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
    public String toString() {
        return "Inquiry From: " + from +
                "\nStatus: " + (pending ? "pending" : "solved") +
                (pending ? "" : "\nReply: " + reply);
    }
}
