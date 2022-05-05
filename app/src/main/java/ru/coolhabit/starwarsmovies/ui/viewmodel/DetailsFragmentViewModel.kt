package ru.coolhabit.starwarsmovies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.coolhabit.starwarsmovies.App
import ru.coolhabit.starwarsmovies.data.entity.Cast
import ru.coolhabit.starwarsmovies.data.entity.Genre
import ru.coolhabit.starwarsmovies.data.entity.Movie
import ru.coolhabit.starwarsmovies.domain.Interactor
import javax.inject.Inject

class DetailsFragmentViewModel: ViewModel() {
    @Inject
    lateinit var interactor: Interactor
    val liveData = MutableLiveData<Movie>()
    val genreLiveData = MutableLiveData<List<Genre>>()
    val castListData = MutableLiveData<List<Cast>>()

    init {
        App.instance.dagger.inject(this)
    }

    fun getData(id: Int) {
        interactor.getMovie(id)
            .subscribe {
                liveData.postValue(it)
            }
        interactor.getMovieGenre(id)
            .subscribe {
                genreLiveData.postValue(it)
            }

    }

    fun getCastCrew(id: Int) {
        interactor.getCastCrew(id)
            .subscribeBy(
                onError = {

                },
                onNext = {
                    castListData.postValue(it)
                }
            )
    }

}