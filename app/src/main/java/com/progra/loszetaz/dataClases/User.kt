package com.progra.loszetaz.dataClases

import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val cellphone: Int,
    val birthday: String,
    val ci: Int,
    val likedIdClubs: MutableList<Int>,
    val profilePictureString: String
) : Serializable
