package com.osmanyigituygun.Base;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static ResponseSpecification commonResponseSpec;

    @BeforeClass // BeforeClass annotation is used to specify that the setup method should be executed before any test methods in the class. This is useful for setting up common configurations or initializations that are required for all tests in the class. RUNS ONCE BEFORE ALL TESTS IN THE CLASS
    public void setup() {
        RestAssured.baseURI = getBaseUrl();
    }

    @BeforeClass
    public void setupResponseSpecification() {
        commonResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectHeader("Server", "Apache/2.4.52 (Ubuntu)")
                .build();
    } // This is an example of a common response specification that can be reused across multiple test methods. It checks for a status code of 200 and a specific server header in the response.

    protected String getBaseUrl() {
        return "https://rahulshettyacademy.com";
    }
}