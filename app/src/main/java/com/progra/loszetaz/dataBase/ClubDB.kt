package com.progra.loszetaz.dataBase

import com.progra.loszetaz.dataClases.Club

class ClubDB {

    companion object{

        val clubs: MutableList<Club> = mutableListOf(
            Club(
                id = 1,
                logo = "logo_vanity.jpg",
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
                tags = mutableListOf("Área de fumadores", "Reggaeton", "DJ"),
                likes = 10,
                zone = "Irpavi"
            ),
            Club(
                id = 2,
                logo = "logo_garden.png",
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
                tags = mutableListOf("Cocteles", "Seguridad", "DJ"),
                likes = 20,
                zone = "Calacoto"
            ),
            Club(
                id = 3,
                logo = "logo_gold.jpg",
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
                tags = mutableListOf("Enganchados", "Clasicos" ),
                likes = 15,
                zone = "San Pedro"
            ),
            Club(
                id = 4,
                logo = "logo_malegria.jpg",
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
                tags = mutableListOf("Musica en vivo", "Extranjeros"),
                likes = 30,
                zone = "Cota Cota"
            ),
            Club(
                id = 5,
                logo = "logo_pacha.jpeg",
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
                tags = mutableListOf("Aire Libre", "Mesas", "DJ", "Seguridad"),
                likes = 50,
                zone = "Cota Cota"
            ),
            Club(
                id = 6,
                logo = "logo_taboo.jpeg",
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
                tags = mutableListOf("Aire Libre", "DJ", "Seguridad"),
                likes = 35,
                zone = "Cota Cota"
            ),
            Club(
                id = 7,
                logo = "logo_fabula.jpg",
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
                tags = mutableListOf("Aire Libre", "Musica en vivo", "Mesas"),
                likes = 25,
                zone = "Cota Cota"
            ),
            Club(
                id = 9,
                logo = "logo_black_monkey.jpg",
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
                tags = mutableListOf("Musica en vivo", "Mesas","After office"),
                likes = 15,
                zone = "Calacoto"
            ),
            Club(
                id = 10,
                logo = "logo_forum.jpg",
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
                tags = mutableListOf("Clasicos"),
                likes = 10,
                zone = "Sopocachi"
            ),
            Club(
                id = 11,
                logo = "logo_zouk.jpg",
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
                tags = mutableListOf("DJ"),
                likes = 26,
                zone = "Calacoto"
            ),
            Club(
                id = 12,
                logo = "logo_wave.png",
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
                tags = mutableListOf("DJ", "Promociones", "No cover"),
                likes = 26,
                zone = "Calacoto"
            ),
            Club(
                id = 13,
                logo = "logo_london.jpg",
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
                tags = mutableListOf("DJ", "Musica en vivo", "Área de fumadores"),
                likes = 26,
                zone = "Irpavi"
            ),
            Club(
                id = 14,
                logo = "logo_zelta.png",
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
                tags = mutableListOf("DJ", "Musica en vivo"),
                likes = 26,
                zone = "Centro"
            ),
            Club(
                id = 15,
                logo = "logo_plan_b.jpg",
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
                tags = mutableListOf("DJ"),
                likes = 29,
                zone = "Centro"
            ),
            Club(
                id = 16,
                logo = "logo_level.jpg",
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
                tags = mutableListOf("DJ", "Musica en vivo", "Cumbia"),
                likes = 9,
                zone = "Miraflores"
            ),
            Club(
                id = 17,
                logo = "logo_guru.png",
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
                tags = mutableListOf("DJ", "Musica en vivo", "Cumbia"),
                likes = 9,
                zone = "San Pedro"
            ),
            Club(
                id = 18,
                logo = "logo_open_mind.jpg",
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
                tags = mutableListOf("DJ", "No cover", "Cumbia"),
                likes = 8,
                zone = "Centro"
            ),
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
                if(club.zone == zone){
                    result.add(club)
                }
            }
            return result
        }
    }

}