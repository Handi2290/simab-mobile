package com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote

import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.model.Home
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.model.Login
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.model.News
import io.reactivex.Flowable
import retrofit2.Response

/**
 * Created by Ali DOUIRI on 27/04/2018.
 * my.alidouiri@gmail.com
 */

class RemoteDataSource constructor(private val remoteService: RemoteService)  {

    fun getAriclesFromApi() : Flowable<Response<News>> = remoteService.getArticlesFromApi()
    fun login(user: String, password: String) : Flowable<Response<Login>> = remoteService.login(user, password)
    fun getHomeF(id: String) : Flowable<Response<Home>> = remoteService.getHomeF(id)
    fun getHome() : Flowable<Response<Home>> = remoteService.getHome()

}