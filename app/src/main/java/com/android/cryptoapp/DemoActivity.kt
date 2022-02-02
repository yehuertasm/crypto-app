package com.android.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import com.android.cryptoapp.data.DemoNews
import com.android.cryptoapp.databinding.ActivityDemoBinding
import com.android.cryptoapp.others.EventObserver
import com.android.cryptoapp.uiModels.DemoUIModel
import com.android.cryptoapp.viewModels.DemoViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoActivity : AppCompatActivity() {

    private val viewModel: DemoViewModel by viewModels()
    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeObserver()
        initializeSubscription()
    }

    private fun initializeObserver() {
        viewModel.liveData.observe(this, { observeData(it) })
    }

    private fun initializeSubscription() {
        viewModel.news.observe(this, EventObserver { handleNews(it) })
    }

    private fun observeData(data: DemoUIModel) {

    }

    private fun handleNews(news: DemoNews) {
        if (news is DemoNews.ShowMessage) {
            Snackbar.make(binding.layoutDemo, news.message, Snackbar.LENGTH_LONG).show()
        }
    }
}