package com.navermovie.daggerexamplewithnavermovie.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.navermovie.daggerexamplewithnavermovie.MovieApplication
import com.navermovie.daggerexamplewithnavermovie.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MovieApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
