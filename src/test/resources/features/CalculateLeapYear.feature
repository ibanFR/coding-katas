Feature: Calculate Leap Year

  Write a function that returns true or false depending on whether its input integer is a leap year or not.

  A leap year is defined as one that is divisible by 4, but is not otherwise divisible by 100 unless it is also divisible
  by 400.

  For example, 2001 is a typical common year and 1996 is a typical leap year, whereas 1900 is an atypical common year and
  2000 is an atypical leap year.

  Rule: A Leap Year is divisible by 4

    Scenario: typical leap year
      Given the year is 1996
      When I check if the year is a Leap Year
      Then the result should be true

  Rule: A Leap Year is NOT divisible by 100

    Scenario: atypical Common Year
      Given the year is 1900
      When I check if the year is a Leap Year
      Then the result should be false

  Rule: A Leap Year is divisible by 400

    Scenario: atypical Leap Year
      Given the year is 2000
      When I check if the year is a Leap Year
      Then the result should be true
