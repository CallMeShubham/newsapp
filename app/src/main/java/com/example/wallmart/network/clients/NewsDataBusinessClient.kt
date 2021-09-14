package com.example.wallmart.network.clients

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wallmart.models.response.News
import com.example.wallmart.network.api.newsdata.NewsDataWebService

/**
 *
 */
class NewsDataBusinessClient (private val context: Context) {
    private var newsDataWebService : NewsDataWebService = NewsDataWebService(context)

    /**
     * Get All News data using GET method live API call
     * @return News
     */
    fun getNews(): MutableLiveData<News> {
        return newsDataWebService.getNews()
    }

}