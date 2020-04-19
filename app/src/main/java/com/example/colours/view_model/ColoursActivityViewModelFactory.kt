package com.example.colours.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.colours.random_colour_generator.RandomColourGenerator
import com.example.colours.repository.online.OnlineWordRepository
import javax.inject.Inject

class ColoursActivityViewModelFactory @Inject constructor(
    private val onlineWordRepository: OnlineWordRepository,
    private val randomColourGenerator: RandomColourGenerator
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ColoursActivityViewModel(onlineWordRepository,randomColourGenerator) as T
    }
}