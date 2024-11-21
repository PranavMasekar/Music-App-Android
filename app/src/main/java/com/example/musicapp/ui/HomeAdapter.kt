package com.example.musicapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.databinding.TrackCardBinding
import com.example.songsapi.models.TrackListItem
import com.example.songsapi.models.TracksResponse

class HomeAdapter: ListAdapter<TrackListItem, HomeAdapter.HomeViewHolder>
    (TrackDiffCallBack()) {

    class HomeViewHolder(val binding : TrackCardBinding) : RecyclerView.ViewHolder(binding.root)

    private class TrackDiffCallBack : DiffUtil.ItemCallback<TrackListItem>() {
        override fun areItemsTheSame(
            oldItem: TrackListItem,
            newItem: TrackListItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TrackListItem,
            newItem: TrackListItem
        ): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater : LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)

        val binding = TrackCardBinding.inflate(inflater,parent,false)

        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val track = getItem(position).track

        holder.binding.artistName.text = track?.artistName ?: "N/A"
        holder.binding.trackName.text = track?.trackName ?: "N/A"
    }
}