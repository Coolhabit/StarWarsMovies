package ru.coolhabit.starwarsmovies.di

import dagger.Component
import ru.coolhabit.remote_module.RemoteProvider
import ru.coolhabit.starwarsmovies.di.modules.DatabaseModule
import ru.coolhabit.starwarsmovies.di.modules.DomainModule
import ru.coolhabit.starwarsmovies.ui.viewmodel.CastCrewFragmentViewModel
import ru.coolhabit.starwarsmovies.ui.viewmodel.DetailsFragmentViewModel
import ru.coolhabit.starwarsmovies.ui.viewmodel.HomeFragmentViewModel
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)

    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(detailsFragmentViewModel: DetailsFragmentViewModel)

    //метод для того, чтобы появилась возможность внедрять зависимости в CastCrewFragmentViewModel
    fun inject(castCrewFragmentViewModel: CastCrewFragmentViewModel)
}