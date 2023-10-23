package com.progra.loszetaz.dataBase

import androidx.annotation.Nullable
import com.progra.loszetaz.dataClases.User

class UserDB {
    companion object {
        val users: List<User> = listOf<User>(
            User(
                id = 10,
                name = "Zein Tonconi",
                email = "zeincho@zeincho.com",
                cellphone = 70186881,
                birthday = "08-12-2003",
                ci = 15278109,
                password = "zeincho123",
                likedIdClubs = mutableListOf(1,2,3,5)
            ),
            User(
                id = 11,
                name = "Valeria Zerain",
                email = "vale@zerain.com",
                cellphone = 60627590,
                birthday = "17-06-2003",
                ci = 15278110,
                password = "valeria123",
                likedIdClubs = mutableListOf(4,6,7,8)
            )

        )

        fun getAllUsers(): List<User>{
            return users
        }

        fun getUserById(id: Int): User? {
            users.forEach{ user ->
                if(user.id == id)
                    return user
            }
            return null
        }
    }

}
