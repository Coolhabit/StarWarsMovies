package ru.coolhabit.starwarsmovies.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.coolhabit.starwarsmovies.data.dao.FilmDao
import ru.coolhabit.starwarsmovies.data.entity.Film

@Database(entities = [Film::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}