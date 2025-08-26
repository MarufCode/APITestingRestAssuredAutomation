package org.example;

import io.restassured.RestAssured;

public class RestAssuredTC {
    public static void main(String[] args) {


        // GET Request  -https://zippopotam.us/IN/400065
        // URL
        // GEt Method
        // base URL - https://zippopotam.us
        // base path -/IN/400065
        // Payload - Not required in get request
        // Auth - Not required in Get request


        //Want to Validate below:

        // Status code
        // Response Body
        // Time, Headers, Cookies


        // Gherkin -> Given, When, Then ->

//        RestAssured.given().when().then() - DSL (Java)


        RestAssured
                .given()
                .baseUri("https://zippopotam.us").basePath("/IN/400065")

                .when().log().all()
                .get()


                .then().log().all()
                .statusCode(200);




    }
}
