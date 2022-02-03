package com.android.cryptoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.cryptoapp.R
import com.android.cryptoapp.adapters.diffutil.CurrenciesCallback
import com.android.cryptoapp.data.CurrencyEvent
import com.android.cryptoapp.databinding.ItemCurrencyBinding
import com.android.cryptoapp.entities.data.Currency
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

class CurrencyListAdapter : RecyclerView.Adapter<CurrencyListAdapter.CurrencyListViewHolder>() {

    private val currencies = mutableListOf<Currency>()

    private val _events = PublishSubject.create<CurrencyEvent>()
    val events: Observable<CurrencyEvent> = _events.hide()

    fun setData(currenciesList: List<Currency>) {
        val diffCallback = CurrenciesCallback(currencies, currenciesList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        currencies.clear()
        currencies.addAll(currenciesList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrencyListViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    inner class CurrencyListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val binding = ItemCurrencyBinding.bind(itemView)

        private lateinit var currencyName: String

        init {
            itemView.setOnClickListener {
                _events.onNext(CurrencyEvent.CurrencySelected(currencyName))
            }
        }

        fun bind(currency: Currency) {
            currencyName = currency.name
            binding.tvSymbol.text = currency.symbol
            binding.tvName.text = currency.name
        }
    }

}