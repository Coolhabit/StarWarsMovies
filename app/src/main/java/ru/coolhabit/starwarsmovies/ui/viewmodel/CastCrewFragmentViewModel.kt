package ru.coolhabit.starwarsmovies.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.coolhabit.starwarsmovies.App
import ru.coolhabit.starwarsmovies.data.entity.Cast
import ru.coolhabit.starwarsmovies.domain.Interactor
import javax.inject.Inject

class CastCrewFragmentViewModel: ViewModel() {
    @Inject
    lateinit var interactor: Interactor
    val castListData = MutableLiveData<List<Cast>>()

    init {
        App.instance.dagger.inject(this)
    }

    fun getCastCrew(id: Int) {
        interactor.getCastCrew(id)
            .subscribeBy(
                onError = {
                    it.printStackTrace()
                },
                onNext = {
                    castListData.postValue(it)
                }
            )
    }

}