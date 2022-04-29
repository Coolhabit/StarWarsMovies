package ru.coolhabit.starwarsmovies.data

import io.reactivex.rxjava3.core.Observable
import ru.coolhabit.starwarsmovies.data.dao.FilmDao
import ru.coolhabit.starwarsmovies.data.entity.Film

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

    fun clearDb() {
        filmDao.clearFilms()
    }
}