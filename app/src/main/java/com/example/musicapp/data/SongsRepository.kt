package com.example.musicapp.data

import com.example.songsapi.SongsAPIClient
import com.example.songsapi.models.TrackListItem
import com.example.songsapi.models.TracksResponse

class SongsRepository {

    private val api = SongsAPIClient.api

    suspend fun getAllTracks(): List<TrackListItem?>? {
        val response = api.getTracks()

        return response.body()?.message?.body?.trackList
    }
}