package org.example.testng.testngexamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG04 {


    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getTokenAndBookingID(){
        System.out.println("1");
    }


    @Test
    public void t3(){
        System.out.println("3");
    }
}
