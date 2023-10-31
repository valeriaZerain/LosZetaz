package com.progra.loszetaz.dataClases

import java.time.format.DateTimeFormatter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toJavaLocalDate
import java.util.Locale

data class Post(
    val id: Int,
    val title: String,
    val date: LocalDate,
    val description: String,
    val image: Int,
    val clubId: Int,
    val imageString: String?

){
    fun getMiniDescription(): String{
        return "${description.take(40)}..."
    }

    fun getDate(): String {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("es","ES"))
        val current = date.toJavaLocalDate().format(formatter)
        return current
    }
}
