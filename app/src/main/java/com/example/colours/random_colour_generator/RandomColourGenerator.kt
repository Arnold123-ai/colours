package com.example.colours.random_colour_generator

import java.lang.Math.random
import java.lang.StringBuilder

class RandomColourGenerator {


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

    fun generatHexaString(hexaNumbers: IntArray): String {
        val colourHexa = StringBuilder()
        colourHexa.append('#')
        for (element in hexaNumbers) {
            colourHexa.append(converyToHexiDecimal(element))
        }
        return colourHexa.toString()
    }

    fun generateRandomHexaDecimal() : String {
        val randomNumbers : IntArray = intArrayOf(generateRandomNumber(),generateRandomNumber(), generateRandomNumber(),
            generateRandomNumber(), generateRandomNumber(), generateRandomNumber())
        return generatHexaString(randomNumbers)
    }
}