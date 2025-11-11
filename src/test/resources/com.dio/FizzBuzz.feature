Feature: Fizzbuzz
    Prints a sequence of N numbers, 
    but for multiples of 3 prints Fizz 
    and for multiples of 5 prints Buzz
    and for multiples of 3 and 5 prints FizzBuzz

  Background: run in all scenarios
    Given the background flag is set
    And another flag is set

  Scenario Outline: FizzBuzz a number
    Given a number selected by the user - <Number>
    When the user clicked te FizzBuzz button
    Then the program prints <Result>
    Examples:
    | Number | Result |
    | 2      | 2      |
    | 3      | Fizz   |
    | 6      | Fizz   |
    | 5      | Buzz   |
    | 10     | Buzz   |
    | 15     | FizzBuzz |
    And validate background flags

    Scenario: FizzBuzz sequence
      Given the user wants a sequence of 15 numbers
      When the user clicked the FizzBuzzSequence Button
      Then the program printed:
      | 1 |
      | 2 |
      | Fizz |
      | 4 |
      | Buzz |
      | Fizz |
      | 7 |
      | 8 |
      | Fizz |
      | Buzz |
      | 11 |
      | Fizz |
      | 13 |
      | 14 |
      | FizzBuzz |
      And validate background flags

      Scenario: Table advanced
        Then the table must be converted:
        | Test | Address | test@email.com | 23 |
        | Test2 | Address2 | test2@email.com | 44 |
        | Test3 | Address3 | test3@email.com | 58 |
        And validate background flags