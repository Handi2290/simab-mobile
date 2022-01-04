package com.example.kotlin.mvp.androidmvparchitexturekotlin.di

import androidachitecturecomponent.example.di.AppComponent
import com.example.kotlin.mvp.androidmvparchitexturekotlin.di.scope.NewsScope
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.add.AddActivity
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.detail.DetailActivity
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.home.gallery.GalleryFragment
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.home.home
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.home.item.HomeFragment
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.login.LoginActivity
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.news.NewsActivity
import com.example.kotlin.mvp.androidmvparchitexturekotlin.ui.splash.SplashActivity
import dagger.Component

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

@NewsScope
@Component(modules = arrayOf(NewsModule::class), dependencies = arrayOf(AppComponent::class))
interface NewsComponent {

    fun inject(view: home)
    fun inject(view: LoginActivity)
    fun inject(view: NewsActivity)
    fun inject(view: SplashActivity)
    fun inject(view: HomeFragment)
    fun inject(view: GalleryFragment)
    fun inject(view: DetailActivity)
    fun inject(view: AddActivity)
}