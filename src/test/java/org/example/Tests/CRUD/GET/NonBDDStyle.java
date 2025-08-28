package org.example.Tests.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {

    // GET Request
    // BDD Style and Non BDD

    // given, when, then -> BDD Style


    public static void main(String[] args) {

        // https://restful-booker.herokuapp.com/booking/1

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/245").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);



        // TestNG -> Testing framework -> Allow us to execute test cases

    }

















}
