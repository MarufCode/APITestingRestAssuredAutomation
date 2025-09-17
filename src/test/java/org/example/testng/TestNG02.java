package org.example.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestNG02 {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token;


    // PUT Request
    // Before - Token, ID

    @BeforeTest
    public void getToken(){

        String payload  = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response = requestSpecification.post();

        validatableResponse = response.then();
        validatableResponse.body("token",Matchers.notNullValue()); // Rest Assured -> Matchers -> Comes under hamcrest

        token = response.then().log().all().extract().path("token");

        Assert.assertNotNull(token); // TestNG Assertion

        assertThat(token).isNotNull().isNotBlank().isNotEmpty(); // AssertJ Library

        System.out.println(token);
    }

    @Test
    public void NonBDDPUTRequest() {
        String payload = "{\n" +
                "    \"firstname\" : \"Maruf\",\n" +
                "    \"lastname\" : \"CSK\",\n" +
                "    \"totalprice\" : 777,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : { \n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/2119");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);


        requestSpecification.body(payload).log().all();


        // Calling PUT Method on URI. After hitting we get response.


        Response response = requestSpecification.when().put();


        // Get validatable response to perform action

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Maruf"));
        validatableResponse.body("lastname", Matchers.equalTo("CSK"));

    }
}
