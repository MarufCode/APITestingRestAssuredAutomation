package org.example.Tests.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDDELETE {

    RequestSpecification requestSpecification;

    Response response;

    ValidatableResponse validatableResponse;

    String token = "284d7084b710a7f";


    @Test

    public void testDeleterequest(){



        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/674");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);




        // when
        Response response = requestSpecification.when().delete();


        //then

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

    }
}
