package com.android.cryptoapp.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel()