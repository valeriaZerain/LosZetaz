package com.progra.loszetaz.dataClases

import java.io.Serializable


data class Club(
    val id: Int,
    var logo: Int,
    var name: String,
    var ownerEmail: String,
    var license: String,
    var ownerNumber: Int,
    var description: String,
    var latitude: Double,
    var longitude: Double,
    var cover: Int,
    var schedule: String,
    var recommendations: String,
    var contactNumber: Int,
    var tags: MutableList<Boolean>,
    var likes: Int,
    val zone: String?,
    val logoString: String?
) : Serializable
