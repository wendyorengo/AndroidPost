package com.example.postapp.API

import com.example.postapp.Model.post
import retrofit2.Response
import retrofit2.http.GET


class ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<List<post>>

}