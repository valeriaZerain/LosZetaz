package com.progra.loszetaz.dataBase

import com.progra.loszetaz.R
import com.progra.loszetaz.dataClases.Club

class ClubDB {

    companion object {
        var id = 18
        val clubs: MutableList<Club> = mutableListOf(
            Club(
                id = 1,
                logo = R.drawable.logo_vanity,
                ownerEmail = "vanity@vanity.com",
                name = "Vanity",
                license = "90800124A-B24235510",
                ownerNumber = 7186811,
                description = "El club más exclusivo en La Paz, Bolivia.",
                location = "https://maps.app.goo.gl/QXfaUUM9JjydtUBcA",
                cover = 35,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Llevate dinero para el taxi",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, true, false, false),
                likes = 10,
                zone = "Irpavi"
            ),
            Club(
                id = 2,
                logo = R.drawable.logo_garden,
                ownerEmail = "garden@garden.com",
                name = "Garden",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Garden es un club sofisticado con todas las comodidades, el mejor sonido e iluminación de La Paz.",
                location = "https://maps.app.goo.gl/rLyVk5dQLfdqf8ah7",
                cover = 45,
                schedule = "Viernes y Sabados: 5:30 PM - 2:00 AM",
                recommendations = "Vente preparada que el ambiente está más caliente que una llajua con aji",
                contactNumber = 12345678,
                tags = mutableListOf(false, false, true, false, false),
                likes = 20,
                zone = "Calacoto"
            ),
            Club(
                id = 3,
                logo = R.drawable.logo_gold,
                ownerEmail = "gold@gold.com",
                name = "Gold",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Ven a revivir tus mejores años de tu vida!",
                location = "https://maps.app.goo.gl/sjTHL6y59QgFvPJZ9",
                cover = 20,
                schedule = "Viernes y Sabados: 9:00 PM - 2:00 AM",
                recommendations = "",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, false, false, true),
                likes = 15,
                zone = "San Pedro"
            ),
            Club(
                id = 4,
                logo = R.drawable.logo_malegria,
                ownerEmail = "malegria@malegria.com",
                name = "Malegria",
                license = "90800124A-B24235510",
                ownerNumber = 946876542,
                description = "Bienvenido al bar con la mejor onda tradicional de la ciudad. Un bar de amigos porque el que viene por primera vez vuelve todas las semanas. Un lugar para reunirse como una danza al fuego y baile a la alegría, apaga la sed y despierta los espíritus de la tradicional noche paceña. Todos los jueves Saya Afroboliviana en vivo, un imperdible del male y de tu visita en la ciudad.",
                location = "https://maps.app.goo.gl/akiKib3WdYuWUdgq5",
                cover = 30,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Ven temprano que se llena rapido",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, true, false, false),
                likes = 30,
                zone = "Sopocachi"
            ),
            Club(
                id = 5,
                logo = R.drawable.logo_pacha,
                ownerEmail = "pacha@pacha.com",
                name = "Pacha",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "El Pub tradicional paceño por excelencia. Perfecto para disfrutar con amigos",
                location = "https://maps.app.goo.gl/tupqkRfzFNpFn4d68",
                cover = 50,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Reserva tu mesa",
                contactNumber = 12345678,
                tags = mutableListOf(true, false, true, false, false),
                likes = 50,
                zone = "Cota Cota"
            ),
            Club(
                id = 6,
                logo = R.drawable.logo_taboo,
                ownerEmail = "taboo@taboo.com",
                name = "Taboo",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Vive la experiencia Taboo!",
                location = "https://maps.app.goo.gl/y41syALkbuECP6XTA",
                cover = 30,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Deja tu corazon en tu casa y ven a divertirte",
                contactNumber = 12345678,
                tags = mutableListOf(true, false, true, false, false),
                likes = 35,
                zone = "Cota Cota"
            ),
            Club(
                id = 7,
                logo = R.drawable.logo_fabula,
                ownerEmail = "fabula@fabula.com",
                name = "Fabula",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "¡Únete a la fábula en Fábula y que la noche te cuente historias inolvidables!",
                location = "https://maps.app.goo.gl/FJv6fkpkLEuHWFXk9",
                cover = 30,
                schedule = "Viernes y Sabados: 7:00 PM - 2:00 AM",
                recommendations = "Llevate abrigo",
                contactNumber = 12345678,
                tags = mutableListOf(true, true, true, false, false),
                likes = 25,
                zone = "Cota Cota"
            ),
            Club(
                id = 9,
                logo = R.drawable.logo_black_monkey,
                ownerEmail = "black@black.com",
                name = "Black Monkey Bar",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Cada noche es una aventura distinta, el ritmo y la diversión se fusionan en una experiencia única",
                location = "https://maps.app.goo.gl/E1RpvwCVqQaqo77a6",
                cover = 30,
                schedule = "Viernes y Sabados: 7:00 PM - 2:00 AM",
                recommendations = "",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, true, false, true),
                likes = 15,
                zone = "Calacoto"
            ),
            Club(
                id = 10,
                logo = R.drawable.logo_forum,
                ownerEmail = "forum@forum.com",
                name = "Forum",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Más que una discoteca, FORUM es el lugar, donde tú y tus amigos podrán pasar noches inolvidables!",
                location = "https://maps.app.goo.gl/PWgC9awyfmiPest87",
                cover = 25,
                schedule = "Viernes y Sabados: 9:00 PM - 2:00 AM",
                recommendations = "Mientras mas tarde mejor",
                contactNumber = 12345678,
                tags = mutableListOf(false, false, false, false, true),
                likes = 10,
                zone = "Sopocachi"
            ),
            Club(
                id = 11,
                logo = R.drawable.logo_zouk,
                ownerEmail = "zoruk@zoruk.com",
                name = "Zoruk Boulevard",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Zouk Boulevard, un concepto de club nocturno en la ciudad, ubicado en San Miguel, pensado en ti.",
                location = "https://maps.app.goo.gl/7UxCwcjaBA211NaG7",
                cover = 40,
                schedule = "Sabados: 9:00 PM - 2:00 AM",
                recommendations = "",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, false, false, false),
                likes = 26,
                zone = "Calacoto"
            ),
            Club(
                id = 12,
                logo = R.drawable.logo_wave,
                ownerEmail = "wave@wave.com",
                name = "Wave Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Ven a pasar un momento lleno de diversión en Wave Club. Vive una nueva noche.",
                location = "https://maps.app.goo.gl/v4XMyifpXz6GPrJi8z",
                cover = 0,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "Hipoteca la casa",
                contactNumber = 12345678,
                tags = mutableListOf(false, false, true, false, false),
                likes = 26,
                zone = "Calacoto"
            ),
            Club(
                id = 13,
                logo = R.drawable.logo_london,
                ownerEmail = "london@london.com",
                name = "London Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "¡Únete a la elegancia en London y que la noche te trate como la realeza!",
                location = "https://maps.app.goo.gl/eDoC5vEmpQZ6j9SD9",
                cover = 20,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, false),
                likes = 26,
                zone = "Irpavi"
            ),
            Club(
                id = 14,
                logo = R.drawable.logo_zelta,
                ownerEmail = "zelta@zelta.com",
                name = "Zelta",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "ZELTA el centro de diversión nocturna más céntrico y novedoso de la ciudad de La Paz.",
                location = "https://maps.app.goo.gl/ARZKegxVjzUudmry6",
                cover = 35,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, false),
                likes = 26,
                zone = "Centro"
            ),
            Club(
                id = 15,
                logo = R.drawable.logo_plan_b,
                ownerEmail = "planb@planb.com",
                name = "Club Plan B",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Un club/discoteca donde podrás vivir nuevas sensaciones y experiencias.",
                location = "https://maps.app.goo.gl/RihQkCbMydtAbCN68",
                cover = 25,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "No lleves auto",
                contactNumber = 63076222,
                tags = mutableListOf(false, false, false, false, false),
                likes = 29,
                zone = "Centro"
            ),
            Club(
                id = 16,
                logo = R.drawable.logo_level,
                ownerEmail = "level@level.com",
                name = "Level Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "MUY PRONTO LAS NOCHES SUBIRÁN DE NIVEL",
                location = "https://maps.app.goo.gl/CSUn6uvqkAJMkrJq9",
                cover = 20,
                schedule = "Viernes y Sabados: 7:00 PM - 02:00 AM",
                recommendations = "Cuidado te asalten",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, true),
                likes = 9,
                zone = "Miraflores"
            ),
            Club(
                id = 17,
                logo = R.drawable.logo_guru,
                ownerEmail = "guru@guru.com",
                name = "Gurú",
                license = "90800124A-B24235510",
                ownerNumber = 68128432,
                description = "No te quedes en casa como un monje en su retiro, ¡únete a la experiencia en Guru y que la noche te guíe hacia la verdadera elevación espiritual!",
                location = "https://maps.app.goo.gl/W1iWwgVZoovVFGXy7",
                cover = 20,
                schedule = "Jueves, Viernes, Sabados y Domingos: 8:00 PM - 3:00 AM",
                recommendations = "Cuidado te asalten",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, true),
                likes = 9,
                zone = "San Pedro"
            ),
            Club(
                id = 18,
                logo = R.drawable.logo_open_mind,
                ownerEmail = "Oliver Mind",
                name = "open@open.com",
                license = "90800124A-B24235510",
                ownerNumber = 68128432,
                description = "UN LUGAR PARA OLVIDARSE DE TODO Y PASAR BUENOS MOMENTOS CON TUS AMIGOS DISFRUTAR DE LA BUENA MUSICA",
                location = "https://maps.app.goo.gl/Afc5dKcJEfH7tBkPA",
                cover = 25,
                schedule = "Jueves, Viernes, Sabados y Domingos: 8:00 PM - 3:00 AM",
                recommendations = "Cuidado te asalten",
                contactNumber = 63076222,
                tags = mutableListOf(false, false, false, true, true),
                likes = 8,
                zone = "Centro"
            ),
        )

        fun getAllClubs(): List<Club> {
            return clubs
        }

        fun mostLikedClubs(): List<Club> {
            return clubs.sortedWith(compareByDescending { it.likes })
        }

        fun editDistance(text: String, objective: String): Int {
            val dp = Array(text.length + 1) { IntArray(objective.length + 1) }
            text.lowercase()
            objective.lowercase()
            for (i in 0..text.length)
                dp[i][0] = i
            for (i in 0..objective.length)
                dp[0][i] = i
            for (i in 1..text.length) {
                for (j in 1..objective.length) {
                    val isDifferent = (text[i - 1] != objective[j - 1])
                    dp[i][j] = minOf(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1,
                        dp[i - 1][j - 1] + (if (isDifferent) 1 else 0)
                    )
                }
            }
            println("$text -> $objective : ${dp[text.length][objective.length]}")
            println(dp)
            return dp[text.length][objective.length]
        }

        fun searchByName(name: String, clubsFiltered: List<Club>): List<Club> {

            val result = mutableListOf<Club>()
            clubsFiltered.forEach { club: Club ->
                if (club.name.lowercase().contains(name.lowercase()))
                    result.add(club)
            }
            return result
            //return clubsFiltered.sortedWith( compareByDescending { -editDistance(it.name, name) })
        }

        fun searchByTags(tags: List<Boolean>, clubsFiltered: List<Club>): List<Club> {
            val result = mutableListOf<Club>()
            clubsFiltered.forEach { club ->
                var containsTags = true
//                tags.forEach { tag ->
//                    containsTags = containsTags && club.tags.contains(tag)
//                }
                for (i in 0..4) {
                    containsTags = containsTags && ((tags[i] && club.tags[i]) || !tags[i])
                }
                if (containsTags)
                    result.add(club)
            }
            return result
        }

        fun searchByZones(zone: String, clubsFiltered: List<Club>): List<Club> {
            val result = mutableListOf<Club>()
            clubsFiltered.forEach { club ->
                if (club.zone == zone) {
                    result.add(club)
                }
            }
            return result
        }

        fun getClubByEmail(email: String): Club {
            var result: Club? = null
            clubs.forEach{ club ->
                if(club.ownerEmail == email){
                    result = club
                }
            }
            return result!!
        }
        fun getClubById(id: Int): Club? {
            return clubs.find { club -> club.id == id }
        }

        fun addClub(
            name: String,
            ownerEmail: String,
            license: String,
            ownerNumber: Int,
            description: String,
            cover: Int,
            location:String,
            schedule: String,
            recommendations: String,
            contactNumber: Int,
            tags: MutableList<Boolean>
            //zone: String
        ) {
            id++
            var newClub: Club = Club(
                id = id,
                logo = 10,
                name = name,
                ownerEmail = ownerEmail,
                license = license,
                ownerNumber = ownerNumber,
                description = description,
                location = location,
                cover = cover,
                schedule = schedule,
                recommendations = recommendations,
                contactNumber = contactNumber,
                tags = tags,
                likes = 0,
                zone = "también falta estoo"
            )
            clubs.add(newClub)
        }
    }
}