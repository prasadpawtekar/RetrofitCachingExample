package com.apolisrises.cachingexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.cachingexample.data.Result
import com.apolisrises.cachingexample.databinding.ViewHolderTrackBinding
import com.apolisrises.cachingexample.holders.TrackViewHolder

class TrackAdapter(val tracks: List<Result>):
RecyclerView.Adapter<TrackViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewHolderTrackBinding = ViewHolderTrackBinding.inflate(inflater, parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bindData(tracks[position])
    }

    override fun getItemCount() = tracks.size
}