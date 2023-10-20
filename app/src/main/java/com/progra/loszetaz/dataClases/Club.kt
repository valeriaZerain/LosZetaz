package com.progra.loszetaz.dataClases


data class Club(
    val id: Int,
    var logo: String,
    val owner: Owner,
//    var owner: String,
//    var license: String,
//    var ownerNumber: String,
    var description: String,
    var location: String,
    var cover: Int,
    var schedule: String,
    var recommendations: String,
    var contactNumber: String,
    val tags: MutableList<String>
)

data class Owner(
    val name: String,
    val number: String,
    val license: String
)