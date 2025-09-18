package org.example.testng;

import org.testng.annotations.Test;

public class groupingOfTC {


    @Test(groups = {"sanity","QA", "reg"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }


    @Test(groups = {"reg", "e2e", "preprod"})
    public void regRun(){
        System.out.println("regression");
    }

    @Test(groups = {"sanity", "smoke", "Dev"})
    public void smokeRun(){
        System.out.println("Smoke");
    }
}
