package com.android.cryptoapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.uiModels.CurrencyListUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(): ViewModel() {

    private val _liveData = MutableLiveData<CurrencyListUIModel>()
    val liveData = _liveData as LiveData<CurrencyListUIModel>

    init {
        _liveData.value = CurrencyListUIModel()
    }

    fun setData(currencyList: List<Currency>) {
        _liveData.value = liveData.value?.copy(currencies = currencyList)
    }
}