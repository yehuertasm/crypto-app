package com.android.cryptoapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.cryptoapp.adapters.CurrencyListAdapter
import com.android.cryptoapp.databinding.FragmentCurrencyListBinding
import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.uiModels.CurrencyListUIModel
import com.android.cryptoapp.utils.viewBinding
import com.android.cryptoapp.viewModels.CurrencyListViewModel

class CurrencyListFragment : Fragment(R.layout.fragment_currency_list) {

    private val viewModel: CurrencyListViewModel by viewModels()
    private val binding by viewBinding(FragmentCurrencyListBinding::bind)

    private var currenciesAdapter = CurrencyListAdapter()

    companion object {
        fun newInstance(currenciesList: ArrayList<Currency>): CurrencyListFragment {
            val args = Bundle()
            args.putParcelableArrayList("list", currenciesList);
            val fragment = CurrencyListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeVieModel()
        initializeObserver()
        initializeRecyclerView()
    }

    private fun initializeVieModel() {
        val args = arguments
        val currenciesList: ArrayList<Currency>  = args?.getParcelableArrayList<Currency>("list") as ArrayList<Currency>
        viewModel.setData(currenciesList)
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
}