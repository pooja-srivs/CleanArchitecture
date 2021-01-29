package com.clean.domain.usecase

import com.clean.architecture.data.database.ChatData
import com.clean.domain.entities.ChatModel
import com.clean.domain.repository.ChatRepository
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