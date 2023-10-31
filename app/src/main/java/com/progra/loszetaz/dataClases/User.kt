package com.progra.loszetaz.dataClases

import android.graphics.Bitmap

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val cellphone: Int,
    val birthday: String,
    val ci: Int,
    val likedIdClubs: List<Int>,
//    val profilePicture: Int,
    val profilePicture: Bitmap
)
