package com.example.colours.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.colours.repository.online.OnlineWordRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ColoursActivityViewModelFactory @Inject constructor(
    private val onlineWordRepository: OnlineWordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ColoursActivityViewModel(onlineWordRepository) as T
    }
}