package com.clean.architecture.data.remote.sources

import com.clean.data.mapper.ChatDataMapper
import com.clean.domain.entities.ChatModel
import io.reactivex.Single

class DataSource(val dataService: DataService,
                 val mapper : ChatDataMapper
) {

    /*fun getSearchData(apiKey : String, message : String, botId : String, externalId : String): Single<ChatDataModel> {
        return dataService.getSearchData(apiKey, message, botId, externalId)
    }*/

    fun getSearchData(apiKey : String, message : String, botId : String, externalId : String): Single<ChatModel> {
        return dataService.getSearchData(apiKey, message, botId, externalId)
            .map { mapper.map(it) }
    }
}