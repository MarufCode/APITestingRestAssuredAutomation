package org.example.Tests.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestNGGETRequestNonBDD {

//    TestNG -> Add Dependency in pom.xml

    @Test
    public void testGetAllBookingPositive(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/245").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(200);
    }

    @Test(enabled = false)
    public void testGetAllBookingNegative(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/245").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(404);
    }

    @Test
    public void testGetAllBookingNegative2(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc").log().all();
        r.when().log().all().get();
        r.then().log().all().statusCode(404);


    }





}
