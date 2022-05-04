package ru.coolhabit.starwarsmovies.data.entity

data class Cast(
    val id: Int,
    val name: String,
    val portrait: String?,
    val character: String,
)