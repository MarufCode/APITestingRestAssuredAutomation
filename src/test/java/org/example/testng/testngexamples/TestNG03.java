package org.example.testng.testngexamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG03 {

    String token;

    Integer bookingID;


    public String getToken(){
        token = "123";
        return token;
    }


    @BeforeTest
    public void getTokenAndBookingID(){
        token = getToken();
        bookingID = 123;
    }


    @Test
    public void testPutReq(){
        System.out.println(token);
        System.out.println(bookingID);
    }

}
