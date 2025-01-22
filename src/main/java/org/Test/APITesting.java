package org.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;


public class APITesting {
    private static final Logger LOGGER = Logger.getLogger(APITesting.class.getName());
    public static String deckId;
    public static String cards;
    public static final String BASE_URI ="https://deckofcardsapi.com/api/deck/";
    public static String PILE_NAME = "discard";
    public static String cardCodes;
    public String url;
    private List<String> pile = new ArrayList<>();
    public String response;
    @Test
    public void getNewDeck(){
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
        LOGGER.info("Deck ID: " + deckId);
    }
    @Test
    public void shuffleExistingNewDeck(){
        Assert.assertNotNull("Deck ID should not be null before shuffling", deckId);

        String shuffleUrl = BASE_URI + "/" + deckId + "/shuffle/?deck_count=1";
        Response response = given()
                .when()
                .get(shuffleUrl)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertTrue("Shuffled deck should have success true", response.path("success"));
        LOGGER.info("Deck shuffled successfully.");
    }
    @Test
    public void drawTwoCards(){
        Assert.assertNotNull("Deck ID should not be null before drawing cards", deckId);

        String drawCardsUrl = BASE_URI + "/" + deckId + "/draw/?count=2";
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
        LOGGER.info("First card code: " + firstCardCode);
        LOGGER.info("Second card code: " + secondCardCode);
        LOGGER.info("Card codes: " + cardCodes);
    }

    @Test
    public void addCardsToPile() {
        String cardsToAdd = String.join(",", cardCodes);
       LOGGER.info("Cards to add to the pile: " + cardsToAdd);
       String cardsToAddURL="BASE_URI + deckId + \"/pile/\" + PILE_NAME + \"/add/?cards=\"+cardsToAdd";

        Response response = given()
                .when()
                .get(cardsToAddURL)
                .then().log().body().statusCode(200)
                .extract()
                .response();
        Assert.assertTrue("Adding cards to pile should have success true", response.path("success"));
        LOGGER.info("Cards added to the pile successfully");
    }}

