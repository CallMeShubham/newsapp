package com.example.wallmart.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.wallmart.R
import com.example.wallmart.databinding.ActivityNewsBinding
import com.example.wallmart.viewmodel.NewsActivityViewModel

/**
 * class for displaying UI screen containing news headlines
 */
class NewsActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsActivityViewModel::class.java)
        var binding: ActivityNewsBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_news
        )
        binding.viewmodel = viewModel
        viewModel.getNews()
    }
}
