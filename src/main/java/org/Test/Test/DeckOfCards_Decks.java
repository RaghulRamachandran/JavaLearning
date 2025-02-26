package org.Test.Test;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static io.restassured.RestAssured.given;

public class DeckOfCards_Decks {
    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    private static final Logger LOGGER = Logger.getLogger(DeckOfCards_Decks.class.getName());

    public String getNewDeck(int numberOfDecks, String jokerEnabled) {
        String newDeckUrl = BASE_URI + "new/?deck_count=" + numberOfDecks + "&jokers_enabled=" + jokerEnabled;
        Response response = given()
                .when()
                .get(newDeckUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("deck_id");
    }

    public boolean shuffleDeck(String deckId) {
        String shuffleUrl = BASE_URI + deckId + "/shuffle";
        Response response = given()
                .when()
                .get(shuffleUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("shuffled");
    }

    public List<String> drawCards(String deckId, int cardsToDraw) {
        String drawCardsUrl = BASE_URI + deckId + "/draw/?count=" + cardsToDraw;
        Response response = given()
                .when()
                .get(drawCardsUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.jsonPath().getList("cards.code");
    }

    public boolean addToDiscardPile(String deckId, List<String> cardCodes) {
        String addToPileUrl = BASE_URI + deckId + "/pile/discard/add/?cards=" + String.join(",", cardCodes);
        Response response = given()
                .when()
                .get(addToPileUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("success");
    }

    public List<String> getDiscardPile(String deckId) {
        String discardPileUrl = BASE_URI + deckId + "/pile/discard/list";
        try {
            Response response = given()
                    .when()
                    .get(discardPileUrl)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
            JsonPath jsonPath = response.jsonPath();
            if (jsonPath.get("piles.discard.cards") == null) {
                return new ArrayList<>();
            } else {
                return jsonPath.getList("piles.discard.cards.code");
            }
        } catch (Exception e) {
            LOGGER.severe("Error getting discard pile: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean returnCardsToDeck(String deckId, List<String> cardCodes) {
        String returnCardsUrl = BASE_URI + deckId + "/pile/discard/return/?cards=" + String.join(",", cardCodes);
        Response response = given()
                .when()
                .get(returnCardsUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("success");
    }

    public int getRemainingCardsInDeck(String deckId) {
        String deckInfoUrl = BASE_URI + deckId;
        Response response = given()
                .when()
                .get(deckInfoUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("remaining");
    }
    public int  createDeckWithJokers() {
        String deckWithJokersURL = BASE_URI + "new/?jokers_enabled=true";
        Response response = given()
                .when()
                .get(deckWithJokersURL)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("deck_id");
    }
}
