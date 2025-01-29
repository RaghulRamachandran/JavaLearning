package org.Test;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import org.junit.runners.MethodSorters;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static io.restassured.RestAssured.given;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeckOfCards {

    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    private static String deckId;
    private static List<String> cardCodes;
    private static final Logger LOGGER = Logger.getLogger(DeckOfCards.class.getName());
    private int numberOfDecks = 1;
    private int numberOfCardsToDraw = 10;
    private List<String> deckIds = new ArrayList<>();
    String discardPileUrl = BASE_URI + deckId + "/pile/discard/list";

    @Test
    public void test01_getNewDeck() {
        LOGGER.info("Test 1: Creating " + numberOfDecks + " new deck(s)");
        deckId = GetNewDeck.getNewDeck(numberOfDecks);
        Assert.assertNotNull("Deck ID should not be null", deckId);
        deckIds.add(deckId);
    }

    @Test
    public void test02_shuffleExistingDeck() {
        LOGGER.info("Test 2: Shuffling the deck");
        Assert.assertNotNull("Deck ID should not be null before shuffling", deckId);
        boolean shuffleSuccess = ShuffleExistingDeck.shuffleDeck(deckId);
        Assert.assertTrue("Shuffled deck should have success true", shuffleSuccess);
    }

    @Test
    public void test03_drawCards() {
        LOGGER.info("Test 3: Drawing " + numberOfCardsToDraw + " cards from the deck");
        Assert.assertNotNull("Deck ID should not be null before drawing cards", deckId);
        String drawCardsUrl = BASE_URI + deckId + "/draw/?count=" + numberOfCardsToDraw;
        Response response = given()
                .when()
                .get(drawCardsUrl)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();
        JsonPath jsonPath = response.jsonPath();
        List<String> drawnCardCodes = jsonPath.getList("cards.code");
        cardCodes = new ArrayList<>(drawnCardCodes);
        for (int i = 0; i < drawnCardCodes.size(); i++) {
            LOGGER.info("Card " + (i + 1) + " drawn: " + drawnCardCodes.get(i));
        }
        LOGGER.info("Card codes: " + cardCodes);
    }

    @Test
    public void test04_addCardsToPile() {
        LOGGER.info("Test 4: Adding cards to discard pile");
        Assert.assertNotNull("Card codes should not be null", cardCodes);
        String cardsToAddURL = BASE_URI + deckId + "/pile/discard/add/?cards=" + String.join(",", cardCodes);
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
        Response discardPileResponse = given()
                .when()
                .get(discardPileUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        List<String> discardPileCards = discardPileResponse.jsonPath().getList("piles.discard.cards");
        Assert.assertNotNull("Discard pile should not be null", discardPileCards);
        Assert.assertFalse("Discard pile should have cards", discardPileCards.isEmpty());
    }
    @Test
    public void test05_returnCardsToDeck() {
        LOGGER.info("Test 5: Returning cards to the deck");
        Assert.assertNotNull("Card codes should not be null", cardCodes);
        String cardsToReturnURL = BASE_URI + deckId + "/pile/discard/return/?cards=" + String.join(",", cardCodes);
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
        Response discardPileResponse = given()
                .when().
                get(discardPileUrl).
                then().
                statusCode(200).
                extract().
                response();
        LOGGER.info("Discard pile after returning cards: " + discardPileResponse.jsonPath().getList("piles.discard.cards"));
    }

    @Test
    public void test06_deckWithJokers() {
        LOGGER.info("Test 6: Creating deck with jokers");
        int remainingCards = DeckWithJokers.createDeckWithJokers();
        Assert.assertEquals(54, remainingCards);
        LOGGER.info("Deck with jokers created successfully. Remaining cards: " + remainingCards);
    }
}
