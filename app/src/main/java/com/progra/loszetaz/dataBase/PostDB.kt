package com.progra.loszetaz.dataBase

import com.progra.loszetaz.R
import com.progra.loszetaz.dataClases.Post
import kotlinx.datetime.LocalDate
class PostDB {
    companion object {
        private val posts = mutableListOf<Post>(
            Post(
                title = "\uD83C\uDF83 PACHAWEEN\uD83C\uDF83",
                date = LocalDate(2023,10,25),
                description = "¡Este sábado tenemos un line up imperdible!\n" +
                        "Prepara tu mejor disfraz para bailar por horas.\n",
                image = R.drawable.post_pacha_pachaween,
                clubId = 5,
                imageBitmap = null
            ),
            Post(
                title = "Calle de las brujas",
                date = LocalDate(2023,10,17),
                description = "¡La previa a Halloween \uD83C\uDF83 \uD83D\uDC7B es en Pachita!\n" +
                        "La Calle de brujas!!",
                image = R.drawable.post_pacha_calle_brujas,
                clubId = 5,
                imageBitmap = null
            ),
            Post(
                title = "Dia de los muertos",
                date = LocalDate(2023,10,25),
                description = "Day of the Dead, Awaken the Fiesta\uD83D\uDC80",
                image = R.drawable.post_taboo_dia_muertos,
                clubId = 6,
                imageBitmap = null
            ),
            Post(
                title = "Rompe con la rutina",
                date = LocalDate(2023,10,24),
                description = "\uD83D\uDD25 Este Miércoles en Malegria, la fiesta número uno en Sopocachi, La Paz, Bolivia, te espera con una irresistible oferta. Reúnete con tus amigos y prepárate para vivir una noche inolvidable con nuestras promociones especiales:\n" +
                        "\uD83C\uDF79 2x1 en todos nuestros cócteles. \uD83C\uDF79 ¡No te pierdas la oportunidad de degustar nuestras exquisitas creaciones!\n" +
                        "\uD83C\uDFA7 ¡Tú eres el DJ! \uD83C\uDFA7 Ponemos el control de la música en tus manos para que disfrutes de tus canciones favoritas toda la noche",
                image = R.drawable.post_malegria_2x1,
                clubId = 4,
                imageBitmap = null
            )
        )

        fun orderPosts(listPost: List<Post>): List<Post> {
            return listPost.sortedWith(compareByDescending { post -> post.date })
        }
        fun getAllPost(): List<Post>{
            return orderPosts( posts )
        }
        fun getPostFromClub(clubId: Int): List<Post> {
            return orderPosts( posts.filter { club -> club.clubId == clubId } )
        }

        fun addPost(newPost: Post){
            posts.add(newPost)
        }
    }
}