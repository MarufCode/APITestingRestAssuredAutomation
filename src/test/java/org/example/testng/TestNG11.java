package org.example.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG11 {



    @Parameters("browser")
    @Test(priority = 1)
    void test1(String value){
        System.out.println("browser is " + value);
    }
}
