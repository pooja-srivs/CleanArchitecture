package com.example.data.mapper

import com.example.architecture.data.remote.sources.ChatDataModel
import com.example.domain.entities.ChatModel
import javax.inject.Inject

class ChatDataMapper @Inject constructor(){

    fun map(model : ChatDataModel) : ChatModel{

        return ChatModel(
            model.message.chatBotName,
            model.message.chatBotID,
            model.message.message,
            model.message.emotion
        )
    }

}