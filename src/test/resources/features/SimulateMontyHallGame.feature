Feature: Simulate Monty Hall game

  Background: Game set-up
    Given a player plays the Monty Hall game 1000 times

  Scenario: Player keeps his first choice
    Given a car and two goats are randomly placed behind three doors
    And the player chooses any of the three doors
    When the host opens a different door revealing a goat
    And the player keeps his first choice
    Then the player should win 333 games

  Scenario: Player changes his first choice
    Given a car and two goats are randomly placed behind three doors
    And the player chooses any of the three doors
    When the host opens a different door revealing a goat
    And the player changes his first choice
    Then the player should win 666 games

  Scenario: Strategy comparison for 1000 games
    Given a car and two goats are randomly placed behind three doors
    And the player chooses any of the three doors
    When the host opens a different door revealing a goat
    Then the player should win 666 games changing his first choice
    And the player shoud win 333 games keeping his first choice











