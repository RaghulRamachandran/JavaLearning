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
    private final String deckId;

    public DeckOfCards_Decks(int numberOfDecks, String jokerEnabled) {
        String newDeckUrl = BASE_URI + "new/?deck_count=" + numberOfDecks + "&jokers_enabled=" + jokerEnabled;
        Response response = given()
                .when()
                .get(newDeckUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        this.deckId = response.path("deck_id");
    }

    public String getDeckId() {
        return deckId;
    }

    public boolean shuffleDeck() {
        String shuffleUrl = BASE_URI + this.deckId + "/shuffle";
        Response response = given()
                .when()
                .get(shuffleUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("shuffled");
    }

    public List<String> drawCards(int cardsToDraw) {
        String drawCardsUrl = BASE_URI + this.deckId + "/draw/?count=" + cardsToDraw;
        Response response = given()
                .when()
                .get(drawCardsUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.jsonPath().getList("cards.code");
    }

    public boolean addToDiscardPile(List<String> cardCodes) {
        String addToPileUrl = BASE_URI + this.deckId + "/pile/discard/add/?cards=" + String.join(",", cardCodes);
        Response response = given()
                .when()
                .get(addToPileUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("success");
    }

    public List<String> getDiscardPile() {
        String discardPileUrl = BASE_URI + this.deckId + "/pile/discard/list";
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
            LOGGER.warning("Error fetching discard pile: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean returnCardsToDeck(List<String> cardCodes) {
        String returnCardsUrl = BASE_URI + this.deckId + "/pile/discard/return/?cards=" + String.join(",", cardCodes);
        Response response = given()
                .when()
                .get(returnCardsUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("success");
    }

    public int getRemainingCardsInDeck() {
        String deckInfoUrl = BASE_URI + this.deckId;
        Response response = given()
                .when()
                .get(deckInfoUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();
        return response.path("remaining");
    }
}
