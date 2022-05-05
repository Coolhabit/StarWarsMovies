package ru.coolhabit.starwarsmovies.data.entity

data class Genre(
    val name: String
) {
    override fun toString(): String = "$name"
}
