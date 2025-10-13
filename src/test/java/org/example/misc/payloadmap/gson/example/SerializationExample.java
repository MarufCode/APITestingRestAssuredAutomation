package org.example.misc.payloadmap.gson.example;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class SerializationExample {



//    "firstName" : "Maruf",
//    "LastName" : "Sherikar",
//    "Gender" : "Male",
//    "age" : 27,
//    "salary" : "500.00",
//    "married" : false


    @Test
    public void test(){
        // Converting Object to String -> Serialization

        Employee em = new Employee();
        em.setFirstName("Maruf");
        em.setAge(25);
        em.setGender("Male");
        em.setSalary(500);


        Gson gson = new Gson();
        String jsonEmployee = gson.toJson(em);
        System.out.println(jsonEmployee);  // -> This will print in  Serialization Manner




    }



}
