package com.solvd.laba.block1.task2.models.shop.components.inquiry;

import static com.solvd.laba.block1.task2.Main.logger;

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

    public void statusInfo() {
        logger.info("Inquiry is {}", getStatus());
    }
}
