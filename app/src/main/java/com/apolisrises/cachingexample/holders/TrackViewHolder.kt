package com.apolisrises.cachingexample.holders

import androidx.recyclerview.widget.RecyclerView
import com.apolisrises.cachingexample.data.Result
import com.apolisrises.cachingexample.databinding.ViewHolderTrackBinding

class TrackViewHolder(val binding: ViewHolderTrackBinding)
:RecyclerView.ViewHolder(binding.root){
    fun bindData(result: Result) {
        binding.apply {
            tvTrack.text = result.trackName
            tvArtistName.text = result.artistName
        }
    }
}