package com.example.musicapp.ui.lyrics

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.data.SongsRepository
import com.example.songsapi.models.Lyrics
import kotlinx.coroutines.launch

class LyricsViewModel : ViewModel() {

    private val repository = SongsRepository()

    private val _lyrics = MutableLiveData<Lyrics?>()

    val lyrics : LiveData<Lyrics?> = _lyrics

    fun getLyrics(trackID: Int) {
        viewModelScope.launch {
            val tracks = repository.getLyrics(id = trackID)

            Log.d("ERROR", "Lyrics: ${tracks?.lyricsBody}")

            tracks?.let {
                _lyrics.postValue(it)
            }
        }
    }
}