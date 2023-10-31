package com.progra.loszetaz.dataClases

import java.io.Serializable


data class Club(
    val id: Int,
    var logo: Int,
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
    var tags: MutableList<Boolean>,
    var likes: Int,
    val zone: String
): Serializable
