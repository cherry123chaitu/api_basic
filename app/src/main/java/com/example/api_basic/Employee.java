package com.example.api_basic;

import com.google.gson.annotations.SerializedName;

public class Employee {
        @SerializedName("name")
        String firstname;
        @SerializedName("imageurl")
        String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    //  @SerializedName("emp_id") in case u use a different name from the Json array.
      String emp_id;

    public Employee(String firstname, String lastname, String emp_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emp_id = emp_id;
    }

}
