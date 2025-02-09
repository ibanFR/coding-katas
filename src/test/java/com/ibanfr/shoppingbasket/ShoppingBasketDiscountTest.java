package com.ibanfr.shoppingbasket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingBasketDiscountTest {


    // TEST LIST
    // [X] - Total price should be 0$ when basket is empty
    // [] - Total price should be 10$ when adding Item A to the shopping basket
    // [] - should have a total price of 35$ when Item A and Item B are added to the shopping basket
    // [] - quantity of Item A should be 1 when Item A is added to the shopping basket
    // [] - quantity of Item B should be 1 when Item A and Item B are added to the shopping basket
    // [] - should qualify for 5% discount when adding Item D with unit price 101$
    // [] - total price is 104,5$ when adding 11 times Item A
    // [] - should qualify for 5% discount when adding 11 times Item A
    // [] - should qualify for 10% discount when adding 21 times Item A
    // [] - total price is 189$ when adding 21 times Item A

    @Test
    @DisplayName("should have a total price of 0$ when basket is empty")
    void should_have_a_total_price_of_0$_when_basket_is_empty() {

        //given
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        //then
        assertThat(shoppingBasket.totalPrice())
                .as("Total price should be 0")
                .isZero();
    }

    //@Test
    //@DisplayName("should qualify for 5% discount")
    //void should_qualify_for_5_discount() {
    //
    //    //test fixture
    //    Item itemA = new Item("A", 100);
    //    Item itemB = new Item("B", 250);
    //    Item itemC = new Item("C", 999);
    //
    //    //given
    //    ShoppingBasket shoppingBasket = new ShoppingBasket();
    //
    //    //when
    //    shoppingBasket.addItem(itemA, 5);
    //    shoppingBasket.addItem(itemB, 2);
    //    shoppingBasket.addItem(itemC, 6);
    //
    //    //then
    //    assertThat(shoppingBasket.calculateDiscount())
    //            .as("should qualify for a 5% discount")
    //            .isEqualTo(5);
    //    //then
    //    assertThat(shoppingBasket.totalPrice())
    //            .as("should have a total price of 15194")
    //            .isEqualTo(15194);
    //}
}
