package ru.coolhabit.starwarsmovies.domain

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.coolhabit.remote_module.TmdbApi
import ru.coolhabit.starwarsmovies.data.API
import ru.coolhabit.starwarsmovies.data.MainRepository
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.data.shared.PreferenceProvider
import ru.coolhabit.starwarsmovies.utils.Converter

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    var progressBarState: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun getFilmsFromApi(page: Int) {
        //Показываем ProgressBar
        progressBarState.onNext(true)
        //Метод getDefaultCategoryFromPreferences() будет получать при каждом запросе нужный нам список фильмов
        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page)
            .subscribeOn(Schedulers.io())
            .map {
                Converter.convertApiListToDtoList(it.tmdbFilms)
            }
            .subscribeBy(
                onError = {
                    progressBarState.onNext(false)
                },
                onNext = {
                    progressBarState.onNext(false)
                    repo.putToDb(it)
                }
            )
    }

    fun getMovie(id: Int) =
        retrofitService.getMovie(id, API.KEY, "ru-RU", "none")
            .subscribeOn(Schedulers.io())
            .map {
                Converter.convertMovie(it)
            }

    fun getMovieGenre(id: Int) =
        retrofitService.getMovie(id, API.KEY, "ru-RU", "none")
            .subscribeOn(Schedulers.io())
            .map {
                Converter.convertGenres(it.genresList)
            }



    fun getCastCrew(id: Int) = retrofitService.getCredits(id, API.KEY, "ru-RU")
            .subscribeOn(Schedulers.io())
            .map {
                Converter.convertCast(it.castList)
            }

    fun getSearchResultFromApi(search: String): Observable<List<Film>> = retrofitService.getFilmFromSearch(API.KEY, "ru-RU", search, 1)
        .map {
            Converter.convertApiListToDtoList(it.tmdbFilms)
        }

    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }
    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

    fun getFilmsFromDB(): Observable<List<Film>> = repo.getAllFromDB()
}