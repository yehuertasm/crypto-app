package com.android.cryptoapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.cryptoapp.adapters.CurrencyListAdapter
import com.android.cryptoapp.data.CurrencyListNews
import com.android.cryptoapp.databinding.FragmentCurrencyListBinding
import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.ActionListener
import com.android.cryptoapp.others.EventObserver
import com.android.cryptoapp.uiModels.CurrencyListUIModel
import com.android.cryptoapp.utils.viewBinding
import com.android.cryptoapp.viewModels.CurrencyListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyListFragment : Fragment(R.layout.fragment_currency_list) {

    companion object {
        fun newInstance(): CurrencyListFragment {
            return CurrencyListFragment()
        }
    }

    private val viewModel: CurrencyListViewModel by viewModels()
    private val binding by viewBinding(FragmentCurrencyListBinding::bind)

    private var currenciesAdapter = CurrencyListAdapter()

    private val actionListener: ActionListener?
        get() = activity as? ActionListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeObserver()
        initializeListeners()
        initializeRecyclerView()
        initializeSubscription()
    }

    fun setCurrenciesData(currenciesList: List<Currency>) {
        viewModel.setData(currenciesList)
    }

    private fun initializeListeners() {
        viewModel.setCurrencyEvent(currenciesAdapter.events)
    }

    private fun initializeRecyclerView() {
        binding.recyclerViewCurrencies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = currenciesAdapter
        }
    }

    private fun initializeObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) { observeData(it) }
    }

    private fun observeData(uiModel: CurrencyListUIModel) {
        currenciesAdapter.setData(uiModel.currencies)
    }

    private fun initializeSubscription() {
        viewModel.news.observe(viewLifecycleOwner, EventObserver { handleNews(it) })
    }

    private fun handleNews(news: CurrencyListNews) {
        if (news is CurrencyListNews.ShowMessage) {
            actionListener?.onCurrencySelected(news.currencyName)
        }
    }
}