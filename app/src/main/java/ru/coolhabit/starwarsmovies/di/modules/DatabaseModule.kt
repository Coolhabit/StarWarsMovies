package ru.coolhabit.starwarsmovies.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.coolhabit.starwarsmovies.data.MainRepository
import ru.coolhabit.starwarsmovies.data.dao.FilmDao
import ru.coolhabit.starwarsmovies.data.db.AppDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).fallbackToDestructiveMigration().build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}