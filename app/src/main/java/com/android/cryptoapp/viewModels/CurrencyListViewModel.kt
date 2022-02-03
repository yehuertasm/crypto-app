package com.android.cryptoapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.cryptoapp.R
import com.android.cryptoapp.data.CurrencyEvent
import com.android.cryptoapp.data.CurrencyListNews
import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.AppResources
import com.android.cryptoapp.others.Event
import com.android.cryptoapp.uiModels.CurrencyListUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val appResources: AppResources
): ViewModel() {

    private val disposables = CompositeDisposable()

    private val _liveData = MutableLiveData<CurrencyListUIModel>()
    val liveData = _liveData as LiveData<CurrencyListUIModel>

    private val _news = MutableLiveData<Event<CurrencyListNews>>()
    val news: LiveData<Event<CurrencyListNews>> = _news

    private fun onNextNews(news: CurrencyListNews) {
        _news.postValue(Event(news))
    }

    init {
        _liveData.value = CurrencyListUIModel()
    }

    fun setData(currencyList: List<Currency>) {
        _liveData.value = liveData.value?.copy(currencies = currencyList)
    }

    fun setCurrencyEvent(currencyEvent: Observable<CurrencyEvent>) {
        disposables.add(
            currencyEvent
                .observeOn(Schedulers.io())
                .switchMapCompletable {
                    when (it) {
                        is CurrencyEvent.CurrencySelected -> showMessage(it.name)
                    }
                }.subscribeOn(Schedulers.io())
                .subscribe({

                }, {
                    handleError()
                })
        )
    }

    private fun showMessage(currencyName: String): Completable {
        return Completable.fromCallable {
            onNextNews(CurrencyListNews.ShowMessage(currencyName))
        }
    }

    private fun handleError() {
        onNextNews(CurrencyListNews.ShowMessage(appResources.getString(R.string.error_getting_data)))
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}