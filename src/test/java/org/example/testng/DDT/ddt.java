package org.example.testng.DDT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ddt {

    // Test Data - from Excel File - Data Provider
    // Read the Excel File - Apache POI
    // Fillo Library

    // Excel -> There is no support directly in Java to read the Excel File
    // Apache POI Library

    RequestSpecification requestSpecification;

    Response response;

    ValidatableResponse validatableResponse;


    Integer ID;


    @Test(dataProvider = "getData", dataProviderClass = utilsExcel.class)

    public void testLogin(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }


    @Test
    public void testVWOPOST() {


        // Preparation

        RequestSpecification r = RestAssured.given();

        String payload_vwo = "{\n" +
                "    \"username\" : \"contact+atb5x@thetestingacademy.com\",\n" +
                "    \"password\" : \"ATBx@1234\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://app.vwo.com/#/");
        requestSpecification.basePath("login");
        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.cookie("token", token);

        requestSpecification.body(payload_vwo).log().all();


        // Calling PUT Method on URI. After hitting gwe get response.


        Response response = requestSpecification.when().put();


        // Get validatable response to perform action

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        String firstName = response.then().log().all().extract().path("firstname");
        String id = response.then().log().all().extract().path("id");

        assertThat(firstName).isNotEmpty().isNotBlank().isNotNull();
        assertThat(id).isNotNull().isNotEmpty();


    }





}
