package ru.coolhabit.remote_module.entity

import com.google.gson.annotations.SerializedName

private const val ID = "id"
private const val LOGO_PATH = "logo_path"
private const val NAME = "name"
private const val ORIG_COUNTRY = "origin_country"

data class ProductionCompany(
    @SerializedName(ID)
    val id: Int,
    @SerializedName(LOGO_PATH)
    val logoPath: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(ORIG_COUNTRY)
    val originCountry: String
)