package org.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class ShuffleExistingDeck {
    private static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";

    public static boolean shuffleDeck(String deckId) {
        String shuffleUrl = BASE_URI + deckId + "/shuffle";
        Response response = given()
                .when()
                .get(shuffleUrl)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();
        return response.path("success");
    }
}
