package org.example.testng;

import org.testng.annotations.Test;

public class TestNG09 {


    @Test
    public void serverStartedOk(){
        System.out.println("I will run first");
    }


    @Test(dependsOnMethods = "serverStartedOk")
    public void method1(){
        System.out.println("method 1");
    }


}
