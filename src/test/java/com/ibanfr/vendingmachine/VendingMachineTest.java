package com.ibanfr.vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
                    new Product(1, "cola", BigDecimal.valueOf(1.00)),
                    new Product(2, "chips", BigDecimal.valueOf(0.50)),
                    new Product(3, "candy", BigDecimal.valueOf(0.65))
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


}
