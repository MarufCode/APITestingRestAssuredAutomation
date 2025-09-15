package org.example.Tests.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDPATCH {

    RequestSpecification requestSpecification;

    Response response;

    ValidatableResponse validatableResponse;

    String token = "7cdbf1871960b34";




    @Test
    public void testPatchRequest(){

        String payload = "{\n" +
                "    \"firstname\" : \"Marruf\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/1991");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload).log().all();



        // when
        Response response = requestSpecification.when().patch();


        //then

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));








    }
}
