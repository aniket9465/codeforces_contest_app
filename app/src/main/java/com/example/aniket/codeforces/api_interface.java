package com.example.aniket.codeforces;


import retrofit2.Call;
import retrofit2.http.GET;


public interface api_interface {
    @GET("contest.list?")
    Call<Contests> get_contests();

}
