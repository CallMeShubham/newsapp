package com.example.wallmart.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.wallmart.models.response.News
import com.example.wallmart.network.clients.NewsDataBusinessClient

class NewsDataRepository {
    /**
     * fetch the news data
     * @param context - context of the activity
     */
    fun getNews(context : Context): MutableLiveData<News> {
        if(checkIfNewsDataIsInLocalDB()) {
            //if true, fetch news data from local db
            //to-do
            //create room db pending
        } else {
            //trigger network API
            return NewsDataBusinessClient(context).getNews()
        }
        //to-do
        return NewsDataBusinessClient(context).getNews()
    }

    /**
     * check if news data is in local db
     * @return true - if data exists in local db
     *         false - in case data don't exists
     */
    private fun checkIfNewsDataIsInLocalDB(): Boolean {
        //To-do
        return false
    }

}
