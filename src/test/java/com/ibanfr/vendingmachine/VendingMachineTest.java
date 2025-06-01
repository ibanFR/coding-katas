package com.ibanfr.vendingmachine;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

class VendingMachineTest {

    //system under test
    VendingMachine vendingMachine;

    @Test
    @DisplayName("should create a vending machine with the given display")
    void should_create_a_vending_machine_with_the_given_display() {

        //given
        Display display = new LCDDisplay();

        //when
        vendingMachine = new VendingMachine(display);

        //then
        assertThat(vendingMachine.display)
                .isEqualTo(display);
    }

    @Test
    @DisplayName("should display INSERT COIN when there are no coins inserted")
    void should_display_INSERT_COIN_when_there_are_no_coins_inserted() {

        //given
        Display display = new LCDDisplay();
        //when
        vendingMachine = new VendingMachine(display);

        //then
        assertThat(vendingMachine.display())
                .isEqualTo("INSERT COIN");
    }

    @Test
    @DisplayName("current amount should be 0 when there are no coins inserted")
    void current_amount_should_be_0_when_there_are_no_coins_inserted() {

        //when
        vendingMachine = new VendingMachine(new LCDDisplay());

        //then
        assertThat(vendingMachine.currentAmount())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("when inserting 1 nickel the current amount should be 0.05")
    void when_inserting_1_nickel_the_current_amount_is_005(){

        //given
        vendingMachine = new VendingMachine(new LCDDisplay());

        //when
        vendingMachine.insertCoin(Coin.NICKEL);

        //then
        assertThat(vendingMachine.currentAmount())
                .isEqualTo(BigDecimal.valueOf(0.05));
    }

    @Test
    @DisplayName("when inserting 1 nickel and 1 dime the current amount should be 0.15")
    void when_inserting_1_nickel_and_1_dime_the_current_amount_should_be_015() {

        //given
        vendingMachine = new VendingMachine(new LCDDisplay());

        //when
        vendingMachine.insertCoin(Coin.NICKEL);
        vendingMachine.insertCoin(Coin.DIME);

        //then
        assertThat(vendingMachine.currentAmount())
                .isEqualTo(BigDecimal.valueOf(0.15));
    }

    @Test
    @DisplayName("when inserting 1 penny the current amount should be 0.00")
    void when_inserting_1_penny_the_current_amount_should_be_000(){

        //given
        vendingMachine = new VendingMachine(new LCDDisplay());

        //when
        vendingMachine.insertCoin(Coin.PENNY);

        //then
        assertThat(vendingMachine.currentAmount())
                .isEqualTo(BigDecimal.ZERO);
    }

    @Test
    @DisplayName("insert coin 1 penny, returned coins should be 0.01")
    void insert_coin_1_penny_returned_coins_should_be_001(){

        //given
        vendingMachine = new VendingMachine(new LCDDisplay());

        //when
        vendingMachine.insertCoin(Coin.PENNY);

        //then
        assertThat(vendingMachine.returnAmount())
                .isEqualTo(BigDecimal.valueOf(0.01));
    }

    @Test
    @DisplayName("when inserting 1 nickel the machine displays $0.05")
    void when_inserting_1_nickel_the_machine_displays_005(){

        //given
        vendingMachine = new VendingMachine(new LCDDisplay());

        //when
        vendingMachine.insertCoin(Coin.NICKEL);

        //then
        assertThat(vendingMachine.display())
                .isEqualTo("$0.05");
    }

    @Test
    @DisplayName("when inserting 1 dime the machine displays $0.10")
    void when_inserting_1_nickel_the_machine_displays_010(){

        //given
        vendingMachine = new VendingMachine(new LCDDisplay());

        //when
        vendingMachine.insertCoin(Coin.DIME);

        //then
        assertThat(vendingMachine.display())
                .isEqualTo("$0.10");
    }

    @Nested
    @DisplayName("Return coins")
    class Return_coins {

        @Test
        @DisplayName("When there are no coins inserted the machine should return 0.00")
        void when_there_are_no_coins_inserted_the_machine_should_return_000(){

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //when
            vendingMachine.returnCoins();

            //then
            assertThat(vendingMachine.returnAmount()).isEqualTo(BigDecimal.ZERO);
        }

        @Test
        @DisplayName("when 1 nickel is inserted the machine should return 0.05")
        void when_1_nickel_is_inserted_the_machine_should_return_005(){

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.insertCoin(Coin.NICKEL);

            //when
            vendingMachine.returnCoins();

            //then
            assertThat(vendingMachine.returnAmount()).isEqualTo(BigDecimal.valueOf(0.05));
        }

        @Test
        @DisplayName("when returning coins the current amount should be 0.00")
        void when_returning_coins_the_current_amount_should_be_000(){

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.insertCoin(Coin.NICKEL);

            //when
            vendingMachine.returnCoins();

            //then
            assertThat(vendingMachine.currentAmount()).isEqualTo(BigDecimal.ZERO);
        }

        @Test
        @DisplayName("when returning coins the display should show INSERT COIN")
        void when_returning_coins_the_display_should_show_INSERT_COIN() {

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.insertCoin(Coin.NICKEL);

            //when
            vendingMachine.returnCoins();

            //then
            assertThat(vendingMachine.display()).isEqualTo("INSERT COIN");
        }




    }

    @Nested
    @DisplayName("Add products")
    class Add_products {

        //TEST LIST
        // add products [cola, chips, candy] should add products to the vending machine

        @Test
        @DisplayName("add products [cola, chips, candy] should add products to the vending machine")
        void add_products_cola_chips_candy_should_add_products_to_the_vending_machine() {

            //test fixture
            List<Product> productList = List.of(
                    new Product(1, 10, "cola", BigDecimal.valueOf(1.00)),
                    new Product(2, 10,"chips", BigDecimal.valueOf(0.50)),
                    new Product(3, 10,"candy", BigDecimal.valueOf(0.65))
            );

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //when
            vendingMachine.addProducts(productList);

            //then
            assertThat(vendingMachine.listProducts())
                    .containsAll(productList);
        }


    }

    @Nested
    @DisplayName("Select a product when sufficient amount is inserted")
    class Select_a_product_sufficient_amount_is_inserted {

        @BeforeEach
        void setUp() {
            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.addProducts(List.of(
                    new Product(1, 1, "chips", BigDecimal.valueOf(0.50))
            ));

            //given insert $0.50
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);

            //when
            vendingMachine.selectProduct(1);
        }

        @Test
        @DisplayName("should set current amount to 0.00")
        void should_set_current_amount_to_000() {

            //then
            assertThat(vendingMachine.currentAmount()).isZero();
        }

        @Test
        @DisplayName("should reduce product quantity one item")
        void should_reduce_product_quantity_one_item() {

            //then
            assertThat(vendingMachine.listProducts())
                    .filteredOn(product -> product.name().equals("chips"))
                    .extracting(Product::quantity)
                    .containsExactly(0);
        }

        @Test
        @DisplayName("should display THANK YOU for 5 seconds, then INSERT COIN")
        void should_display_THANK_YOU_for_5_seconds_then_INSERT_COIN(){

            //then
            assertThat(vendingMachine.display())
                    .isEqualTo("THANK YOU");
            //then
            await().atLeast(Duration.ofSeconds(5))
                    .until(() -> vendingMachine.display().equals("INSERT COIN"));
        }
    }

