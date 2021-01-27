package com.example.architecture.di.modules

import com.example.architecture.chat.ChatActivity
import com.example.architecture.chat.di.DataModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityResolver {

    @ContributesAndroidInjector(modules = arrayOf(DataModule::class))
    abstract fun providesMainActivity() : ChatActivity
}