package com.example.colours.repository.online

import com.example.colours.com.END_POINT
import retrofit2.http.GET

interface OnlineWordClient {

    @GET(END_POINT)
    suspend fun getNames() : List<String>

}

