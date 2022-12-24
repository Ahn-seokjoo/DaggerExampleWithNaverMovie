package com.navermovie.daggerexamplewithnavermovie.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.navermovie.daggerexamplewithnavermovie.MovieApplication
import com.navermovie.daggerexamplewithnavermovie.R
import com.navermovie.daggerexamplewithnavermovie.databinding.FragmentMainBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val movieViewModel: MovieViewModel by activityViewModels(factoryProducer = { viewModelFactory })

    private val movieAdapter by lazy {
        MovieAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as MovieApplication).appComponent.inject(this)
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
//        movieViewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModelStore.clear()
    }
}
