package com.example.wallmart.network.retro

import com.example.wallmart.models.response.News
import retrofit2.Call
import retrofit2.http.GET

/**
 * contains REST API endpoints
 */
interface ApiInterface {

    @GET()
    fun getNews(): Call<News>
}
