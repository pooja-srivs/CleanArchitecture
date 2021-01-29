package com.clean.architecture.di.modules

import com.clean.data.mapper.ChatDataMapper
import com.clean.architecture.data.database.QueryDao
import com.mingle.chatapp.data.remote.config.ApiManager
import com.clean.architecture.data.remote.sources.DataSource
import com.clean.architecture.data.repository.DataRepositoryImpl
import com.clean.domain.repository.ChatRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceResolver {

    @Singleton
    @Provides
    fun providesMovieSource(apiManager: ApiManager, mapper: ChatDataMapper) : DataSource = DataSource(apiManager.dataService, mapper)

    @Singleton
    @Provides
    fun providesMovieDataRepository(movieSource: DataSource, dao: QueryDao, apiKey : String) : ChatRepository = DataRepositoryImpl(movieSource,
                                                                                                                                    dao,
                                                                                                                                    apiKey)
}