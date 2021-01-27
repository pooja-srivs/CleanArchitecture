package com.example.architecture.data.remote.sources

import com.google.gson.annotations.SerializedName

data class ChatDataModel(

    @SerializedName("success")
    val success : Int,
    @SerializedName("errorMessage")
    val errorMessage : String,
    @SerializedName("message")
    val message : Message


    )

data class Message(
    @SerializedName("chatBotName")
    val chatBotName : String,
    @SerializedName("chatBotID")
    val chatBotID : String,
    @SerializedName("message")
    val message : String? = "",
    @SerializedName("emotion")
    val emotion : String
)