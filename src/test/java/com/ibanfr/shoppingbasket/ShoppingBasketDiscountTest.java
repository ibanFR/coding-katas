package com.ibanfr.shoppingbasket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingBasketDiscountTest {
    
    // system under test
    private ShoppingBasket shoppingBasket;

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
        Item itemA = new Item(BigDecimal.valueOf(10));

        //when
        shoppingBasket.addItem(itemA, 1);

        //then
        assertThat(shoppingBasket.totalPrice())
                .as("total price should be 10")
                .isEqualByComparingTo(BigDecimal.valueOf(10));
    }


    @ParameterizedTest(name = "Quantity of Item A should be {0}")
    @ValueSource(ints = {1, 2})
    @DisplayName("should return the quantity of the given item in the shopping basket")
    void should_return_the_quantity_of_the_given_item_in_the_shopping_basket(int quantity) {

        //given
        Item itemA = new Item(BigDecimal.valueOf(10));

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
        Item itemA = new Item(BigDecimal.valueOf(10));
        Item itemB = new Item(BigDecimal.valueOf(25));

        //when
        shoppingBasket.addItem(itemA, 1);
        shoppingBasket.addItem(itemB, 1);

        //then
        assertThat(shoppingBasket.quantityOf(itemB))
                .as("Quantity of Item B should be 1")
                .isOne();
    }

    @Test
    @DisplayName("should have a total price of 35$ when Item A and Item B are added to the shopping basket")
    void should_have_a_total_price_of_35$_when_Item_A_and_Item_B_are_added_to_the_shopping_basket() {

        //given
        Item itemA = new Item(BigDecimal.valueOf(10));
        Item itemB = new Item(BigDecimal.valueOf(25));

        //when
        shoppingBasket.addItem(itemA, 1);
        shoppingBasket.addItem(itemB, 1);

        //then
        assertThat(shoppingBasket.totalPrice())
                .as("total price should be 350")
                .isEqualByComparingTo(BigDecimal.valueOf(35));
    }

    @Test
    @DisplayName("applicable discount should be 0 when total price is less than 100$")
    void applicable_discount_should_be_0_when_total_price_is_less_than_100$() {

        //then
        assertThat(shoppingBasket.applicableDiscount())
                .as("applicable discount should be 0")
                .isZero();
    }

    @Test
    @DisplayName("should qualify for 5% discount when adding Item D with unit price 101$")
    void should_qualify_for_5_discount_when_adding_Item_D_with_unit_price_101$() {

        //given
        Item itemD = new Item(BigDecimal.valueOf(101));

        //when
        shoppingBasket.addItem(itemD, 1);

        //then
        assertThat(shoppingBasket.applicableDiscount())
                .as("Discount should be 5")
                .isEqualTo(5);
    }

    @Test
    @DisplayName("should qualify for 10% discount when total price is greater than 200")
    void should_qualify_for_10_discount_when_total_price_is_greater_than_200() {

        //given
        Item itemE = new Item(BigDecimal.valueOf(201));

        //when
        shoppingBasket.addItem(itemE, 1);

        //then
        assertThat(shoppingBasket.applicableDiscount())
                .as("Discount should be 10%")
                .isEqualTo(10);

    }

    @Test
    @DisplayName("total discount should be 0 when price without discount is less than 100$")
    void total_discount_should_be_0_when_price_without_discount_is_less_than_100$() {

        //then
        assertThat(shoppingBasket.totalDiscount())
                .as("Not implemented")
                .isEqualByComparingTo(BigDecimal.ZERO);
    }

    @ParameterizedTest(name = "total discount should be {1} when price without discount is {0}$")
    @MethodSource("argumentsForTotalDiscount")
    @DisplayName("should calculate total discount")
    void should_calculate_total_discount( int unitPrice, double totalDiscount) {

        //given
        Item anItem = new Item(BigDecimal.valueOf(unitPrice));

        //when
        shoppingBasket.addItem(anItem, 1);

        //then
        assertThat(shoppingBasket.totalDiscount())
                .isEqualByComparingTo(BigDecimal.valueOf(totalDiscount));
    }

    public static Stream<Arguments> argumentsForTotalDiscount() {
        return Stream.of(
                Arguments.of(101, 5.05),
                Arguments.of(201, 20.1)
        );
    }

    @Test
    @DisplayName("total price is 104,5$ when adding 11 times Item A")
    void total_price_is_1045_when_adding_11_times_Item_A() {

        //given
        Item itemA = new Item(BigDecimal.valueOf(10));

        //when
        shoppingBasket.addItem(itemA, 11);

        //then
        assertThat(shoppingBasket.totalPrice())
                .as("total price should be 1045")
                .isEqualByComparingTo(BigDecimal.valueOf(104.5));

    }

    @Test
    @DisplayName("total price is 151.94$ when adding 5 times Item A with unit price 10$, 2 times Item B with unit price 25$ and 6 times Item C with unit price 9.99$")
    void total_price_should_be_151_94$() {

        //test fixture
        Item itemA = new Item(BigDecimal.valueOf(10));
        Item itemB = new Item(BigDecimal.valueOf(25));
        Item itemC = new Item(BigDecimal.valueOf(9.99));

        //when
        shoppingBasket.addItem(itemA, 5);
        shoppingBasket.addItem(itemB, 2);
        shoppingBasket.addItem(itemC, 6);

        //then
        assertThat(shoppingBasket.totalPrice())
                .as("should have a total price of 151.94$")
                .isEqualTo(BigDecimal.valueOf(151.94));
    }
}
