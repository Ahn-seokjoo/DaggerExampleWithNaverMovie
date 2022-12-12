package com.navermovie.daggerexamplewithnavermovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.navermovie.daggerexamplewithnavermovie.databinding.RecyclerviewItemBinding

class MovieAdapter : ListAdapter<MovieUiState, MovieAdapter.MovieViewHolder>(movieDiffUtil) {
    class MovieViewHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieUiState?) {
            item?.let {
                binding.run {
                    tvTitle.text = it.title
                    tvActors.text = it.actors
                    tvDirector.text = it.director
                    Glide.with(ivPoster).load(it.poster).into(ivPoster)
                }
            }
        }

    }

    companion object {
        private val movieDiffUtil = object : DiffUtil.ItemCallback<MovieUiState>() {
            override fun areItemsTheSame(oldItem: MovieUiState, newItem: MovieUiState): Boolean {
                return oldItem.link == newItem.link
            }

            override fun areContentsTheSame(oldItem: MovieUiState, newItem: MovieUiState): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            RecyclerviewItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
