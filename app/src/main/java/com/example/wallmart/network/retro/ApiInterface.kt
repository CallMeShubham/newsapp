package com.example.wallmart.network.retro

import com.example.wallmart.models.response.News
import retrofit2.Call
import retrofit2.http.GET

/**
 * contains REST API endpoints
 */
interface ApiInterface {

    @GET("top-headlines?country=us&apiKey=50c1bd99f6464242aab6405aa2ca35a5")
    fun getNews(): Call<News>
}
