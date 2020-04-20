package com.example.colours

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.colours.repository.online.OnlineWordRepository
import com.example.colours.view_model.ColoursActivityViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
*/

@RunWith(MockitoJUnitRunner::class)
class ColoursActivityViewModelUnitTest {


    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var onlineWordRepository: OnlineWordRepository

    private lateinit var viewModel : ColoursActivityViewModel

    @Before
    fun setup() {
        viewModel = ColoursActivityViewModel(onlineWordRepository)
    }

    @Test
    fun ` when an empty list is shown the loading state is failure`(){

    }

    @Test
    fun `random number created is less than 16 greater than 0 `(){
        for (i in 1..100) {
            val randomNumber = ColoursActivityViewModel.generateRandomNumber()
            Assert.assertTrue(randomNumber in 0..15)
        }
    }

    @Test
    fun `convert the random number into a hexaDecimal`() {
        val number = arrayOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[0]) == '0')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[1]) == '1')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[2]) == '2')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[3]) == '3')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[4]) == '4')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[5]) == '5')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[6]) == '6')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[7]) == '7')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[8]) == '8')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[9]) == '9')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[10]) == 'A')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[11]) == 'B')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[12]) == 'C')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[13]) == 'D')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[14]) == 'E')
        Assert.assertTrue(ColoursActivityViewModel.converyToHexiDecimal(number[15]) == 'F')

    }

    @Test
    fun `get a hexadecimal String from an array of 6 numbers`() {
        val hexaNumbers = arrayOf(3,5,13,15,12,4)
        Assert.assertTrue(ColoursActivityViewModel.generatHexaString(hexaNumbers) == "#35DFC4")
    }


}
