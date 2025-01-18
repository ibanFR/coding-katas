package com.ibanfr.leapyears;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapYearSteps {

    private int year;
    private boolean isLeapYear;

    @Given("the year is {int}")
    public void theYearIs(int year) {
        this.year = year;
    }

    @When("I check if the year is a Leap Year")
    public void iCheckIfItIsALeapYear() {
        isLeapYear = LeapYearCalculator.isLeapYear(year);
    }

    @Then("the result should be {booleanValue}")
    public void theResultShouldBeTrue(boolean result) {
        assertThat(isLeapYear)
                .isEqualTo(result);
    }

    @ParameterType("true|false")
    public boolean booleanValue(String value) {
        return Boolean.parseBoolean(value);
    }
}
