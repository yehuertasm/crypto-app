package com.android.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import com.android.cryptoapp.viewModels.DemoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoActivity : AppCompatActivity() {

    private val viewModel: DemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
    }
}