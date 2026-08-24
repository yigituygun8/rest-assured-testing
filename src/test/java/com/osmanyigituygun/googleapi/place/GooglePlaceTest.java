package com.osmanyigituygun.googleapi.place;

import com.osmanyigituygun.Base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import com.osmanyigituygun.files.Payload;

/*
Given - all input details
When - Submit the API request - resource, http method goes in when section
Then - Validate the response
*/

public class GooglePlaceTest extends BaseTest {
    @Override
    protected String getBaseUrl() {
        return "https://rahulshettyacademy.com/maps/api/place";
    }

    @Test
    public void addPlaceWithValidDataReturnsCreated() {
        System.out.println("addPlaceWithValidDataReturnsCreated  " + baseURI);
        given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.getAddPlacePayload()) // This is an example of using a payload from a separate class. The getAddPlacePayload() method returns a JSON string that represents the request body for adding a place.
                .when().post("/add/json") // this gets concatenated with baseURI to form the full URL in the request automatically
                .then().log().all()
                .spec(commonResponseSpec) // This is an example of using a common response specification that was defined in the BaseTest class. It checks for a status code of 200 and a specific server header in the response.
                .body("scope", equalTo("APP"));
    } // addPlace - POST



}
