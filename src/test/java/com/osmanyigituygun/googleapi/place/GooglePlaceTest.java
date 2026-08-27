package com.osmanyigituygun.googleapi.place;

import com.osmanyigituygun.Base.BaseTest;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
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
    public void addAndUpdatePlaceWithValidData() {
        System.out.println("addAndUpdatePlaceWithValidData  " + baseURI);
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.getAddPlacePayload()) // This is an example of using a payload from a separate class. The getAddPlacePayload() method returns a JSON string that represents the request body for adding a place.
                .when().post("/add/json") // this gets concatenated with baseURI to form the full URL in the request automatically
                .then().log().all()
                .spec(commonResponseSpec) // This is an example of using a common response specification that was defined in the BaseTest class. It checks for a status code of 200 and a specific server header in the response.
                .body("scope", equalTo("APP")).
        extract().response().asString(); // extracts the response as a string for further validation or processing. This allows you to capture the response body and use it in subsequent assertions or operations.

        JsonPath jsonPath = JsonPath.from(response); // This is an example of using JsonPath to parse the response string and extract specific values from it. JsonPath is a powerful tool for querying JSON data. It converts string into a JsonPath object, which allows you to easily access and manipulate the JSON data in the response.
        String place_id = jsonPath.getString("place_id");
        System.out.println("\nPlace ID: " + place_id);

        // Update the place using the extracted place_id
        String newAddress = "Esertepe Mh. Ankara";
        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.getUpdatePlacePayload(place_id, newAddress))
                .when().put("/update/json")
                .then().log().all().assertThat().statusCode(200)
                .spec(commonResponseSpec);

        // checking whether address is updated successfully or not
        String getResponse = given()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", place_id)
                .when().get("/get/json")
                .then()
                .assertThat().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath1 = JsonPath.from(getResponse);
        String actualAddress = jsonPath1.getString("address");
        Assert.assertEquals(actualAddress, newAddress); // (actual, expected)

    }



}
