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

import static org.assertj.core.api.Assertions.assertThat;

public class TestNG05 {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token;

    Integer bookingID;


    @BeforeTest
    public void getToken(){
        System.out.println(" - Get the Token ");


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
        validatableResponse.body("token", Matchers.notNullValue()); // Rest Assured -> Matchers -> Comes under hamcrest

        token = response.then().log().all().extract().path("token");

        Assert.assertNotNull(token); // TestNG Assertion

        assertThat(token).isNotNull().isNotBlank().isNotEmpty(); // AssertJ Library

        System.out.println(token);
    }


    @BeforeTest
    public void getBookingID(){
        System.out.println(" - Get booking iD");

        requestSpecification = RestAssured.given();

        String payload = "{\n" +
                "    \"firstname\" : \"Marruf\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2018-01-11\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : [\"Breakfast\", \"Lunch\"]\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        // Making request

        Response response = requestSpecification.when().post();


        // validation

        ValidatableResponse validatableResponse = response.then();

        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);
        bookingID = response.then().log().all().extract().path("bookingid");
        System.out.println(bookingID);
    }


    @Test
    public void PUTReq(){
        System.out.println("test case PUT request");


        String payload = "{\n" +
                "    \"firstname\" : \"Vikcy\",\n" +
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
        requestSpecification.basePath("booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();

        // Calling PUT Method on URI. After hitting gwe get response.

        Response response = requestSpecification.when().put();


        // Get validatable response to perform action

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Vikcy"));
        validatableResponse.body("lastname", Matchers.equalTo("Bhai"));


    }

    @Test
    public void PUTReq2(){
        System.out.println("test case PUT request");


        String payload = "{\n" +
                "    \"firstname\" : \"Vikcy\",\n" +
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
        requestSpecification.basePath("booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();



        // Calling PUT Method on URI. After hitting gwe get response.


        Response response = requestSpecification.when().put();


        // Get validatable response to perform action

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        String firstName = response.then().log().all().extract().path("firstname");

        assertThat(firstName).isNotEmpty().isNotBlank().isNotNull();



    }
}
