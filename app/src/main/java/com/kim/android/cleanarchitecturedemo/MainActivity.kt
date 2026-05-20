package com.kim.android.cleanarchitecturedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.kim.android.cleanarchitecturedemo.presentation.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect {
                // Update UI elements
                when{
                    it.isLoading -> {
                        Log.d("TAG", "Loading")
                    }
                    it.error.isNotEmpty()->{
                        Log.d("TAG", "Error ${it.error}")
                    }
                    else -> {
                        Log.d("TAG", "Success ${it.users}")
                    }
                }
            }

        }

    }

}