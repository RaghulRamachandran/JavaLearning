package org.Test.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class DeckOfCards_Decks {
    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";

    public String getNewDeck(int numberOfDecks) {
        String newDeckUrl = BASE_URI + "new/?deck_count=" + numberOfDecks;
        Response response = given()
                .when()
                .get(newDeckUrl)
                .then()
                .log().body()
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
                .log().all()
                .statusCode(200)
                .extract()
                .response();
        return response.path("success");
    }
    public int createDeckWithJokers() {
        String deckWithJokersURL = BASE_URI + "new/?jokers_enabled=true";
        Response response = given()
                .when()
                .get(deckWithJokersURL)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
        return response.path("remaining");
    }
}

