package com.example.wallmart.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallmart.models.response.News
import com.example.wallmart.repository.NewsDataRepository

/**
 * ViewModelFactory required to pass NewsDataRepository parameter to ViewModel
 */
class NewsDataViewModelFactory(private var newsDataRepository: NewsDataRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        NewsActivityViewModel(newsDataRepository) as T
}

/**
 * viewmodel class containing business methods for fetching news related UI data
 */
class NewsActivityViewModel(private val newsDataRepository: NewsDataRepository) : ViewModel() {

    /**
     * fetch the news
     */
    fun getNews(context : Context) : MutableLiveData<News> {
        return newsDataRepository.getNews(context)
    }
}