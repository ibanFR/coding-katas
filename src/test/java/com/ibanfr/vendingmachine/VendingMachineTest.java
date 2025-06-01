package com.ibanfr.vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {

    //system under test
    VendingMachine vendingMachine;

    @Test
    @DisplayName("should create a vending machine with the given display")
    void should_create_a_vending_machine_with_the_given_display() {

        //given
        Display display = new FakeDisplay();

        //when
        vendingMachine = new VendingMachine(display);

        //then
        assertThat(vendingMachine.display)
                .isEqualTo(display);
    }


// [] - should create a vending machine with the given Display
// [] - When there are no coins inserted => the machine displays INSERT COIN.
// [] - When there are no coins inserted => current amount should be 0.00
// [] - insert coin 1 nickel => the machine displays $0.05
// [] - insert coin 1 dime => the machine displays $0.10
// [] - insert coin 1 penny => coin is rejected and placed in the coin return
}
