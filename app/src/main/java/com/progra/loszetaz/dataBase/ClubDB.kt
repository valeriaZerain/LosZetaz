package com.progra.loszetaz.dataBase

import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.dataClases.Owner

class ClubDB {

    companion object{
        val clubs = listOf(
            Club(
                id = 1,
                logo = "club_logo.png",
                ownerName = "Alex Johnson",
                license = "ABC123",
                ownerNumber = 98765432,
                description = "A vibrant club with a unique atmosphere.",
                location = "123 Main Street, Cityville",
                cover = 20,
                schedule = "Friday and Saturday: 9:00 PM - 2:00 AM",
                recommendations = "Great music, friendly staff",
                contactNumber = 12345678,
                tags = mutableListOf("Dance", "Music", "Nightlife")
            )
        )
    }

}