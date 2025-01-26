package org.Test;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import org.junit.runners.MethodSorters;
import java.util.logging.Logger;
import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeckOfCards {

    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    private static String deckId;
    private static String cardCodes;
    private static final Logger LOGGER = Logger.getLogger(DeckOfCards.class.getName());

    @Test
    public void test01_getNewDeck() {
        LOGGER.info("Test 1: Creating a new deck");
        deckId = GetNewDeck.getNewDeck();
        Assert.assertNotNull("Deck ID should not be null", deckId);
        LOGGER.info("Deck created successfully. Deck ID: " + deckId);
    }

    @Test
    public void test02_shuffleExistingDeck() {
        LOGGER.info("Test 2: Shuffling the deck");
        Assert.assertNotNull("Deck ID should not be null before shuffling", deckId);
        boolean shuffleSuccess = ShuffleExistingDeck.shuffleDeck(deckId);
        Assert.assertTrue("Shuffled deck should have success true", shuffleSuccess);
        LOGGER.info("Deck shuffled successfully.");
    }

    @Test
    public void test03_drawTwoCards() {
        LOGGER.info("Test 3: Drawing two cards from the deck");
        Assert.assertNotNull("Deck ID should not be null before drawing cards", deckId);

        String drawCardsUrl = BASE_URI + deckId + "/draw/?count=2";
        Response response = given()
                .when()
                .get(drawCardsUrl)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        String firstCardCode = jsonPath.getString("cards[0].code");
        String secondCardCode = jsonPath.getString("cards[1].code");
        cardCodes = firstCardCode + "," + secondCardCode;

        LOGGER.info("First card drawn: " + firstCardCode);
        LOGGER.info("Second card drawn: " + secondCardCode);
        LOGGER.info("Card codes: " + cardCodes);
    }

    @Test
    public void test04_addCardsToPile() {
        LOGGER.info("Test 4: Adding cards to discard pile");
        String cardsToAdd = cardCodes;
        String cardsToAddURL = BASE_URI + deckId + "/pile/discard/add/?cards=" + cardsToAdd;

        Response response = given()
                .when()
                .get(cardsToAddURL)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertTrue("Adding cards to pile should have success true", response.path("success"));
        LOGGER.info("Cards added to discard pile successfully.");
    }

    @Test
    public void test05_returnCardToDeck() {
        LOGGER.info("Test 5: Returning cards to the deck");
        String cardsToReturn = cardCodes;
        String cardsToReturnURL = BASE_URI + deckId + "/pile/discard/return/?cards=" + cardsToReturn;

        Response response = given()
                .when()
                .get(cardsToReturnURL)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertTrue("Returning cards to pile should have success true", response.path("success"));
        LOGGER.info("Cards returned to the deck successfully.");
    }

    @Test
    public void test06_deckWithJokers() {
        LOGGER.info("Test 6: Creating deck with jokers");
        int remainingCards = DeckWithJokers.createDeckWithJokers();
        Assert.assertEquals(54, remainingCards);
        LOGGER.info("Deck with jokers created successfully. Remaining cards: " + remainingCards);
    }
}
