package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;


public class DeckOfCards_StepDefinitions {
    public static final String BASE_URI = "https://deckofcardsapi.com/api/deck/";
    public String deckId;
    private static final Logger LOGGER = Logger.getLogger(DeckOfCards_StepDefinitions.class.getName());
    @Given("I create a new deck ID")
    public void i_create_a_new_deck_id() {String newDeckUrl = BASE_URI + "/new/";
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
    @When("I shuffle the deck")
    public void i_shuffle_the_deck() {

    }
    @Then("the response should be {string}")
    public void the_response_should_be(String string) {

    }
}
