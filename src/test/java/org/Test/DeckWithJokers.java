package org.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class DeckWithJokers {
    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";

    public static int createDeckWithJokers() {
        String deckWithJokersURL = BASE_URI + "new/?jokers_enabled=true";
        Response response = given()
                .when()
                .get(deckWithJokersURL)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        return response.path("remaining");
    }
}
