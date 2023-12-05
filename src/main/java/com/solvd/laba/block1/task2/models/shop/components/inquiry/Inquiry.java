package com.solvd.laba.block1.task2.models.shop.components.inquiry;

import com.solvd.laba.block1.task2.models.persons.Customer;

import java.util.Objects;

public class Inquiry {
    private final Customer from;
    private final String itemName;
    private InquiryStatus inquiryStatus;
    private String reply;

    public Inquiry(Customer from, String itemName) {
        this.from = from;
        this.itemName = itemName;
        this.inquiryStatus = InquiryStatus.IN_PROGRESS;
        this.reply = "";
    }

    public Customer getFrom() {
        return from;
    }

    public String getItemName() {
        return itemName;
    }

    public InquiryStatus getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(InquiryStatus inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
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
        return Objects.equals(from, inquiry.from) && Objects.equals(itemName, inquiry.itemName) && inquiryStatus == inquiry.inquiryStatus && Objects.equals(reply, inquiry.reply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, itemName, inquiryStatus, reply);
    }

    @Override
    public String toString() {
        return "Inquiry From: " + from.getName() + " " + from.getLastname() + " regarding the quantity of " + itemName + " in stock." +
                "\nStatus: " + inquiryStatus.getStatus();
    }
}
