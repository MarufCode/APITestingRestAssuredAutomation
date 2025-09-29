package org.example.testng.listenerDemo;

import org.testng.IExecutionListener;

public class CustomListeners implements IExecutionListener {


    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println(" **   ***  Started Execution at - " + endTime + " *****  ** ");
    }


    @Override
    public void onExecutionStart() {
        long startTime = System.currentTimeMillis();
        System.out.println("***** Finished Execution at - " + startTime + " ******* ");
    }

}
