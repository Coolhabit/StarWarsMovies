package ru.coolhabit.remote_module.entity

import com.google.gson.annotations.SerializedName

private const val ADULT = "adult"
private const val BACKDROP = "backdrop_path"
private const val BELONGS = "belongs_to_collection"
private const val BUDGET = "budget"
private const val GENRES = "genres"
private const val HOMEPAGE = "homepage"
private const val ID = "id"
private const val IMDB_ID = "imdb_id"
private const val ORIG_LANG = "original_language"
private const val ORIG_TITLE = "original_title"
private const val OVW = "overview"
private const val POP = "popularity"
private const val POST_PATH = "poster_path"
private const val PROD_COMP = "production_companies"
private const val PROD_COUNT = "production_countries"
private const val REL_DATE = "release_date"
private const val REV = "revenue"
private const val RUNT = "runtime"
private const val SPOKEN_LANG = "spoken_languages"
private const val STATUS = "status"
private const val TAGLINE = "tagline"
private const val TITLE = "title"
private const val VIDEO = "video"
private const val VOTE_AV ="vote_average"
private const val VOTE_C ="vote_count"

data class TmdbMovie(
    @SerializedName(ADULT)
    val adult: Boolean,
    @SerializedName(BACKDROP)
    val backdropPath: String,
    @SerializedName(BELONGS)
    val belongsToCollection: Any,
    @SerializedName(BUDGET)
    val budget: Int,
    @SerializedName(GENRES)
    val genres: List<Genre>,
    @SerializedName(HOMEPAGE)
    val homepage: String,
    @SerializedName(ID)
    val id: Int,
    @SerializedName(IMDB_ID)
    val imdbId: String,
    @SerializedName(ORIG_LANG)
    val originalLanguage: String,
    @SerializedName(ORIG_TITLE)
    val originalTitle: String,
    @SerializedName(OVW)
    val overview: String,
    @SerializedName(POP)
    val popularity: Double,
    @SerializedName(POST_PATH)
    val posterPath: Any,
    @SerializedName(PROD_COMP)
    val productionCompanies: List<ProductionCompany>,
    @SerializedName(PROD_COUNT)
    val productionCountries: List<ProductionCountry>,
    @SerializedName(REL_DATE)
    val releaseDate: String,
    @SerializedName(REV)
    val revenue: Int,
    @SerializedName(RUNT)
    val runtime: Int,
    @SerializedName(SPOKEN_LANG)
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName(STATUS)
    val status: String,
    @SerializedName(TAGLINE)
    val tagline: String,
    @SerializedName(TITLE)
    val title: String,
    @SerializedName(VIDEO)
    val video: Boolean,
    @SerializedName(VOTE_AV)
    val vote_average: Double,
    @SerializedName(VOTE_C)
    val vote_count: Int
)