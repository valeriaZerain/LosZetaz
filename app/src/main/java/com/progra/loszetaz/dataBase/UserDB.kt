package com.progra.loszetaz.dataBase

import androidx.annotation.Nullable
import com.progra.loszetaz.dataClases.User

class UserDB {
    companion object {
        var idNewUser = 12
        val users: MutableList<User> = mutableListOf<User>(
            User(
                id = 10,
                name = "Zein Tonconi",
                email = "zeincho@zeincho.com",
                cellphone = 70186881,
                birthday = "08-12-2003",
                ci = 15278109,
                likedIdClubs = mutableListOf(1, 2, 3, 5)
            ),
            User(
                id = 11,
                name = "Valeria Zerain",
                email = "vale@zerain.com",
                cellphone = 60627590,
                birthday = "17-06-2003",
                ci = 15278110,
                likedIdClubs = mutableListOf(4, 6, 7, 8)
            )

        )

        fun getAllUsers(): List<User> {
            return users
        }

        fun getUserById(id: Int): User? {
            users.forEach { user ->
                if (user.id == id)
                    return user
            }
            return null
        }

        fun addUser(username: String, email: String, cellphone: Int, birthday: String, ci: Int) {
            idNewUser++
            val newLikes: List<Int> = mutableListOf()
            val newUser = User(
                id = idNewUser,
                name = username,
                email = email,
                cellphone = cellphone,
                birthday = birthday,
                ci = ci,
                likedIdClubs = newLikes
            )
            users.add(newUser)
        }
    }

}
