package org.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APITestingTest {

    private final String baseURL = "https://deckofcardsapi.com/api/";
    private final String newDeck = "deck/new/shuffle/?deck_count=1";

    @Test
    public void getDeckCount(){
        RestAssured.baseURI = baseURL + newDeck;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"");
        response.then().statusCode(200);

        int actualDeckCount = response.jsonPath().getInt("remaining");
        Assertions.assertEquals(52,actualDeckCount);
    }

}



