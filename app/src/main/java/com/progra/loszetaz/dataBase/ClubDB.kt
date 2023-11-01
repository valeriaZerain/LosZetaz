package com.progra.loszetaz.dataBase

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.progra.loszetaz.GlobalConfig
import com.progra.loszetaz.GlobalConfig.Companion.preference
import com.progra.loszetaz.R
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.dataClases.User

class ClubDB {

    companion object {

        val CLUBDB_KEY = "CLUDB_KEY"
        private val gson = Gson()

        var clubs: MutableList<Club> = mutableListOf(
            Club(
                id = 1,
                logo = R.drawable.logo_vanity,
                ownerEmail = "vanity@vanity.com",
                name = "Vanity",
                license = "90800124A-B24235510",
                ownerNumber = 7186811,
                description = "El club más exclusivo en La Paz, Bolivia.",
                latitude = -16.5329912,
                longitude = -68.0869359,
                cover = 35,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Llevate dinero para el taxi",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, true, false, false),
                likes = 10,
                zone = "Irpavi",
                logoString = null
            ),
            Club(
                id = 2,
                logo = R.drawable.logo_garden,
                ownerEmail = "garden@garden.com",
                name = "Garden",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Garden es un club sofisticado con todas las comodidades, el mejor sonido e iluminación de La Paz.",
                latitude = -16.5386299,
                longitude = -68.0855887,
                cover = 45,
                schedule = "Viernes y Sabados: 5:30 PM - 2:00 AM",
                recommendations = "Vente preparada que el ambiente está más caliente que una llajua con aji",
                contactNumber = 12345678,
                tags = mutableListOf(false, false, true, false, false),
                likes = 20,
                zone = "Calacoto",
                logoString = null
            ),
            Club(
                id = 3,
                logo = R.drawable.logo_gold,
                ownerEmail = "gold@gold.com",
                name = "Gold",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Ven a revivir tus mejores años de tu vida!",
                latitude = -16.5034961,
                longitude = -68.1407517,
                cover = 20,
                schedule = "Viernes y Sabados: 9:00 PM - 2:00 AM",
                recommendations = "",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, false, false, true),
                likes = 15,
                zone = "San Pedro",
                logoString = null
            ),
            Club(
                id = 4,
                logo = R.drawable.logo_malegria,
                ownerEmail = "malegria@malegria.com",
                name = "Malegria",
                license = "90800124A-B24235510",
                ownerNumber = 946876542,
                description = "Bienvenido al bar con la mejor onda tradicional de la ciudad. Un bar de amigos porque el que viene por primera vez vuelve todas las semanas. Un lugar para reunirse como una danza al fuego y baile a la alegría, apaga la sed y despierta los espíritus de la tradicional noche paceña. Todos los jueves Saya Afroboliviana en vivo, un imperdible del male y de tu visita en la ciudad.",
                latitude = -16.5091348,
                longitude = -68.1307563,
                cover = 30,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Ven temprano que se llena rapido",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, true, false, false),
                likes = 30,
                zone = "Sopocachi",
                logoString = null
            ),
            Club(
                id = 5,
                logo = R.drawable.logo_pacha,
                ownerEmail = "pacha@pacha.com",
                name = "Pacha",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "El Pub tradicional paceño por excelencia. Perfecto para disfrutar con amigos",
                latitude = -16.5423575,
                longitude = -68.0682857,
                cover = 50,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Reserva tu mesa",
                contactNumber = 12345678,
                tags = mutableListOf(true, false, true, false, false),
                likes = 50,
                zone = "Cota Cota",
                logoString = null
            ),
            Club(
                id = 6,
                logo = R.drawable.logo_taboo,
                ownerEmail = "taboo@taboo.com",
                name = "Taboo",
                license = "90800124A-B24235510",
                ownerNumber = 68765432,
                description = "Vive la experiencia Taboo!",
                latitude = -16.540276,
                longitude = -68.070082,
                cover = 30,
                schedule = "Viernes y Sabados: 5:00 PM - 2:00 AM",
                recommendations = "Deja tu corazon en tu casa y ven a divertirte",
                contactNumber = 12345678,
                tags = mutableListOf(true, false, true, false, false),
                likes = 35,
                zone = "Cota Cota",
                logoString = null
            ),
            Club(
                id = 7,
                logo = R.drawable.logo_fabula,
                ownerEmail = "fabula@fabula.com",
                name = "Fabula",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "¡Únete a la fábula en Fábula y que la noche te cuente historias inolvidables!",
                latitude = -16.5453672,
                longitude = -68.0615611,
                cover = 30,
                schedule = "Viernes y Sabados: 7:00 PM - 2:00 AM",
                recommendations = "Llevate abrigo",
                contactNumber = 12345678,
                tags = mutableListOf(true, true, true, false, false),
                likes = 25,
                zone = "Cota Cota",
                logoString = null
            ),
            Club(
                id = 9,
                logo = R.drawable.logo_black_monkey,
                ownerEmail = "black@black.com",
                name = "Black Monkey Bar",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Cada noche es una aventura distinta, el ritmo y la diversión se fusionan en una experiencia única",
                latitude = -16.5384633,
                longitude = -68.0856271,
                cover = 30,
                schedule = "Viernes y Sabados: 7:00 PM - 2:00 AM",
                recommendations = "",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, true, false, true),
                likes = 15,
                zone = "Calacoto",
                logoString = null
            ),
            Club(
                id = 10,
                logo = R.drawable.logo_forum,
                ownerEmail = "forum@forum.com",
                name = "Forum",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Más que una discoteca, FORUM es el lugar, donde tú y tus amigos podrán pasar noches inolvidables!",
                latitude = -16.5161706,
                longitude = -68.1313766,
                cover = 25,
                schedule = "Viernes y Sabados: 9:00 PM - 2:00 AM",
                recommendations = "Mientras mas tarde mejor",
                contactNumber = 12345678,
                tags = mutableListOf(false, false, false, false, true),
                likes = 10,
                zone = "Sopocachi",
                logoString = null
            ),
            Club(
                id = 11,
                logo = R.drawable.logo_zouk,
                ownerEmail = "zoruk@zoruk.com",
                name = "Zoruk Boulevard",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Zouk Boulevard, un concepto de club nocturno en la ciudad, ubicado en San Miguel, pensado en ti.",
                latitude = -16.5426472,
                longitude = -68.0797515,
                cover = 40,
                schedule = "Sabados: 9:00 PM - 2:00 AM",
                recommendations = "",
                contactNumber = 12345678,
                tags = mutableListOf(false, true, false, false, false),
                likes = 26,
                zone = "Calacoto",
                logoString = null
            ),
            Club(
                id = 12,
                logo = R.drawable.logo_wave,
                ownerEmail = "wave@wave.com",
                name = "Wave Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Ven a pasar un momento lleno de diversión en Wave Club. Vive una nueva noche.",
                latitude = -16.5438751,
                longitude = -68.08003,
                cover = 0,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "Hipoteca la casa",
                contactNumber = 12345678,
                tags = mutableListOf(false, false, true, false, false),
                likes = 26,
                zone = "Calacoto",
                logoString = null
            ),
            Club(
                id = 13,
                logo = R.drawable.logo_london,
                ownerEmail = "london@london.com",
                name = "London Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "¡Únete a la elegancia en London y que la noche te trate como la realeza!",
                latitude = -16.532989,
                longitude = -68.0895306,
                cover = 20,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, false),
                likes = 26,
                zone = "Irpavi",
                logoString = null
            ),
            Club(
                id = 14,
                logo = R.drawable.logo_zelta,
                ownerEmail = "zelta@zelta.com",
                name = "Zelta",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "ZELTA el centro de diversión nocturna más céntrico y novedoso de la ciudad de La Paz.",
                latitude = -16.5044783,
                longitude = -68.1338071,
                cover = 35,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, false),
                likes = 26,
                zone = "Centro",
                logoString = null
            ),
            Club(
                id = 15,
                logo = R.drawable.logo_plan_b,
                ownerEmail = "planb@planb.com",
                name = "Club Plan B",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "Un club/discoteca donde podrás vivir nuevas sensaciones y experiencias.",
                latitude = -16.5058609,
                longitude = -68.1330777,
                cover = 25,
                schedule = "Viernes y Sabados: 6:00 PM - 23:59 PM",
                recommendations = "No lleves auto",
                contactNumber = 63076222,
                tags = mutableListOf(false, false, false, false, false),
                likes = 29,
                zone = "Centro",
                logoString = null
            ),
            Club(
                id = 16,
                logo = R.drawable.logo_level,
                ownerEmail = "level@level.com",
                name = "Level Club",
                license = "90800124A-B24235510",
                ownerNumber = 68768432,
                description = "MUY PRONTO LAS NOCHES SUBIRÁN DE NIVEL",
                latitude = -16.498681,
                longitude = -68.1269936,
                cover = 20,
                schedule = "Viernes y Sabados: 7:00 PM - 02:00 AM",
                recommendations = "Cuidado te asalten",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, true),
                likes = 9,
                zone = "Miraflores",
                logoString = null
            ),
            Club(
                id = 17,
                logo = R.drawable.logo_guru,
                ownerEmail = "guru@guru.com",
                name = "Gurú",
                license = "90800124A-B24235510",
                ownerNumber = 68128432,
                description = "No te quedes en casa como un monje en su retiro, ¡únete a la experiencia en Guru y que la noche te guíe hacia la verdadera elevación espiritual!",
                latitude = -16.4988979,
                longitude = -68.1375101,
                cover = 20,
                schedule = "Jueves, Viernes, Sabados y Domingos: 8:00 PM - 3:00 AM",
                recommendations = "Cuidado te asalten",
                contactNumber = 63076222,
                tags = mutableListOf(false, true, false, false, true),
                likes = 9,
                zone = "San Pedro",
                logoString = null
            ),
            Club(
                id = 18,
                logo = R.drawable.logo_open_mind,
                ownerEmail = "open@open.com",
                name = "Open Mind",
                license = "90800124A-B24235510",
                ownerNumber = 68128432,
                description = "UN LUGAR PARA OLVIDARSE DE TODO Y PASAR BUENOS MOMENTOS CON TUS AMIGOS DISFRUTAR DE LA BUENA MUSICA",
                latitude = -16.4977612,
                longitude = -68.1390495,
                cover = 25,
                schedule = "Jueves, Viernes, Sabados y Domingos: 8:00 PM - 3:00 AM",
                recommendations = "Cuidado te asalten",
                contactNumber = 63076222,
                tags = mutableListOf(false, false, false, true, true),
                likes = 8,
                zone = "Centro",
                logoString = null
            ),
        )

        fun loadClubs(){
            val data = preference.getString(CLUBDB_KEY, "[]")
            val clubsPreferences = gson.fromJson(data, Array<Club>::class.java).toMutableList()

            clubsPreferences.forEach{ club: Club ->
                if(clubs.contains(club))
                    clubsPreferences.remove(club)
            }

            clubs.addAll(clubsPreferences)
        }

        fun getAllClubs(): List<Club> {
            return clubs
        }

        fun mostLikedClubs(): List<Club> {
            return clubs.sortedWith(compareByDescending { it.likes })
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
            latitude: Double,
            longitude: Double,
            schedule: String,
            recommendations: String,
            contactNumber: Int,
            tags: MutableList<Boolean>,
            logoString: String,
            //zone: String,
            userFirebaseId: String,
            context: Context
        ) {

            var newClub: Club = Club(
                id = clubs.size+1,
                logo = 10,
                name = name,
                ownerEmail = ownerEmail,
                license = license,
                ownerNumber = ownerNumber,
                description = description,
                latitude = latitude,
                longitude = longitude,
                cover = cover,
                schedule = schedule,
                recommendations = recommendations,
                contactNumber = contactNumber,
                tags = tags,
                likes = 0,
                zone = "también falta estoo",
                logoString = logoString
            )
            clubs.add(newClub)

            val clubsJSON = gson.toJson(clubs)

            val editor = preference.edit()
            editor.putString(CLUBDB_KEY, clubsJSON)
            editor.putBoolean(userFirebaseId, true)
            editor.apply()

        }
        fun saveClubs(){
            val clubsJSON = gson.toJson(clubs)
            val editor = preference.edit()
            editor.putString(CLUBDB_KEY, clubsJSON)
            editor.apply()
        }
    }
}