package com.example.api_basic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

interface Api {
    String BASE_URL="http://127.0.0.1:8000/";
    @GET("employee")
    Call<List<Employee>> getemployee();
    
}
