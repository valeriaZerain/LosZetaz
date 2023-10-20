package com.progra.loszetaz.dataClases

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val cellphone: Int,
    val birthday: String,
    val ci: Int,
    val password: String,
    val likedIdClubs: MutableList<Int>
)
