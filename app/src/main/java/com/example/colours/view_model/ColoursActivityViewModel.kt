package com.example.colours.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.colours.com.ColourEntity
import com.example.colours.repository.online.OnlineWordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.Math.random


class ColoursActivityViewModel(
    private val onlineWordRepository: OnlineWordRepository
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
                        generateRandomHexaDecimal()
                        )
                    )
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
   companion object RandomColourGenerator {
        fun generateRandomNumber() = (random()*15).toInt()
        fun converyToHexiDecimal(int: Int): Char {
            return when(int) {
                0 -> '0'
                1 -> '1'
                2 -> '2'
                3 -> '3'
                4 -> '4'
                5 -> '5'
                6 -> '6'
                7 -> '7'
                8 -> '8'
                9 -> '9'
                10 -> 'A'
                11 -> 'B'
                12 -> 'C'
                13 -> 'D'
                14 -> 'E'
                15 -> 'F'
                else -> 'X'
            }
        }
        fun generatHexaString(hexaNumbers: Array<Int>): String {
            val colourHexa = StringBuilder()
            colourHexa.append('#')
            for (element in hexaNumbers) {
                colourHexa.append(converyToHexiDecimal(element))
            }
            return colourHexa.toString()
        }
        fun generateRandomHexaDecimal() : String {
            val randomNumbers = arrayOf(generateRandomNumber(),
            generateRandomNumber(),
            generateRandomNumber(),
            generateRandomNumber(),
            generateRandomNumber(),
            generateRandomNumber())
            return generatHexaString(randomNumbers)
        }
    }

    sealed class LoadingState {
        object LOADING : LoadingState()
        data class SUCCESS(val listOfWords : ArrayList<ColourEntity>) : LoadingState()
        data class FAILURE(val errorMessage : String?) : LoadingState()
    }
}