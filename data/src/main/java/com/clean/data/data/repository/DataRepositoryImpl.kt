package com.clean.architecture.data.repository

import com.clean.architecture.data.database.ChatData
import com.clean.architecture.data.database.QueryDao
import com.clean.architecture.data.remote.sources.DataSource
import com.clean.domain.entities.ChatModel
import com.clean.domain.repository.ChatRepository
import io.reactivex.Single

class DataRepositoryImpl(
    private val dataSource: DataSource,
    private val dao: QueryDao,
    private val apiKey: String
    ) : ChatRepository {


  /*  fun getNearbyPlaceData(message : String) : Single<ChatDataModel> {
        return dataSource.getSearchData(apiKey, message, "63906", "pooja")
    }*/

    override fun getNearbyPlaceData(message : String) : Single<ChatModel> {
        return dataSource.getSearchData(apiKey, message, "63906", "pooja")
    }

    override fun getAllChatDataPlacesData() : List<ChatData> {
        return dao.getRecentPlaces()
    }

    override fun insertOrUpdate(ChatData: ChatData) {
        val itemFromDB: ChatData
        itemFromDB = dao.getItemById(ChatData.message)

        if (itemFromDB == null){
            dao.insertRecentPlace(ChatData)
        }else{
            dao.updateItem(ChatData.message)
        }
    }


}