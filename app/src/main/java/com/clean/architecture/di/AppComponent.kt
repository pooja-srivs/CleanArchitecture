package com.clean.architecture.di

import com.clean.architecture.MyApp
import com.clean.architecture.di.modules.ActivityResolver
import com.clean.architecture.di.modules.DataSourceResolver
import com.clean.architecture.di.modules.DatabaseResolver
import com.clean.architecture.di.modules.NetworkResolver
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    ActivityResolver::class,
    DataSourceResolver::class,
    NetworkResolver::class,
    DatabaseResolver::class))
interface AppComponent : AndroidInjector<MyApp>{

    override fun inject(myApp: MyApp)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(myApp: MyApp): Builder

        fun build(): AppComponent
    }

}