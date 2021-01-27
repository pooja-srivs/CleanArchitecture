package com.example.domain.repository

import com.example.architecture.data.database.ChatData
import com.example.domain.entities.ChatModel
import io.reactivex.Single

interface ChatRepository {

    fun getNearbyPlaceData(message : String) : Single<ChatModel>

    fun insertOrUpdate(chatData: ChatData)

    fun getAllChatDataPlacesData(): List<ChatData>
}