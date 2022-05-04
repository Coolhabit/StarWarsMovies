package ru.coolhabit.remote_module.cast_entity

import com.google.gson.annotations.SerializedName

private const val CAST = "cast"
private const val CREW = "crew"
private const val ID = "id"


data class TmdbCastResult(
    @SerializedName(ID)
    val id: Int,
    @SerializedName(CAST)
    val castList: List<TmdbCast>,
    @SerializedName(CREW)
    val crewList: List<TmdbCrew>,
)