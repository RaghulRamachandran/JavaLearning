package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.Test.Test.DeckOfCards_Decks;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DeckOfCardsSteps {
    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    private static String deckId;
    private static List<String> cardCodes;
    private static final Logger LOGGER = Logger.getLogger(DeckOfCardsSteps.class.getName());
    DeckOfCards_Decks deck = new DeckOfCards_Decks();

    @Given("^I create a new deck with (\\d+) deck(?:s?) and joker is \"(true|false)\"$")
    public void i_create_a_new_deck_with_deck_s_and_joker_is(int deckCount, String jokerEnabled) {
        deckId = deck.getNewDeck(deckCount, jokerEnabled);
        Assert.assertNotNull("Deck ID should not be null", deckId);
        LOGGER.info("Created deck ID: " + deckId);
    }

    @When("the deck_Id is valid")
    public void the_deck_id_is_valid() {
        Assert.assertNotNull("Deck ID should be generated", deckId);
    }

    @When("I shuffle the deck")
    public void i_shuffle_the_deck() {
        Assert.assertTrue("Shuffle should be successful", deck.shuffleDeck(deckId));
        LOGGER.info("Deck shuffled successfully: " + deckId);
    }

    @Then("the shuffle should be successful")
    public void the_shuffle_should_be_successful() {
        LOGGER.info("Shuffle operation was successful.");
    }

    @When("I draw {int} cards from the deck")
    public void i_draw_cards_from_the_deck(int cardsToDraw) {
        cardCodes = deck.drawCards(deckId, cardsToDraw);
        Assert.assertNotNull("Card codes should not be null", cardCodes);
        Assert.assertEquals("Expected number of cards to be drawn", cardsToDraw, cardCodes.size());
        LOGGER.info("Cards drawn from deck " + cardCodes.toString());
    }

    @Then("I should get {int} cards")
    public void i_should_get_cards(int expectedCount) {
        Assert.assertEquals("Drawn card count should match", expectedCount, cardCodes.size());
    }

    @When("I add the drawn cards to the discard pile")
    public void i_add_the_drawn_cards_to_the_discard_pile() {
        Assert.assertTrue("Adding to discard pile should be successful", deck.addToDiscardPile(deckId, cardCodes));
    }

    @Then("the discard pile should contain the added cards")
    public void the_discard_pile_should_contain_the_added_cards() {
        List<String> discardPileCards = deck.getDiscardPile(deckId);
        Assert.assertNotNull("Discard pile should not be null", discardPileCards);
        Assert.assertTrue("Discard pile should contain cards", discardPileCards.containsAll(cardCodes));
        LOGGER.info("Cards in discard " + discardPileCards.toString());
    }

    @When("I return the cards from the discard pile to the deck")
    public void i_return_the_cards_from_the_discard_pile_to_the_deck() {
        Assert.assertTrue("Returning cards should be successful", deck.returnCardsToDeck(deckId, cardCodes));
    }

    @Then("the discard pile should be empty")
    public void the_discard_pile_should_be_empty() {
        List<String> discardPileCards = deck.getDiscardPile(deckId);
        Assert.assertTrue("Discard pile should be empty", discardPileCards == null || discardPileCards.isEmpty());
    }

    @Then("the deck should contain {int} cards")
    public void the_deck_should_contain_cards(int expectedCardCount) {
        int remainingCards = deck.getRemainingCardsInDeck(deckId);
        Assert.assertEquals("Deck should contain expected number of cards", expectedCardCount, remainingCards);
    }
}