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
                ownerName = "Jhons Vanity",
                name = "Vanity",
                license = "90800124A-B24235510",
                ownerNumber = 7186811,
                description = "El club más exclusivo en La Paz, Bolivia.",
                location = "Avenida Rafael Pabón Zona Irpavi (Zona Sur) , La Paz, Bolivia",
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
                ownerName = "Cristian Garden",
                name = "Garden",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Garden es un club sofisticado con todas las comodidades, el mejor sonido e iluminación de La Paz.",
                location = "Av Ballivian, entre calles 16 y 17, La Paz, Bolivia",
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
                ownerName = "Gold Benson",
                name = "Gold",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Ven a revivir tus mejores años de tu vida!",
                location = "Calle Almirante Grau entre G. Gonzales y la Cañada Strongest",
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
                ownerName = "Justin Malegria",
                name = "Malegria",
                license = "90800124A-B24235510",
                ownerNumber = 946876542,
                description = "Bienvenido al bar con la mejor onda tradicional de la ciudad. Un bar de amigos porque el que viene por primera vez vuelve todas las semanas. Un lugar para reunirse como una danza al fuego y baile a la alegría, apaga la sed y despierta los espíritus de la tradicional noche paceña. Todos los jueves Saya Afroboliviana en vivo, un imperdible del male y de tu visita en la ciudad.",
                location = "Av Muñoz Reyes entre 26 y 27 de Cota Cota",
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
                ownerName = "Rodrigo Pacha",
                name = "Pacha",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "El Pub tradicional paceño por excelencia. Perfecto para disfrutar con amigos",
                location = "Calle 28 de Cota Cota",
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
                ownerName = "Taboo Johnson",
                name = "Taboo",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Vive la experiencia Taboo!",
                location = "Av Muñoz Reyes entre 26 y 27 de Cota Cota",
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
                ownerName = "Kevin Fabula",
                name = "Fabula",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "¡Únete a la fábula en Fábula y que la noche te cuente historias inolvidables!",
                location = "Av. Costanera y Calle 33 de Cota Cota, La Paz, Bolivia",
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
                ownerName = "Black Monkey",
                name = "Black Monkey Bar",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Cada noche es una aventura distinta, el ritmo y la diversión se fusionan en una experiencia única",
                location = "Av. Inofuentes entre 16 y 17 de Calacoto, La Paz, Bolivia",
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
                ownerName = "Marco Forum",
                name = "Forum",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Más que una discoteca, FORUM es el lugar, donde tú y tus amigos podrán pasar noches inolvidables!",
                location = "Calle Victor Sanjinez Nro. 2908 Z. Sopocachi, La Paz, Bolivia",
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
                ownerName = "Hans Zoruk",
                name = "Zoruk Boulevard",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Zouk Boulevard, un concepto de club nocturno en la ciudad, ubicado en San Miguel, pensado en ti.",
                location = "San Miguel, Calle 21",
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
                ownerName = "WIlson Wave",
                name = "Wave Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Ven a pasar un momento lleno de diversión en Wave Club. Vive una nueva noche.",
                location = "Calle Ignacio Cordero, La Paz",
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
                ownerName = "James London",
                name = "London Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "¡Únete a la elegancia en London y que la noche te trate como la realeza!",
                location = "Megacenter, La Paz, Bolivia",
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
                ownerName = "Suvadra Zelta",
                name = "Zelta",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "ZELTA el centro de diversión nocturna más céntrico y novedoso de la ciudad de La Paz.",
                location = "Plaza del estudiante # 1920, La Paz, Bolivia",
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
                ownerName = "Chencho y Maldy",
                name = "Club Plan B",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Un club/discoteca donde podrás vivir nuevas sensaciones y experiencias.",
                location = "J.J.Perez, La Paz, Bolivia",
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
                ownerName = "Loki",
                name = "Level Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "MUY PRONTO LAS NOCHES SUBIRÁN DE NIVEL",
                location = "Av Saavedra #1666, Ciudad La Paz, Bolivia",
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
                ownerName = "Gabo Guru",
                name = "Gurú",
                license = "90800124A-B24235510",
                ownerNumber = 68128432,
                description = "No te quedes en casa como un monje en su retiro, ¡únete a la experiencia en Guru y que la noche te guíe hacia la verdadera elevación espiritual!",
                location = "Av. Mariscal Sta. Cruz, La Paz, Bolivia",
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
                ownerName = "Oliver Mind",
                name = "Open Mind",
                license = "90800124A-B24235510",
                ownerNumber = 68128432,
                description = "UN LUGAR PARA OLVIDARSE DE TODO Y PASAR BUENOS MOMENTOS CON TUS AMIGOS DISFRUTAR DE LA BUENA MUSICA",
                location = "Calle Cochabamba #100 entre Av. 16 de Julio y Calle Murillo, subsuelo Chifa Jacky Chan, La Paz, Bolivia, La Paz, Bolivia",
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

        fun getClubById(id: Int): Club? {
            return clubs.find { club -> club.id == id }
        }
    }

    fun addClub(
        name: String,
        ownerEmail: String,
        license: String,
        ownerNumber: Int,
        description: String,
        cover: Int,
        schedule: String,
        recommendations: String,
        contactNumber: Int,
        tags: MutableList<Boolean>,
        zone: String
    ) {
        id++
        var newClub: Club = Club(
            id = id,
            logo = 10,
            name = name,
            ownerName = ownerEmail,
            license = license,
            ownerNumber = ownerNumber,
            description = description,
            location = "falta estoo",
            cover = cover,
            schedule = schedule,
            recommendations = recommendations,
            contactNumber = contactNumber,
            tags = tags,
            likes = 0,
            zone = zone
        )
        clubs.add(newClub)
    }
}