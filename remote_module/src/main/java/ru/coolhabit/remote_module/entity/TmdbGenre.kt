package ru.coolhabit.remote_module.entity

import com.google.gson.annotations.SerializedName

private const val ID = "id"
private const val NAME = "name"

data class TmdbGenre(
    @SerializedName(ID)
    val id: Int,
    @SerializedName(NAME)
    val name: String
)