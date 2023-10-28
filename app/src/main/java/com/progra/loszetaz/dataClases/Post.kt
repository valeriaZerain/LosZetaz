package com.progra.loszetaz.dataClases

data class Post(
    val title: String,
    val date: String,
    val description: String,
    val images: List<Int>,
    val clubId: Int
){
    fun getMiniDescription(): String{
        return "${description.take(40)}..."
    }

}
