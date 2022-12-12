package com.navermovie.daggerexamplewithnavermovie.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.navermovie.daggerexamplewithnavermovie.R
import com.navermovie.daggerexamplewithnavermovie.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val movieViewModel: MovieViewModel by activityViewModels()
    private val movieAdapter by lazy {
        MovieAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        initView()
        getMovieList("해리포터")

        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.movieUiState.collect {
                movieAdapter.submitList(it)
            }
        }
    }

    private fun getMovieList(movieQuery: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.getMovieList(movieQuery)
        }
    }

    private fun initView() {
        binding.recyclerView.adapter = movieAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
