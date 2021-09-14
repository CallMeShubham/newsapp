package com.example.wallmart.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallmart.R
import com.example.wallmart.databinding.ActivityNewsBinding
import com.example.wallmart.models.response.Article
import com.example.wallmart.repository.NewsDataRepository
import com.example.wallmart.view.adapter.NewsListAdapter
import com.example.wallmart.viewmodel.NewsActivityViewModel
import com.example.wallmart.viewmodel.NewsDataViewModelFactory
import kotlinx.android.synthetic.main.activity_news.*

/**
 * class for displaying UI screen containing news headlines
 */
class NewsActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, NewsDataViewModelFactory(NewsDataRepository())).get(
            NewsActivityViewModel::class.java
        )
        var binding: ActivityNewsBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_news
        )
        binding.viewmodel = viewModel
        getNews()
    }

    /**
     * make a call to display the news list after fetching the news data from API
     */
    private fun getNews() {
        viewModel.getNews(this@NewsActivity).observe(this, Observer {
            displayNewsHeadlines(it.articleList)
        })
    }

    /**
     * set the news headlines listview
     * @param articleList - list of articles to be displayed on the UI
     */
    private fun displayNewsHeadlines(articleList: List<Article>) {
        news_headlines_rv.layoutManager = LinearLayoutManager(this)
        news_headlines_rv.adapter = NewsListAdapter(articleList)
    }
}
