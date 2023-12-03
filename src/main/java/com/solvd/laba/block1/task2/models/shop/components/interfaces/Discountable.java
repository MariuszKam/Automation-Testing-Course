package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.persons.Customer;

public interface Discountable {
    void applyPromoCode(Customer customer, String code);
}
