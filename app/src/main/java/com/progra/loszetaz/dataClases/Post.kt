package com.progra.loszetaz.dataClases

import java.util.Date

data class Post(
    val title: String,
    val date: Date,
    val description: String,
    val images: List<Int>,
    val clubId: Int
){
    fun getMiniDescription(): String{
        return "${description.take(40)}..."
    }
}
