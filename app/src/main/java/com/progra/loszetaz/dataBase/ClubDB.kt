package com.progra.loszetaz.dataBase

import com.progra.loszetaz.dataClases.Club

class ClubDB {

    companion object{
        val clubs: MutableList<Club> = mutableListOf(
            Club(
                id = 1,
                logo = "Taboo.png",
                ownerName = "Taboo Johnson",
                name = "Taboo",
                license = "ABC123",
                ownerNumber = 98765432,
                description = "A vibrant club with a unique atmosphere.",
                location = "123 Main Street, Cityville",
                cover = 20,
                schedule = "Friday and Saturday: 9:00 PM - 2:00 AM",
                recommendations = "Great music, friendly staff",
                contactNumber = 12345678,
                tags = mutableListOf("Dance", "Music", "Nightlife"),
                likes = 0
            )
        )

        fun mostLikedClubs(): List<Club>{
            return clubs.sortedWith(compareByDescending { it.likes })
        }

        fun editDistance(text: String, objective: String): Int{
            val dp = Array(text.length+1) { IntArray(objective.length+1) }
            for(i in 0..text.length)
                dp[i][0]=0
            for(i in 0..objective.length)
                dp[0][i]=0
            for(i in 1..text.length){
                for(j in 1..objective.length){
                    val isDifferent = (text[i-1]==objective[j-1])
                    dp[i][j] = minOf(
                        dp[i-1][j]+1,
                        dp[i][j-1]+1,
                        dp[i-1][j-1] + ( if(isDifferent) 1 else 0 )
                    )
                }
            }
            return dp[text.length][objective.length]
        }
        fun searchByName(name: String): List<Club>{
            return clubs.sortedWith( compareByDescending { editDistance(it.name, name) })
//            clubs.forEach{ club ->
//                val dif = editDistance(club.name,name)
//
//            }
        }

        fun searchByTags(tags: List<String>): List<Club>{
            val result = mutableListOf<Club>()
            clubs.forEach{ club ->
                var containsTags = true
                tags.forEach { tag ->
                    containsTags = containsTags && club.tags.contains(tag)
                }
                if(containsTags)
                    result.add(club)
            }
            return result
        }

        fun searchByZones(zone: String): List<Club>{
            val result = mutableListOf<Club>()
            clubs.forEach{ club ->
                if(club.location == zone){
                    result.add(club)
                }
            }
            return result
        }
    }

}