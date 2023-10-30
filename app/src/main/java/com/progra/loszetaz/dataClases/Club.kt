package com.progra.loszetaz.dataClases


data class Club(
    val id: Int,
    var logo: String,
    val name: String,
    var ownerName: String,
    var license: String,
    var ownerNumber: Int,
    var description: String,
    var location: String,
    var cover: Int,
    var schedule: String,
    var recommendations: String,
    var contactNumber: Int,
    val tags: MutableList<String>,
    var likes: Int,
    val zone: String
)