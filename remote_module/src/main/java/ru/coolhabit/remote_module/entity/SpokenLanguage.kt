package ru.coolhabit.remote_module.entity

import com.google.gson.annotations.SerializedName

private const val ISO = "iso_639_1"
private const val NAME = "name"

data class SpokenLanguage(
    @SerializedName(ISO)
    val iso639: String,
    @SerializedName(NAME)
    val name: String
)