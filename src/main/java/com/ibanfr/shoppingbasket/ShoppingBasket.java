package com.ibanfr.shoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private final List<Item> items;

    public ShoppingBasket() {
        items = new ArrayList<>();
    }

    public int totalPrice() {
        return items.stream()
                .mapToInt(Item::unitPrice)
                .sum();
    }

    public void addItem(Item itemA, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.items.add(itemA);
        }
    }

    public long quantityOf(Item anItem) {
        return  items.stream()
                .filter(item -> item.equals(anItem))
                .count();
    }

    public long calculateDiscount() {
        return totalPrice()>100 ? 5 : 0;
    }
}
