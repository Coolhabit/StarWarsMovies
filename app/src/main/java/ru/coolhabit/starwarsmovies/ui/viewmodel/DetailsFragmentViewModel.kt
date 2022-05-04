package ru.coolhabit.starwarsmovies.ui.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.coolhabit.remote_module.entity.TmdbMovie
import ru.coolhabit.starwarsmovies.App
import ru.coolhabit.starwarsmovies.data.entity.Cast
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.data.entity.Movie
import ru.coolhabit.starwarsmovies.domain.Interactor
import java.net.URL
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DetailsFragmentViewModel: ViewModel() {
    @Inject
    lateinit var interactor: Interactor
    val liveData = MutableLiveData<Movie>()
    val castListData = MutableLiveData<List<Cast>>()

    init {
        App.instance.dagger.inject(this)
    }

    fun getData(id: Int) {
        interactor.getMovie(id)
            .subscribe {
                liveData.postValue(it)
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