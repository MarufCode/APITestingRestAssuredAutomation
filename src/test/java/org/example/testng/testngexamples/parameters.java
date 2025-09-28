package org.example.testng.testngexamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameters {



    @Parameters("browser")
    @Test(priority = 1)
    void test1(String value){
        System.out.println("browser is " + value);
    }
}
