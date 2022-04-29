package ru.coolhabit.remote_module.entity

import com.google.gson.annotations.SerializedName

private const val ISO = "iso_3166_1"
private const val NAME = "name"

data class ProductionCountry(
    @SerializedName(ISO)
    val iso3166: String,
    @SerializedName(NAME)
    val name: String
)