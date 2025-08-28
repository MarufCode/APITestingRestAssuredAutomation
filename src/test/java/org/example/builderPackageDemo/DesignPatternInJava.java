package org.example.builderPackageDemo;

public class DesignPatternInJava {


    public DesignPatternInJava stage1(){
        System.out.println("Stage 1");
        return this;
    }

    public DesignPatternInJava stage2(){
        System.out.println("Stage 2");
        return this;
    }

    public DesignPatternInJava stage3(){
        System.out.println("Stage 3");
        return this;
    }

    public static void main(String[] args) {


        DesignPatternInJava dp = new DesignPatternInJava();
        dp.stage1().stage2().stage3();
    }
}
