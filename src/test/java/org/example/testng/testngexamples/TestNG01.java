package org.example.testng.testngexamples;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG01 {

    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");
    }


    @BeforeTest
    void demo2(){
        System.out.println("Before Test");
    }


    @BeforeClass
    void demo3(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    void demo4(){
        // why - Read of excel file
        // File, Text, JSON, CSV, Database
        // Configuration files
        System.out.println("Before Method");
    }


   @Test
    void demo5(){
        // This will be real TC
       System.out.println("Test 1");
   }

   @AfterMethod
   void demo6(){
        // Close the files - Here write the code
       System.out.println("After Method");
   }

   @AfterClass
    void demo7(){
       System.out.println("After Class");
   }

   @AfterTest
    void demo8(){
       System.out.println("After Test");
   }

   @AfterSuite
    void demo9(){
       System.out.println("After Suite");}
}
