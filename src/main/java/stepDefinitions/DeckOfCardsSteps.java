package stepDefinitions;

import io.cucumber.java.en.*;
import org.Test.Test.DeckOfCards_Decks;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.logging.Logger;

public class DeckOfCardsSteps {

    private static final Logger LOGGER = Logger.getLogger(DeckOfCardsSteps.class.getName());

    private DeckOfCards_Decks deck;
    private List<String> cardCodes;

    @Given("^I create a new deck with (\\d+) deck(?:s?) and joker is \"(true|false)\"$")
    public void i_create_a_new_deck_with_deck_s_and_joker_is(int deckCount, String jokerEnabled) {
        deck = new DeckOfCards_Decks(deckCount, jokerEnabled);
        Assertions.assertNotNull(deck.getDeckId(), "Deck ID should not be null");
        LOGGER.info("Created deck ID: " + deck.getDeckId());
    }

    @When("the deck_Id is valid")
    public void the_deck_id_is_valid() {
        Assertions.assertNotNull(deck.getDeckId(), "Deck ID should not be null");
    }

    @When("I shuffle the deck")
    public void i_shuffle_the_deck() {
        boolean shuffled = deck.shuffleDeck();
        Assertions.assertTrue(shuffled, "Shuffle should be successful");
        LOGGER.info("Deck shuffled successfully: " + deck.getDeckId());
    }

    @Then("the shuffle should be successful")
    public void the_shuffle_should_be_successful() {
        LOGGER.info("Shuffle operation was successful.");
    }

    @When("I draw {int} cards from the deck")
    public void i_draw_cards_from_the_deck(int cardsToDraw) {
        cardCodes = deck.drawCards(cardsToDraw);
        Assertions.assertNotNull(cardCodes, "Card codes should not be null");
        Assertions.assertEquals(cardsToDraw, cardCodes.size(), "Expected number of cards to be drawn");
        LOGGER.info("Cards drawn from deck: " + cardCodes);
    }

    @Then("I should get {int} cards")
    public void i_should_get_cards(int expectedCount) {
        Assertions.assertEquals(expectedCount, cardCodes.size(), "Drawn card count should match");
    }

    @Then("the deck should contain {int} cards")
    public void the_deck_should_contain_cards(int expectedCardCount) {
        int remainingCards = deck.getRemainingCardsInDeck();
        Assertions.assertEquals(expectedCardCount, remainingCards, "Deck should contain expected number of cards");
    }

    @When("I add the drawn cards to the discard pile")
    public void i_add_the_drawn_cards_to_the_discard_pile() {
        boolean success = deck.addToDiscardPile(cardCodes);
        Assertions.assertTrue(success, "Adding to discard pile should be successful");
    }

    @Then("the discard pile should contain the added cards")
    public void the_discard_pile_should_contain_the_added_cards() {
        List<String> discardPileCards = deck.getDiscardPile();
        Assertions.assertNotNull(discardPileCards, "Discard pile should not be null");
        Assertions.assertTrue(discardPileCards.containsAll(cardCodes), "Discard pile should contain added cards");
        LOGGER.info("Cards in discard pile: " + discardPileCards);
    }

    @When("I return the cards from the discard pile to the deck")
    public void i_return_the_cards_from_the_discard_pile_to_the_deck() {
        boolean success = deck.returnCardsToDeck(cardCodes);
        Assertions.assertTrue(success, "Returning cards should be successful");
    }

    @Then("the discard pile should be empty")
    public void the_discard_pile_should_be_empty() {
        List<String> discardPileCards = deck.getDiscardPile();
        Assertions.assertTrue(discardPileCards == null || discardPileCards.isEmpty(), "Discard pile should be empty");
    }
}
