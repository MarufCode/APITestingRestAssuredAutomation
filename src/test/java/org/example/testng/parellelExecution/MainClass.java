package org.example.testng.parellelExecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainClass {



    @BeforeMethod
    public void beforeMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("Before Thread method, Thread is : " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodOne(){
        long id = Thread.currentThread().getId();
        System.out.println("test One is : " + id + getClass().getSimpleName());
    }

    @Test
    public void testMethodTwo(){
        long id = Thread.currentThread().getId();
        System.out.println("test Two is : " + id + getClass().getSimpleName());
    }


    @AfterMethod
    public void afterMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("After Thread method, Thread id is : " + id + getClass().getSimpleName());
    }
}
