package com.solvd.laba.block1.task2.models.shop.components.interfaces;

import com.solvd.laba.block1.task2.models.persons.Customer;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;

public interface Discountable {
    void applyPromoCode(Customer customer, String code) throws InvalidPromoCodeException;
}
