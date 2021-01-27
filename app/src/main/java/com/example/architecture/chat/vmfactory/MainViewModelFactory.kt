package com.mingle.chatapp.movie.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.chat.ChatViewModel
import com.example.domain.usecase.ChatUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModelFactory @Inject constructor(private val chatUseCase : ChatUseCase) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChatViewModel(chatUseCase) as T
    }
}