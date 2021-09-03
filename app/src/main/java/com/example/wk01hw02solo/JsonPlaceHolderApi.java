package com.example.wk01hw02solo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();
    @GET("users")
    Call<List<Post>> getUsers();
}
