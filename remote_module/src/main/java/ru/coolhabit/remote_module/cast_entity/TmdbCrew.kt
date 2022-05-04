package ru.coolhabit.remote_module.cast_entity

import com.google.gson.annotations.SerializedName

private const val ADULT = "adult"
private const val CREDIT_ID = "credit_id"
private const val DEPARTMENT = "department"
private const val GENDER = "gender"
private const val ID = "id"
private const val JOB = "job"
private const val KNOWN_FOR_DEP = "known_for_department"
private const val NAME = "name"
private const val ORIGINAL_NAME = "original_name"
private const val POPULARITY = "popularity"
private const val PROFILE_PATH = "profile_path"

data class TmdbCrew(
    @SerializedName(ADULT)
    val adult: Boolean,
    @SerializedName(GENDER)
    val gender: Int,
    @SerializedName(ID)
    val id: Int,
    @SerializedName(KNOWN_FOR_DEP)
    val knownForDepartment: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(ORIGINAL_NAME)
    val originalName: String,
    @SerializedName(POPULARITY)
    val popularity: Double,
    @SerializedName(PROFILE_PATH)
    val profilePath: String,
    @SerializedName(CREDIT_ID)
    val creditId: String,
    @SerializedName(DEPARTMENT)
    val department: String,
    @SerializedName(JOB)
    val job: String
)