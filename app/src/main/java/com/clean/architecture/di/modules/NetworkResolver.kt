package com.clean.architecture.di.modules

import com.clean.architecture.data.remote.config.BaseUrl
import com.mingle.chatapp.data.remote.config.ApiManager
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkResolver {

    @Singleton
    @Provides
    fun providesApiKey() : String = "6nt5d1nJHkqbkphe"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor()

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {

        val okHttpClient = OkHttpClient.Builder()
            .build()

        return okHttpClient
    }

    @Singleton
    @Provides
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl.base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesRetrofit(retrofit: Retrofit) = ApiManager(retrofit)


}