package com.clean.architecture.data.remote.sources

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DataService {

    @GET("chat?")
    fun getSearchData(@Query("apiKey") apiKey: String,
                      @Query("message") message: String,
                      @Query("chatBotID") chatBotID: String,
                      @Query("externalID") externalID: String): Single<ChatDataModel>
}