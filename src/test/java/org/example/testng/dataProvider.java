package org.example.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {


    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password"},
                new Object[]{"admin1", "password123"},
        };
    }






    @Test(dataProvider = "getData")
    public void loginTest(String username, String password){
        System.out.println(username);
        System.out.println(password);
    }
}
