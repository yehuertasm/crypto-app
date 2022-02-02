package com.android.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.android.cryptoapp.data.DemoNews
import com.android.cryptoapp.databinding.ActivityDemoBinding
import com.android.cryptoapp.others.EventObserver
import com.android.cryptoapp.uiModels.DemoUIModel
import com.android.cryptoapp.utils.viewBinding
import com.android.cryptoapp.viewModels.DemoViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoActivity : AppCompatActivity() {

    private val viewModel: DemoViewModel by viewModels()
    private val binding by viewBinding(ActivityDemoBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initializeListeners()
        initializeObserver()
        initializeSubscription()
    }

    private fun initializeListeners() {
        binding.buttonLoadData.setOnClickListener {
            viewModel.getCurrencies()
        }
    }

    private fun initializeObserver() {
        viewModel.liveData.observe(this) { observeData(it) }
    }

    private fun initializeSubscription() {
        viewModel.news.observe(this, EventObserver { handleNews(it) })
    }

    private fun observeData(data: DemoUIModel) {
        val fragment: CurrencyListFragment =
            CurrencyListFragment.newInstance(ArrayList(data.currencies))
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
    }

    private fun handleNews(news: DemoNews) {
        if (news is DemoNews.ShowMessage) {
            Snackbar.make(binding.layoutDemo, news.message, Snackbar.LENGTH_LONG).show()
        }
    }
}