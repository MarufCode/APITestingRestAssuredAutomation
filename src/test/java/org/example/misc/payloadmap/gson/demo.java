package org.example.misc.payloadmap.gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.security.cert.TrustAnchor;
import java.util.Arrays;

public class demo {


    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    // payload
    // String -> Not
    // Hashmap -> Not
    // Class -> POJO




    // POJO

    // 1 - Difficult - Generate getter setter from your own
    // 2 - Easy! - use the -> https://www.jsonschema2pojo.org/


    @Test
    public void testPost() {


        Booking booking = new Booking();
        booking.setFirstname("Maruf");
        booking.setLastname("Sherikar");
        booking.setTotalprice(22);
        booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-10-01");
        bookingdates.setCheckout("2025-10-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds(Arrays.asList("Breakfast", "Lunch", "Dinner"));

        System.out.println(booking);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(booking).log().all();



        // Calling PUT Method on URI. After hitting gwe get response.


        Response response = requestSpecification.when().post();

        Integer bookingID = response.then().extract().path("bookingid");

        // Get validatable response to perform action

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println( " Booking ID is : -> " + bookingID);
    }




}
