package com.example.api_basic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

interface Api {
    String BASE_URL="https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<Employee>> getemployee();

}
