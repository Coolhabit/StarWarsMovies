package ru.coolhabit.starwarsmovies.utils

import ru.coolhabit.remote_module.cast_entity.TmdbCast
import ru.coolhabit.remote_module.entity.TmdbFilm
import ru.coolhabit.remote_module.entity.TmdbMovie
import ru.coolhabit.starwarsmovies.data.entity.Cast
import ru.coolhabit.starwarsmovies.data.entity.Film
import ru.coolhabit.starwarsmovies.data.entity.Movie

object Converter {
    fun convertApiListToDtoList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(
                Film(
                    id = it.id,
                    title = it.title,
                    poster = it.posterPath,
                    description = it.overview,
                    rating = it.voteAverage,
                    isInFavorites = false
                )
            )
        }
        return result
    }

    fun convertMovie(movie: TmdbMovie): Movie {
        return Movie(
             id = movie.id,
             title = movie.title,
             poster = movie.posterPath.toString(),
             description = movie.overview,
             runtime = movie.runtime
         )
    }

    fun convertCast(list: List<TmdbCast>?): List<Cast> {
        val resultCast = mutableListOf<Cast>()
        list?.forEach {
            resultCast.add(
                Cast(
                    id = it.id,
                    name = it.name,
                    portrait = it.profilePath,
                    character = it.character
                )
            )
        }
        return resultCast
    }
}