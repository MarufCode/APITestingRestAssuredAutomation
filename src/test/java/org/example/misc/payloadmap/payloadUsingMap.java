package org.example.misc.payloadmap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class payloadUsingMap {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void testPOSTReq(){

//        "{\n" +
//                "    \"firstname\" : \"Maruf\",\n" +
//                "    \"lastname\" : \"Bhai\",\n" +
//                "    \"totalprice\" : 777,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : { \n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}"


        Faker faker = new Faker();
        String name = faker.name().lastName();


        Map<String, Object> jsonBodysingMap = new LinkedHashMap<>();
        jsonBodysingMap.put( "firstname",faker.name().firstName());
        jsonBodysingMap.put( "lastname", faker.name().lastName());
        jsonBodysingMap.put( "totalprice", faker.random().nextInt(1000));
        jsonBodysingMap.put( "depositpaid", faker.random().nextBoolean());


        Map<String,Object> bookingDateMap = new LinkedHashMap<>();
        bookingDateMap.put("checkin", "2018-01-01");
        bookingDateMap.put("checkout", "2019-01-01");

        jsonBodysingMap.put("bookingdates", bookingDateMap);
        jsonBodysingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodysingMap);



        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonBodysingMap).log().all();



        // Calling PUT Method on URI. After hitting gwe get response.


        Response response = requestSpecification.when().post();

        Integer bookingID = response.then().extract().path("bookingid");

        // Get validatable response to perform action

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println( " Booking ID is : -> " + bookingID);

    }
}
