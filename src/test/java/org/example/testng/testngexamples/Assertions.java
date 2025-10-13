package org.example.testng.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Assertions {

    // TestNG provides twi assertion

//            1. Soft Assert
//            2. Hard Assert

    @Test
    void testcase1() {

        SoftAssert s = new SoftAssert();
        s.assertEquals(true, false, "True should not be equal to false");
        System.out.println("It will execute");
        s.assertAll();



        //Hard assert

        Assert.assertEquals(true, false);
        System.out.println("This will not print");
    }

}
