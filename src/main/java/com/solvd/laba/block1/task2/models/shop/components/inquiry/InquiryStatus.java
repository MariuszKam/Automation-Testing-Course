package com.solvd.laba.block1.task2.models.shop.components.inquiry;

public enum InquiryStatus {
    IN_PROGRESS("In Progress"),
    RESOLVED("Resolved");

    private final String status;

    InquiryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
