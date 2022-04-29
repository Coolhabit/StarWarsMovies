package ru.coolhabit.starwarsmovies

import android.app.Application
import ru.coolhabit.remote_module.DaggerRemoteComponent
import ru.coolhabit.starwarsmovies.di.AppComponent
import ru.coolhabit.starwarsmovies.di.DaggerAppComponent
import ru.coolhabit.starwarsmovies.di.modules.DatabaseModule
import ru.coolhabit.starwarsmovies.di.modules.DomainModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteProvider(remoteProvider)
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}