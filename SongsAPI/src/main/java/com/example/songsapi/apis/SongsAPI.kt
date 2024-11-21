package com.example.songsapi.apis

import com.example.songsapi.models.LyricsResponse
import com.example.songsapi.models.TracksResponse
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface SongsAPI {

    @GET("chart.tracks.get")
    suspend fun getTracks(): Response<TracksResponse>

    @GET("track.lyrics.get")
    suspend fun getLyrics(@Query("track_id") trackId: Int) : Response<LyricsResponse>
}