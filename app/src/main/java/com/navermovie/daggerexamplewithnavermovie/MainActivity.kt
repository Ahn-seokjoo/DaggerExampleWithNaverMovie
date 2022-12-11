package com.navermovie.daggerexamplewithnavermovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            android.util.Log.d("tjrwn", "onCreate: ${NetworkManager.movieApi.getMovieList("해리포터")}")
        }
    }
}
