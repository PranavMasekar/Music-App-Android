package com.example.musicapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.data.SongsRepository
import com.example.songsapi.models.TrackListItem
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = SongsRepository()

    private val _tracks = MutableLiveData<List<TrackListItem?>>()

    val tracks : LiveData<List<TrackListItem?>> = _tracks

    fun getTracks() {
        viewModelScope.launch {
            val tracks = repository.getAllTracks()

            Log.d("ERROR", "getTracks: ${tracks?.size}")

            tracks?.let {
                _tracks.postValue(it)
            }
        }
    }
}