    @Nested
    @DisplayName("Select a product when NOT sufficient amount")
    class Select_a_product_when_NOT_sufficient_amount {

        @Test
        @DisplayName("should display PRICE of the selected item")
        void should_display_PRICE_of_the_selected_item() {

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.addProducts(List.of(
                    new Product(1, 1, "chips", BigDecimal.valueOf(0.50))
            ));
            //when
            vendingMachine.selectProduct(1);

            //then
            assertThat(vendingMachine.display())
                    .isEqualTo("PRICE $0.50");
            //then
            await().atLeast(Duration.ofSeconds(5))
                    .until(() -> vendingMachine.display().equals("INSERT COIN"));
        }

        @Test
        @DisplayName("when coins are inserted, should display current amount after 5 seconds")
        void should_display_INSERT_COINS() {

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.addProducts(List.of(
                    new Product(1, 1, "chips", BigDecimal.valueOf(0.50))
            ));
            //given insert $0.25
            vendingMachine.insertCoin(Coin.QUARTER);

            //when
            vendingMachine.selectProduct(1);

            //then
            await().atLeast(Duration.ofSeconds(5))
                    .until(() -> vendingMachine.display().equals("$0.25"));
        }


    }

    @Nested
    @DisplayName("Select a product return change")
    class Select_a_product_return_change {

        @Test
        @DisplayName("should return change of $0.25")
        void should_return_change_of_025() {

            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.addProducts(List.of(
                    new Product(1, 1, "chips", BigDecimal.valueOf(0.50))
            ));

            //given insert $0.75
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);

            //when
            vendingMachine.selectProduct(1);

            //then
            assertThat(vendingMachine.returnAmount()).isEqualTo(BigDecimal.valueOf(0.25));
        }


    }

    @Nested
    @DisplayName("Is Sufficient amount for product")
    class Is_Sufficient_amount_for_product {

        @BeforeEach
        void setUp() {
            //given
            vendingMachine = new VendingMachine(new LCDDisplay());

            //given
            vendingMachine.addProducts(List.of(
                    new Product(1, 1, "chips", BigDecimal.valueOf(0.50))
            ));
        }

        @Test
        @DisplayName("should return true when current amount is greater than or equal to product price")
        void should_return_true_when_current_amount_is_greater_than_or_equal_to_product_price() {

            //given insert $0.50
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);

            //when
            boolean result = vendingMachine.sufficientAmountForProduct(1);

            //then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("should return false when current amount is less than product price")
        void should_return_false_when_current_amount_is_less_than_product_price() {

            //given insert $0.25
            vendingMachine.insertCoin(Coin.QUARTER);

            //when
            boolean result = vendingMachine.sufficientAmountForProduct(1);

            //then
            assertThat(result).isFalse();
        }


    }


}
