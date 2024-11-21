package com.example.musicapp.ui.lyrics

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.musicapp.databinding.ActivityLyricsBinding
import com.example.songsapi.models.Track
import java.io.Serializable

class LyricsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLyricsBinding

    private val lyricsViewModel by viewModels<LyricsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLyricsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val track = intent.getSerializableExtra("track") as? Track

        track?.let {
            track.trackId?.let { it1 -> lyricsViewModel.getLyrics(it1) }
        }

    }
}