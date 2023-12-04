package com.solvd.laba.block1.task2.models.shop.components.shopping;

import com.solvd.laba.block1.task2.models.shop.components.Item;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidQuantityException;

public class CartActions {
    //Adding item to cart - implementation
    public static final CartAction ADD_ITEM = (cart, item, quantity) -> {
        //Checking storage quantity
        if (item.getQuantity() < quantity) {
            throw new InvalidQuantityException("add to cart");
        }
        //Update storage quantity
        item.setQuantity(item.getQuantity() - quantity);
        //Add item to cart
        Item toCart = new Item(item.getId(), item.getName(), item.getPrice(), quantity);
        cart.addItem(toCart);
    };

    //Removing item from cart - implementation
    public static final CartAction REMOVE_ITEM = (cart, item, quantity) -> {
        //Retrieve item from cart
        Item cartItem = cart.getItemByName(item.getName());

        //Remove item from cart
        if (cartItem.getQuantity() == quantity) {
            cart.removeItem(cartItem);
            return;
        }
        if (cartItem.getQuantity() < quantity) {
            throw new InvalidQuantityException("remove from cart");
        }
        cart.decreaseQuantity(cartItem, quantity);
    };
}
