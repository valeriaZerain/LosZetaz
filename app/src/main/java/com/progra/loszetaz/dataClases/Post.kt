package com.progra.loszetaz.dataClases

import android.graphics.Bitmap

data class Post(
    val title: String,
    val date: String,
    val description: String,
//    val images: List<Int>,
    val clubId: Int,
    val image: Bitmap

){
    fun getMiniDescription(): String{
        return "${description.take(40)}..."
    }

}
