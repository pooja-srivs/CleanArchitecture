package com.example.architecture.chat.di

import androidx.lifecycle.ViewModelProviders
import com.example.architecture.chat.ChatActivity
import com.example.architecture.chat.ChatViewModel
import com.example.domain.usecase.ChatUseCase
import com.mingle.chatapp.movie.vmfactory.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesViewModelFactory(movieDataRepository: ChatUseCase) = MainViewModelFactory(movieDataRepository)

    @Provides
    fun providesMainViewModel(factory: MainViewModelFactory, activity: ChatActivity) : ChatViewModel = ViewModelProviders
        .of(activity, factory)
        .get(ChatViewModel::class.java)

  /*  @Provides
    fun provideVM(factory: MainViewModelFactory, activity: MainActivity): MainViewModel = ViewModelProvider(activity, factory).get(MainViewModel::class.java)
*/
}