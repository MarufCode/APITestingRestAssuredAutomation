package org.example.Tests.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPUT {


    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token = "6d362f242296f25";


    @Test
    public void testPutRequest(){

        // URL
        // Auth - Token - 8b2b56d71a03f58 , headers - json
        // ID - 4700
        // payload

        String payload = "{\n" +
                "    \"firstname\" : \"Maruf\",\n" +
                "    \"lastname\" : \"Bhai\",\n" +
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
        requestSpecification.basePath("booking/1942");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();



        // Calling PUT Method on URI. After hitting gwe get response.


        Response response = requestSpecification.when().put();


        // Get validatable response to perform action

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Maruf"));
        validatableResponse.body("lastname", Matchers.equalTo("Bhai"));





    }






}
