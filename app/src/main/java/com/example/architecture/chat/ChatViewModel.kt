package com.example.architecture.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.data.database.ChatData
import com.example.domain.entities.ChatModel
import com.example.domain.usecase.ChatUseCase
import io.reactivex.disposables.CompositeDisposable

class ChatViewModel(private val chatUseCase: ChatUseCase) : ViewModel() {

    var messagesLiveData : MutableLiveData<ChatModel> = MutableLiveData()

    var errorLiveData : MutableLiveData<Throwable> = MutableLiveData()
    var isLoading : MutableLiveData<Boolean> = MutableLiveData()
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    fun getNearbyPlaces(message: String) {
        isLoading.value = true
        chatUseCase.execute(message)
             .subscribe{chatData ->

                 postData(chatData)

                 }.let {
                compositeDisposable.add(it)
            }
     }

    fun postData(result: ChatUseCase.Result) {

        when(result){

            is ChatUseCase.Result.Success ->{
                isLoading.postValue(false)
                messagesLiveData.postValue(result.chatData)

                insertItem(result.chatData.message?: "")
            }

            is ChatUseCase.Result.Failure ->{
                errorLiveData.postValue(result.throwable)
                isLoading.postValue(false)
            }
        }
    }

    fun insertItem(message: String) {
        chatUseCase.insertOrUpdateData(ChatData(message = message))
    }

    fun getAllChatDataData() : List<ChatData>{
        return chatUseCase.getAllChatDataPlacesData()
    }

    override fun onCleared() {
        super.onCleared()
        if (compositeDisposable != null){
            compositeDisposable.clear()
        }
    }
}