package com.ibanfr.shoppingbasket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private final List<Item> items;

    public ShoppingBasket() {
        items = new ArrayList<>();
    }

    public BigDecimal totalPrice() {
        return priceWithoutDiscount()
                .subtract(this.totalDiscount());
    }

    private BigDecimal priceWithoutDiscount() {
        return items.stream()
                .map(Item::unitPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    protected BigDecimal totalDiscount() {
        return BigDecimal.ZERO;
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

    public long applicableDiscount() {
        if (priceWithoutDiscount().compareTo(BigDecimal.valueOf(200)) > 0)
            return 10;
        if (priceWithoutDiscount().compareTo(BigDecimal.valueOf(100)) > 0)
            return 5;
        return 0;
    }
}
