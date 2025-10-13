package org.example.misc.payloadmap.gson;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import groovy.json.JsonOutput;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.misc.payloadmap.gson.example.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class POSTReqTC {


    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void testPositive(){

        // Step 1 ->
        //URl
        // HEADER
        // BODY

        // STEP 2->
        //PREPARE THE PAYLOAD (Object -> String)
        // Send the Request

        // STEP 3
        // VALIDATE RESPONSE    (String -> Object)
        // First NAME
        // STATUS CODE
        // TIME Response


        Faker faker = new Faker();
        Booking booking = new Booking();
        String expectedFirstName = faker.name().firstName();
        booking.setFirstname(expectedFirstName);
        String expectedLastName = faker.name().lastName();
        booking.setLastname(expectedLastName);
        booking.setTotalprice(22);
        booking.setDepositpaid(true);


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-10-01");
        bookingdates.setCheckout("2025-10-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds(Arrays.asList("Breakfast", "Lunch", "Dinner"));

        System.out.println(booking);
        // Object -> JSON String by using GSON

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);




        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonStringBooking).log().all();



        // Calling PUT Method on URI. After hitting gwe get response.


        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // VALIDATE RESPONSE    (String -> Object) De Serialization

        BookingResponse  bookingResponseObject = gson.fromJson(jsonResponseString,BookingResponse.class);
        assertThat(bookingResponseObject.getBookingid()).isNotNull();
        assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expectedFirstName);
        assertThat(bookingResponseObject.getBooking().getLastname()).isEqualTo(expectedLastName);

        System.out.println("Booking ID is -> " + bookingResponseObject.getBookingid());
        System.out.println("First Name is -> "  + bookingResponseObject.getBooking().getFirstname());
        System.out.println("First Name is -> "  + bookingResponseObject.getBooking().getLastname());








    }
}
