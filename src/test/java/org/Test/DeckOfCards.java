package org.Test;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class DeckOfCards {

    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    private static String deckId;
    private static String cardCodes;

    @Test
    public void getNewDeck() {
        String newDeckUrl = BASE_URI + "/new/";
        Response response = given()
                .when()
                .get(newDeckUrl)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        deckId = response.path("deck_id");
        Assert.assertNotNull("Deck ID should not be null", deckId);
    }

    @Test
    public void shuffleExistingDeck() {
        Assert.assertNotNull("Deck ID should not be null before shuffling", deckId);

        String shuffleUrl = BASE_URI + deckId + "/shuffle";
        Response response = given()
                .when()
                .get(shuffleUrl)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertTrue("Shuffled deck should have success true", response.path("success"));
    }

    @Test
    public void drawTwoCards() {
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
    }

    @Test
    public void addCardsToPile() {
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
    }

    @Test
    public void returnCardToDeck() {
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
    }

    @Test
    public void deckWithJokers() {
        String deckWithJokersURL = BASE_URI + "new/?jokers_enabled=true";
        Response response = given()
                .when()
                .get(deckWithJokersURL)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        int remainingCards = JsonPath.from(response.asString()).getInt("remaining");
        Assert.assertEquals(54, remainingCards);
    }
}
