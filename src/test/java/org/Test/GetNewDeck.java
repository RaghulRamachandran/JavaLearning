package org.Test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public  class GetNewDeck {
        private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    public static String getNewDeck(int numberOfDecks) {
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
}

