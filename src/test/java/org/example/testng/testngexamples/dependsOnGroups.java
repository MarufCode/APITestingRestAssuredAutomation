package org.example.testng.testngexamples;

import org.testng.annotations.Test;


public class dependsOnGroups {


    @Test(groups = {"init"}, priority = 1)
    public void getToken(){
        System.out.println("getToken");
    }


    @Test(groups = {"init"}, priority = 2)
    public void getBookingID(){
        System.out.println("getBookingID");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void testPutReq(){
        System.out.println("Now i will run");
    }


}
