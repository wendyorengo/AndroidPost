package com.example.postapp.repository

import com.example.postapp.API.ApiClient
import com.example.postapp.API.ApiInterface
import com.example.postapp.Model.post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

import retrofit2.Response

class PostRepository {
    suspend fun  getPosts(): Response<List<post>> = withContext(Dispatchers.IO){
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getPosts()
        return@withContext response

    }

}