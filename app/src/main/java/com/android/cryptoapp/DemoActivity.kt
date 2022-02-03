package com.android.cryptoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.cryptoapp.data.DemoNews
import com.android.cryptoapp.databinding.ActivityDemoBinding
import com.android.cryptoapp.entities.interfaces.ActionListener
import com.android.cryptoapp.others.EventObserver
import com.android.cryptoapp.uiModels.DemoUIModel
import com.android.cryptoapp.utils.viewBinding
import com.android.cryptoapp.viewModels.DemoViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoActivity : AppCompatActivity(), ActionListener {

    private val viewModel: DemoViewModel by viewModels()
    private val binding by viewBinding(ActivityDemoBinding::inflate)
    private val currenciesFragment = CurrencyListFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initializeFragment()
        initializeListeners()
        initializeObserver()
        initializeSubscription()
    }

    private fun initializeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, currenciesFragment)
            .commit()
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
        currenciesFragment.setCurrenciesData(data.currencies)
    }

    private fun handleNews(news: DemoNews) {
        if (news is DemoNews.ShowMessage) {
            Snackbar.make(binding.layoutDemo, news.message, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onCurrencySelected(currencyName: String) {
        Toast.makeText(
            this,
            getString(R.string.currency_selected_message, currencyName),
            Toast.LENGTH_SHORT
        ).show()
    }
}