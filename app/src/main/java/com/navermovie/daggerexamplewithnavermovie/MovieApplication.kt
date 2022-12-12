package com.navermovie.daggerexamplewithnavermovie

import android.app.Application

class MovieApplication : Application() {
    val appComponent = DaggerApplicationComponent.create()
}
