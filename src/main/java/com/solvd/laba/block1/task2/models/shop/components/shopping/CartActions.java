package com.solvd.laba.block1.task2.models.shop.components.shopping;

import com.solvd.laba.block1.task2.models.shop.components.discount.DiscountService;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidPromoCodeException;
import com.solvd.laba.block1.task2.models.shop.components.exceptions.InvalidQuantityException;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.solvd.laba.block1.task2.Main.logger;

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
            item.setQuantity(item.getQuantity() + quantity);
            cart.removeItem(cartItem);
            return;
        }
        if (cartItem.getQuantity() < quantity) {
            throw new InvalidQuantityException("remove from cart");
        }
        item.setQuantity(item.getQuantity() + quantity);
        cart.decreaseQuantity(cartItem, quantity);
    };

    public static final Consumer<Cart> PRINT_CART = (cart) -> {
        if (cart.getItems().isEmpty()) {
            logger.warn("Your cart is empty");
        }
        cart.getItems().forEach(logger::info);
    };

    public static final Consumer<Cart> SHOW_PRICE = (cart) -> {
        String price = String.format("%.2f", cart.getTotalPrice());
        logger.info("Total price of your cart is: {}", price);
    };

    public static final BiConsumer<Cart, String> APPLY_CODE = (cart, code) -> {
        try {
            cart.setTotalPrice(DiscountService.countPrice(code, cart));
            logger.info("Code applied!");
            CartActions.SHOW_PRICE.accept(cart);
        } catch (InvalidPromoCodeException e) {
            logger.warn(e.getMessage());
        }
    };
}
