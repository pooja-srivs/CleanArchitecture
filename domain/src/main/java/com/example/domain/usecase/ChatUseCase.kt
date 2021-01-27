package com.example.domain.usecase

import com.example.architecture.data.database.ChatData
import com.example.domain.entities.ChatModel
import com.example.domain.repository.ChatRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChatUseCase @Inject constructor(val chatRepository : ChatRepository) {

    sealed class Result{

       data class Success(val chatData : ChatModel) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }


    fun execute(message : String): Observable<Result> {

       return chatRepository.getNearbyPlaceData(message)
           .toObservable()
           .map {
               Result.Success(it) as Result
           }
           .onErrorReturn{Result.Failure(it)}
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
    }

    fun insertOrUpdateData(chatData: ChatData) {
        chatRepository.insertOrUpdate(chatData)
    }

    fun getAllChatDataPlacesData() : List<ChatData>{
       return chatRepository.getAllChatDataPlacesData()
    }
}