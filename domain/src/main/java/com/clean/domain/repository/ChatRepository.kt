package com.clean.domain.repository

import com.clean.architecture.data.database.ChatData
import com.clean.domain.entities.ChatModel
import io.reactivex.Single

interface ChatRepository {

    fun getNearbyPlaceData(message : String) : Single<ChatModel>

    fun insertOrUpdate(chatData: ChatData)

    fun getAllChatDataPlacesData(): List<ChatData>
}