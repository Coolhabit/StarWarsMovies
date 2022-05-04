package ru.coolhabit.starwarsmovies.data.entity

data class Movie(
    val id: Int,
    val title: String,
    val poster: String,
    val description: String,
    val runtime: Int
)