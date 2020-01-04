package com.example.api_basic;

import com.google.gson.annotations.SerializedName;

public class Employee {

        String firstname;

        String lastname;
      //  @SerializedName("emp_id") in case u use a different name from the Json array.
           String emp_id;

    public Employee(String firstname, String lastname, String emp_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emp_id = emp_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmp_id() {
        return emp_id;
    }
}
