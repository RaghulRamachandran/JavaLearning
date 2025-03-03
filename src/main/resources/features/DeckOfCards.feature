Feature: Deck of Cards API Testing

  Scenario Outline: Create a new deck
    Given I create a new deck with <deck_count> deck and joker is "<joker_enabled>"
    When the deck_Id is valid
    Then the deck should contain <card_count> cards

    Examples:
      | deck_count | joker_enabled | card_count |
      | 1          | false         | 52         |
      | 1          | true          | 54         |
      | 2          | false         | 104        |
      | 2          | true          | 108        |

  Scenario: Shuffle an existing deck of cards
    Given I create a new deck with 1 deck and joker is "false"
    When I shuffle the deck
    Then the shuffle should be successful

  Scenario Outline: Draw cards from the deck
    Given I create a new deck with <deck_count> deck and joker is "<joker_enabled>"
    When I draw <cards_to_draw> cards from the deck
    Then I should get <cards_to_draw> cards
    And the deck should contain <remaining_card_count> cards

    Examples:
      | deck_count | joker_enabled | cards_to_draw | remaining_card_count |
      | 1          | false         | 5             | 47                   |
      | 2          | false         | 10            | 94                   |

  Scenario Outline: Add drawn cards to the discard pile
    Given I create a new deck with 1 deck and joker is "<joker_enabled>"
    And I draw <cards_to_draw> cards from the deck
    When I add the drawn cards to the discard pile
    Then the discard pile should contain the added cards
    And the deck should contain <remaining_card_count> cards

    Examples:
      | joker_enabled | cards_to_draw | remaining_card_count |
      | false         | 5             | 47                   |
      | true          | 10            | 44                   |

  Scenario Outline: Return cards from the discard pile to the deck
    Given I create a new deck with 1 deck and joker is "<joker_enabled>"
    And I draw <cards_to_draw> cards from the deck
    And I add the drawn cards to the discard pile
    When I return the cards from the discard pile to the deck
    Then the discard pile should be empty
    And the deck should contain <original_card_count> cards

    Examples:
      | joker_enabled | cards_to_draw | original_card_count |
      | true         | 5             | 54                  |
      | false        | 10            | 52                  |
