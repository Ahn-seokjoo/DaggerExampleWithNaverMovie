package com.navermovie.daggerexamplewithnavermovie

import com.navermovie.daggerexamplewithnavermovie.ui.MainActivity
import com.navermovie.daggerexamplewithnavermovie.ui.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, BindRepositorys::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
}
