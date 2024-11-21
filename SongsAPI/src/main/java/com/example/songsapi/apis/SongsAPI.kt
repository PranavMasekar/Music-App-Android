package com.example.songsapi.apis

import com.example.songsapi.models.TracksResponse
import retrofit2.http.GET
import retrofit2.Response

interface SongsAPI {

    @GET("chart.tracks.get")
    suspend fun getTracks(): Response<TracksResponse>
}