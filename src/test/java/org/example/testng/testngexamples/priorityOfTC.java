package org.example.testng.testngexamples;

import org.testng.annotations.Test;

public class priorityOfTC {

    @Test
    public void t1(){
        System.out.println(1);
    }

    @Test(priority = 0)
    public void t2(){
        System.out.println(2);
    }

    @Test(priority = -1)
    public void t3(){
        System.out.println(3);
    }
}
