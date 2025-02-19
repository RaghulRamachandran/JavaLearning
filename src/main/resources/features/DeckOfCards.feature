Feature: Deck of Cards API Testing

  Scenario Outline: Create a new deck
    Given I create a new deck with <deck_count> deck and joker is "<joker_enabled>"
    Then the deck ID should be generated

    Examples:
      | deck_count | joker_enabled |
      | 1          | false         |
      | 2          | false         |

  Scenario: Shuffle the deck
    Given I create a new deck with 1 deck and joker is "false"
    When I shuffle the deck
    Then the shuffle should be successful

  Scenario Outline: Draw cards from the deck
    Given I create a new deck with <deck_count> deck and joker is "<joker_enabled>"
    When I draw <cards_to_draw> cards from the deck
    Then I should get <cards_to_draw> cards

    Examples:
      | deck_count | joker_enabled | cards_to_draw |
      | 1          | false         | 5             |
      | 2          | false         | 10            |


  Scenario Outline: Add drawn cards to the discard pile
    Given I create a new deck with 1 deck and joker is "<joker_enabled>"
    And I shuffle the deck
    When I draw <cards_to_draw> cards from the deck
    When I add the drawn cards to the discard pile
    Then the discard pile should contain the added cards

    Examples:
    Examples:
      | joker_enabled|cards_to_draw|
      | false        | 5           |
      | false        | 10          |

  Scenario Outline: Return cards from the discard pile to the deck
    Given I create a new deck with 1 deck and joker is "<joker_enabled>"
    And I shuffle the deck
    When I draw <cards_to_draw> cards from the deck
    And I add the drawn cards to the discard pile
    And I return the cards from the discard pile to the deck
    Then the discard pile should be empty
    Examples:
      | joker_enabled | cards_to_draw |
      | false         | 5             |
      | false         | 10            |

  Scenario Outline: Create a deck with jokers
    Given I create a new deck with <deck_count> deck and joker is "<joker_enabled>"
    Then the deck should contain 54 cards

    Examples:
      | deck_count | joker_enabled|
      | 1          | true         |



