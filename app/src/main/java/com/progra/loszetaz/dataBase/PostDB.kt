package com.progra.loszetaz.dataBase

import android.content.Context
import android.graphics.BitmapFactory
import com.progra.loszetaz.R
import com.progra.loszetaz.dataClases.Post

class PostDB {
    companion object {
        private lateinit var context: Context
        val posts = mutableListOf<Post>(
            Post(
                title = "\uD83C\uDF83 PACHAWEEN\uD83C\uDF83",
                date = "25 octubre 2023",
                description = "¡Este sábado tenemos un line up imperdible!\n" +
                        "Prepara tu mejor disfraz para bailar por horas.\n",
//                images = listOf(R.drawable.post_pacha_pachaween),
                clubId = 5,
                image = BitmapFactory.decodeResource(
                    context.getResources(),
                    R.drawable.post_pacha_pachaween)
            ),
            Post(
                title = "Calle de las brujas",
                date = "17 octubre 2023",
                description = "¡La previa a Halloween \uD83C\uDF83 \uD83D\uDC7B es en Pachita!\n" +
                        "La Calle de brujas!!",
                image = BitmapFactory.decodeResource(
                    context.getResources(),
                    R.drawable.post_pacha_calle_brujas),
                clubId = 5
            ),
            Post(
                title = "Dia de los muertos",
                date = "25 octubre 2023",
                description = "Day of the Dead, Awaken the Fiesta\uD83D\uDC80",
                image = BitmapFactory.decodeResource(
                    context.getResources(),
                    R.drawable.post_taboo_dia_muertos),
                clubId = 6,
            ),
            Post(
                title = "Rompe con la rutina",
                date = "24 octubre 2023",
                description = "\uD83D\uDD25 Este Miércoles en Malegria, la fiesta número uno en Sopocachi, La Paz, Bolivia, te espera con una irresistible oferta. Reúnete con tus amigos y prepárate para vivir una noche inolvidable con nuestras promociones especiales:\n" +
                        "\uD83C\uDF79 2x1 en todos nuestros cócteles. \uD83C\uDF79 ¡No te pierdas la oportunidad de degustar nuestras exquisitas creaciones!\n" +
                        "\uD83C\uDFA7 ¡Tú eres el DJ! \uD83C\uDFA7 Ponemos el control de la música en tus manos para que disfrutes de tus canciones favoritas toda la noche",
                image = BitmapFactory.decodeResource(
                    context.getResources(),
                    R.drawable.post_malegria_2x1),
                clubId = 4
            )
        )

        fun setContext(mainContext: Context) {
            context = mainContext
        }
        fun getAllPost(): List<Post>{
            return posts
        }
        fun getPostFromClub(clubId: Int): List<Post> {
            return posts.filter { club -> club.clubId == clubId }
        }

        fun addPost(newPost: Post){
            posts.add(newPost)
        }
    }
}