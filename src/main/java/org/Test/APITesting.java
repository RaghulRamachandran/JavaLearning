package org.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.OrderWith;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class APITesting {
    public static String deck_id;
    public static String cards;
    public static final String baseURI="https://deckofcardsapi.com/api/deck/";
    public static String pileName = "discard";
    public static String cardCodes;
    public String url;
    private List<String> pile = new ArrayList<>();
    public String response;
    @Test
    public void getNewDeck(){
        deck_id= given().
                when().
                get("https://deckofcardsapi.com/api/deck/new/").then().log().body().statusCode(200).extract().response().path("deck_id");
        System.out.println("Deck id is "+ deck_id);
    }
    @Test
    public void shuffleExistingNewDeck(){
        given().when()
                .get("https://deckofcardsapi.com/api/deck/"+deck_id+"/shuffle/?deck_count=1")
                .then().log().body();
    }
    @Test
    public void drawTwoCards(){
        Response response = RestAssured.given()
                .when()
                .get("https://deckofcardsapi.com/api/deck/" + deck_id + "/draw/?count=2");
        response.then().log().body();
        JsonPath jsonPath = response.jsonPath();
        String firstCardCode = jsonPath.getString("cards[0].code");
        String secondCardCode = jsonPath.getString("cards[1].code");
        cardCodes = firstCardCode + "," + secondCardCode;
        System.out.println("First card code: " + firstCardCode);
        System.out.println("Second card code: " + secondCardCode);
        System.out.println(cardCodes);
    }

    @Test
    public void addCardsToPile() {
        String cardsToAdd = String.join(",", cardCodes);
        System.out.println("Cards to add to the pile: " + cardsToAdd);

        given()
                .when()
                .get(baseURI + deck_id + "/pile/" + pileName + "/add/?cards="+cardsToAdd)
                .then().log().body();
    }}

