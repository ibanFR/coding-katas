package com.ibanfr.shoppingbasket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    @DisplayName("should create an Item with it's unit price")
    void should_create_an_Item_with_its_unit_price() {

        //given
        BigDecimal unitPrice = BigDecimal.valueOf(100);

        //when
        Item item = new Item(unitPrice);

        //then
        assertThat(item.unitPrice())
                .as("should have a unit price of %d",unitPrice)
                .isEqualTo(unitPrice);
    }

}