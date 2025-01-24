Feature: DeckOfCards


  Scenario: Create a new Deck ID and shuffle it
    Given I create a new deck ID
    When I shuffle the deck
    Then the response should be "success"


  Scenario: Shuffle Existing Deck
    Given I have a deck ID "deck_id"
    When I call the API to shuffle the deck
    Then the API should shuffle the deck successfully
    And the response status code should be 200
    And the response should have "success" set to true

  Scenario: Draw Two Cards
    Given I have a deck ID "deck_id"
    When I call the API to draw two cards
    Then the API should return the details of two cards
    And the response status code should be 200
    And the response should contain the codes for the drawn cards

  Scenario: Add Cards to Pile
    Given I have a deck ID "deck_id" and card codes "card_codes"
    When I call the API to add cards to the discard pile
    Then the API should add the cards to the pile successfully
    And the response status code should be 200
    And the response should have "success" set to true

  Scenario: Return Cards to Deck
    Given I have a deck ID "deck_id" and card codes "card_codes"
    When I call the API to return cards from the discard pile to the deck
    Then the API should return the cards to the deck successfully
    And the response status code should be 200
    And the response should have "success" set to true

  Scenario: Create Deck with Jokers
    Given I want to create a new deck with jokers enabled
    When I call the API to create a new deck with jokers enabled
    Then the API should return a deck ID
    And the response status code should be 200
    And the number of remaining cards should be 54