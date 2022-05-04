package ru.coolhabit.remote_module

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.coolhabit.remote_module.cast_entity.TmdbCast
import ru.coolhabit.remote_module.cast_entity.TmdbCastResult
import ru.coolhabit.remote_module.entity.TmdbMovie
import ru.coolhabit.remote_module.entity.TmdbResults

private const val CATEGORY = "category"
private const val API_KEY = "api_key"
private const val LANGUAGE = "language"
private const val PAGE = "page"
private const val QUERY = "query"
private const val APPEND = "append_to_response"
private const val MOVIE_ID = "movie_id"



interface TmdbApi {
    @GET("3/movie/{category}")
    fun getFilms(
        @Path(CATEGORY) category: String,
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(PAGE) page: Int
    ): Observable<TmdbResults>

    @GET("3/search/movie")
    fun getFilmFromSearch(
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(QUERY) query: String,
        @Query(PAGE) page: Int
    ): Observable<TmdbResults>

    @GET("3/movie/{movie_id}")
    fun getMovie(
        @Path(MOVIE_ID) movieId: Int,
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String,
        @Query(APPEND) appendToResponse: String
    ): Observable<TmdbMovie>

    @GET("3/movie/{movie_id}/credits")
    fun getCredits(
        @Path(MOVIE_ID) movieId: Int,
        @Query(API_KEY) apiKey: String,
        @Query(LANGUAGE) language: String
    ): Observable<TmdbCastResult>
}