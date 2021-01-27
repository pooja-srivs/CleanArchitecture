package com.example.domain.entities

data class ChatModel (
    val chatBotName : String,
    val chatBotID : String,
    val message : String? = "",
    val emotion : String
)