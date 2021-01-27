package com.example.architecture.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface QueryDao {

    @Query("SELECT * FROM ChatData")
    fun getRecentPlaces(): List<ChatData>

    @Insert(onConflict = REPLACE)
    fun insertRecentPlace(searchedSearchData: ChatData)

    @Query("SELECT * FROM ChatData where message= :name")
    fun getItemById(name: String) : ChatData

    @Query("UPDATE ChatData SET message= :name where message GLOB '*' || :name || '*'")
    fun updateItem(name: String)

}