package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class DeckOfCardsSteps {
    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    private static String deckId;
    private static List<String> cardCodes;
    private static final Logger LOGGER = Logger.getLogger(DeckOfCardsSteps.class.getName());

    @Given("^I create a new deck with (\\d+) deck(?:s?) and joker is \"(true|false)\"$")
    public void i_create_a_new_deck_with_deck_s_and_joker_is(int deckCount, String jokerEnabled) {
        String newDeckUrl = BASE_URI + "new/?deck_count=" + deckCount + "&jokers_enabled=" + jokerEnabled;
        Response response = given()
                .when()
                .get(newDeckUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        deckId = response.path("deck_id");
        Assert.assertNotNull("Deck ID should not be null", deckId);
        LOGGER.info("Created deck ID: " + deckId);
    }

    @Then("the deck ID should be generated")
    public void the_deck_id_should_be_generated() {
        Assert.assertNotNull("Deck ID should be generated", deckId);

    }

    @When("I shuffle the deck")
    public void i_shuffle_the_deck() {
        String shuffleUrl = BASE_URI + deckId + "/shuffle/";
        Response response = given()
                .when()
                .get(shuffleUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        Assert.assertTrue("Shuffle should be successful", response.path("shuffled"));
        LOGGER.info("Deck shuffled successfully: " + deckId);
    }

    @Then("the shuffle should be successful")
    public void the_shuffle_should_be_successful() {
        LOGGER.info("Shuffle operation was successful.");
    }

    @When("I draw {int} cards from the deck")
    public void i_draw_cards_from_the_deck(int cardsToDraw) {
        String drawCardsUrl = BASE_URI + deckId + "/draw/?count=" + cardsToDraw;
        Response response = given()
                .when()
                .get(drawCardsUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsonPath = response.jsonPath();
        cardCodes = new ArrayList<>(jsonPath.getList("cards.code"));
        LOGGER.info( cardCodes.toString());
        Assert.assertNotNull("Card codes should not be null", cardCodes);
        Assert.assertEquals("Expected number of cards to be drawn", cardsToDraw, cardCodes.size());
    }
    @Then("I should get {int} cards")
    public void i_should_get_cards(int expectedCount) {
        Assert.assertEquals("Drawn card count should match", expectedCount, cardCodes.size());
    }

    @When("I add the drawn cards to the discard pile")
    public void i_add_the_drawn_cards_to_the_discard_pile() {
        String addToPileUrl = BASE_URI + deckId + "/pile/discard/add/?cards=" + String.join(",", cardCodes);
        Response response = given()
                .when()
                .get(addToPileUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        Assert.assertTrue("Adding to discard pile should be successful", response.path("success"));
    }

    @Then("the discard pile should contain the added cards")
    public void the_discard_pile_should_contain_the_added_cards() {
        String discardPileUrl = BASE_URI + deckId + "/pile/discard/list";
        Response response = given()
                .when()
                .get(discardPileUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        List<String> discardPileCards = response.jsonPath().getList("piles.discard.cards.code");
        Assert.assertNotNull("Discard pile should not be null", discardPileCards);
        LOGGER.info(discardPileCards.toString());
        LOGGER.info(cardCodes.toString());
        Assert.assertTrue("Discard pile should contain cards", discardPileCards.containsAll(cardCodes));
        LOGGER.info(discardPileCards.toString());
    }

    @When("I return the cards from the discard pile to the deck")
    public void i_return_the_cards_from_the_discard_pile_to_the_deck() {
        String returnCardsUrl = BASE_URI + deckId + "/pile/discard/return/?cards=" + String.join(",", cardCodes);
        Response response = given()
                .when()
                .get(returnCardsUrl)
                .then()
                .statusCode(200)
                .extract().
                response();
        Assert.assertTrue("Returning cards should be successful", response.path("success"));
    }

    @Then("the discard pile should be empty")
    public void the_discard_pile_should_be_empty() {
        String discardPileUrl = BASE_URI + deckId + "/pile/discard/list";
        Response response = given()
                .when().
                get(discardPileUrl).
                then().
                statusCode(200).
                extract()
                .response();
        List<String> discardPileCards = response.jsonPath().getList("piles.discard.cards");
        Assert.assertTrue("Discard pile should be empty", discardPileCards == null || discardPileCards.isEmpty());

    }

    @Then("the deck should contain {int} cards")
    public void the_deck_should_contain_cards(int expectedCardCount) {
        String deckInfoUrl = BASE_URI + deckId;
        Response response = given()
                .when()
                .get(deckInfoUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        int remainingCards = response.path("remaining");
        Assert.assertEquals("Deck should contain expected number of cards", expectedCardCount, remainingCards);
    }

    @Then("the deck should contain {int} cards including jokers")
    public void the_deck_should_contain_cards_including_jokers(int expectedCardCount) {
        String deckInfoUrl = BASE_URI + deckId;
        Response response = given()
                .when()
                .get(deckInfoUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        int remainingCards = response.path("remaining");
        Assert.assertEquals("Deck should contain expected number of cards including jokers", expectedCardCount, remainingCards);
    }
}
