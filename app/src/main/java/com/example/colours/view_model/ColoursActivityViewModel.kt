package com.example.colours.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.colours.com.ColourEntity
import com.example.colours.random_colour_generator.RandomColourGenerator
import com.example.colours.repository.online.OnlineWordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception


class ColoursActivityViewModel(
    private val onlineWordRepository: OnlineWordRepository,
    private val randomColourGenerator: RandomColourGenerator
) : ViewModel() {

    val loadingState : LiveData<LoadingState>
        get() = mLoadingState
    private var mLoadingState = MutableLiveData<LoadingState>()

    fun getWords() {
        mLoadingState.value = LoadingState.LOADING
        GlobalScope.launch(Dispatchers.IO) {
            try {
                mLoadingState.postValue(LoadingState.LOADING)
                val nameStrings : List<String> = onlineWordRepository.getRandomNames()
                val listOfColourEntity = ArrayList<ColourEntity>()
                for (element in nameStrings){
                    listOfColourEntity.add(ColourEntity(
                        element,
                        randomColourGenerator.generateRandomHexaDecimal()))
                }
                mLoadingState.postValue(LoadingState.SUCCESS(listOfColourEntity))

            } catch (e : Exception){
                if (e.message != null) {
                    mLoadingState.postValue(LoadingState.FAILURE(e.message))
                } else {
                    mLoadingState.postValue(LoadingState.FAILURE("No Error Message!"))
                }
            }
        }


    }


    sealed class LoadingState {
        object LOADING : LoadingState()
        data class SUCCESS(val listOfWords : ArrayList<ColourEntity>) : LoadingState()
        data class FAILURE(val errorMessage : String?) : LoadingState()
    }
}