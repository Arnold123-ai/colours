package com.example.colours.repository.online

import javax.inject.Inject

class OnlineWordRepository @Inject constructor(private val onlineWordClient: OnlineWordClient) {

    suspend fun getRandomNames() : List<String> =  onlineWordClient.getNames()



}