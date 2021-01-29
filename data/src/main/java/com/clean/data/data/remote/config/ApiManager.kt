package com.mingle.chatapp.data.remote.config

import com.clean.architecture.data.remote.sources.DataService
import retrofit2.Retrofit

class ApiManager(val retrofit : Retrofit) {

    val dataService : DataService by lazy {
        retrofit.create(DataService::class.java)
    }
}