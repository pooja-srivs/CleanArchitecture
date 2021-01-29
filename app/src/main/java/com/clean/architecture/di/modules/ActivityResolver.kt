package com.clean.architecture.di.modules

import com.clean.architecture.chat.ChatActivity
import com.clean.architecture.chat.di.DataModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityResolver {

    @ContributesAndroidInjector(modules = arrayOf(DataModule::class))
    abstract fun providesMainActivity() : ChatActivity
}