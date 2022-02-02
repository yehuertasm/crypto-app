package com.android.cryptoapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.cryptoapp.R
import com.android.cryptoapp.data.DemoNews
import com.android.cryptoapp.entities.data.Currency
import com.android.cryptoapp.entities.interfaces.AppResources
import com.android.cryptoapp.entities.qualifiers.GetCurrencies
import com.android.cryptoapp.others.Event
import com.android.cryptoapp.others.SingleUseCase
import com.android.cryptoapp.uiModels.DemoUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val appResources: AppResources,
    @GetCurrencies private val getCurrenciesUseCase: SingleUseCase<Unit, List<Currency>>
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _liveData = MutableLiveData<DemoUIModel>()
    val liveData = _liveData as LiveData<DemoUIModel>

    private val _news = MutableLiveData<Event<DemoNews>>()
    val news: LiveData<Event<DemoNews>> = _news

    private fun onNextNews(news: DemoNews) {
        _news.postValue(Event(news))
    }

    init {
        _liveData.value = DemoUIModel()
    }

    fun getCurrencies() {
        disposables.add(
            getCurrenciesUseCase.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _liveData.value = liveData.value?.copy(currencies = it)
                }, {
                    handleError()
                })
        )
    }

    private fun handleError() {
        onNextNews(DemoNews.ShowMessage(appResources.getString(R.string.error_getting_data)))
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}