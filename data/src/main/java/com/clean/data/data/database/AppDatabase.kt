package com.clean.architecture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ChatData::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun queryDao(): QueryDao

}