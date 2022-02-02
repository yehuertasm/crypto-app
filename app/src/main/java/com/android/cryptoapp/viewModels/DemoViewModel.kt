package com.android.cryptoapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.android.cryptoapp.data.DemoNews
import com.android.cryptoapp.entities.interfaces.AppResources
import com.android.cryptoapp.others.Event
import com.android.cryptoapp.uiModels.DemoUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val appResources: AppResources
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _liveData = MutableLiveData<DemoUIModel>()
    val liveData = _liveData as LiveData<DemoUIModel>

    private val _news = MutableLiveData<Event<DemoNews>>()
    val news: LiveData<Event<DemoNews>> = _news

    init {
        _liveData.value = DemoUIModel()
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}