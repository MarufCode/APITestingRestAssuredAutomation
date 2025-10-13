package org.example.misc.payloadmap.gson.example;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Employee {


        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("LastName")
        @Expose
        private String lastName;
        @SerializedName("Gender")
        @Expose
        private String gender;
        @SerializedName("age")
        @Expose
        private Integer age;
        @SerializedName("salary")
        @Expose
        private Integer salary;
        @SerializedName("married")
        @Expose
        private Boolean married;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public Boolean getMarried() {
            return married;
        }

        public void setMarried(Boolean married) {
            this.married = married;
        }


}
