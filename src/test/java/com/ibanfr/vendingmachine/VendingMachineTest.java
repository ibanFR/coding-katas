package com.ibanfr.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {

    //system under test
    VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine(new LCDDisplay());
    }

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



// [] - add to current amount - insert coin 1 nickel, 1 dime => current amount should be 0.015
// [] - insert coin 1 nickel => the machine displays $0.05
// [] - insert coin 1 dime => the machine displays $0.10
// [] - insert coin 1 penny => coin is rejected and placed in the coin return
}
