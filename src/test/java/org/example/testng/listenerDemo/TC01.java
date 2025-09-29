package org.example.testng.listenerDemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TC01 {


    @Test(groups = "sanity")

    public void test1(){
        System.out.println("test Case 1");
        Assert.assertTrue(false);
    }


    @Test(groups = "sanity")
    public void test2(){
        System.out.println("Test CAse 2");
        Assert.assertTrue(true);
    }
}
