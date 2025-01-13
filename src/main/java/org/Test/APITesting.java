package org.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APITesting {

    public int getBrandNewDeck(){
        RestAssured.baseURI="https://deckofcardsapi.com/api/deck";
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.queryParam("deck_count",1);
        Response response=requestSpecification.request(Method.GET,"/new/shuffle/");
        System.out.println(response.asPrettyString());
        System.out.println(response.getStatusLine());
        return 0;
    }

    public static void main(String[] args) {
        APITesting Test=new APITesting();
          Test.getBrandNewDeck();
    }
    }
