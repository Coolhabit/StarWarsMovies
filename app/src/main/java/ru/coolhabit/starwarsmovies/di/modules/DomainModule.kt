package ru.coolhabit.starwarsmovies.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.coolhabit.remote_module.TmdbApi
import ru.coolhabit.starwarsmovies.data.MainRepository
import ru.coolhabit.starwarsmovies.data.shared.PreferenceProvider
import ru.coolhabit.starwarsmovies.domain.Interactor
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}