package com.example.wallmart.network.api.newsdata

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wallmart.models.response.News
import com.example.wallmart.network.retro.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * class for making news data related REST api calls using retrofit
 * @param context - app context
 */
class NewsDataWebService(context: Context) {

    /**
     * fetch news from REST api
     */
    fun getNews(): MutableLiveData<News> {
        var newsLiveData = MutableLiveData<News>()
        val call: Call<News> = RetrofitClient.getClient().getNews()
        call.enqueue(object : Callback<News> {

            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                newsLiveData.postValue(response?.body())
            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                //to-do
                //handle error scenario
            }
        })
        return newsLiveData
    }

}
