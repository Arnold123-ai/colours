package com.example.colours

import com.example.colours.random_colour_generator.RandomColourGenerator
import org.junit.Assert
import org.junit.Test

class RandomColourGeneratorUnitTest {

    val randomColourGenerator= RandomColourGenerator()

    @Test
    fun `random number created is less than 16 greater than 0 `(){

        for (i in 1..100) {
            val randomNumber = randomColourGenerator.generateRandomNumber()
            Assert.assertTrue(randomNumber in 0..15)
        }

    }

    @Test
    fun `convert the random number into a hexaDecimal`() {
        val number = arrayOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[0]) == '0')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[1]) == '1')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[2]) == '2')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[3]) == '3')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[4]) == '4')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[5]) == '5')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[6]) == '6')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[7]) == '7')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[8]) == '8')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[9]) == '9')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[10]) == 'A')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[11]) == 'B')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[12]) == 'C')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[13]) == 'D')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[14]) == 'E')
        Assert.assertTrue(randomColourGenerator.converyToHexiDecimal(number[15]) == 'F')

    }

    @Test
    fun `get a hexadecimal String from an array of 6 numbers`() {
        val hexaNumbers = arrayOf(3,5,13,15,12,4)
        Assert.assertTrue(randomColourGenerator.generatHexaString(hexaNumbers) == "#35DFC4")
    }





}