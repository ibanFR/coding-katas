package com.ibanfr.shoppingbasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingBasketDiscountTest {
    
    // system under test
    private ShoppingBasket shoppingBasket;

    // TEST LIST
    // [X] - Total price should be 0$ when basket is empty
    // [X] - Total price should be 10$ when adding Item A to the shopping basket
    // [] - should have a total price of 35$ when Item A and Item B are added to the shopping basket
    // [X] - quantity of Item A should be 1 when Item A is added to the shopping basket
    // [X] - quantity of Item A should be 2 when Item A is added twice the shopping basket
    // [X] - quantity of Item B should be 1 when Item A and Item B are added to the shopping basket
    // [] - should qualify for 5% discount when adding Item D with unit price 101$
    // [] - total price is 104,5$ when adding 11 times Item A
    // [] - should qualify for 5% discount when adding 11 times Item A
    // [] - should qualify for 10% discount when adding 21 times Item A
    // [] - total price is 189$ when adding 21 times Item A

    @BeforeEach
    void setUp() {
        shoppingBasket = new ShoppingBasket();
    }

    @Test
    @DisplayName("should have a total price of 0$ when basket is empty")
    void should_have_a_total_price_of_0$_when_basket_is_empty() {

        //then
        assertThat(shoppingBasket.totalPrice())
                .as("Total price should be 0")
                .isZero();
    }

    @Test
    @DisplayName("should have a total price of 10$ when adding Item A to the shopping basket")
    void should_have_a_total_price_of_10$_when_adding_Item_A_to_the_shopping_basket() {

        //given
        Item itemA = new Item(100);

        //when
        shoppingBasket.addItem(itemA, 1);

        //then
        assertThat(shoppingBasket.totalPrice())
                .as("total price should be 100")
                .isEqualTo(100);
    }


    @ParameterizedTest(name = "Quantity of Item A should be {0}")
    @ValueSource(ints = {1, 2})
    @DisplayName("should return the quantity of the given item in the shopping basket")
    void should_return_the_quantity_of_the_given_item_in_the_shopping_basket(int quantity) {

        //given
        Item itemA = new Item(100);

        //when
        shoppingBasket.addItem(itemA, quantity);

        //then
        assertThat(shoppingBasket.quantityOf(itemA))
                .as("Quantity of Item A should be %d", quantity)
                .isEqualTo(quantity);
    }

    @Test
    @DisplayName("quantity of Item B should be 1 when Item A and Item B are added to the shopping basket")
    void quantity_of_Item_B_should_be_1_when_Item_A_and_Item_B_are_added_to_the_shopping_basket() {

        //given
        Item itemA = new Item(100);
        Item itemB = new Item(250);

        //when
        shoppingBasket.addItem(itemA, 2);
        shoppingBasket.addItem(itemB, 1);

        //then
        assertThat(shoppingBasket.quantityOf(itemB))
                .as("Quantity of Item B should be 1")
                .isOne();
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
