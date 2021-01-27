package com.example.docsappassignment.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val message: String = ""
)

