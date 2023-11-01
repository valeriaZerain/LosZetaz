package com.progra.loszetaz.dataBase

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.progra.loszetaz.GlobalConfig.Companion.preference
import com.progra.loszetaz.dataClases.User

class UserDB {
    companion object {
        private val gson = Gson()
        private val prettyGson = GsonBuilder().setPrettyPrinting().create()


        val USERDB_KEY = "USERDB_KEY"

        var users: MutableList<User> = mutableListOf<User>()

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


        fun loadUsers() {
            val data = preference.getString(USERDB_KEY, "[]")
            users = gson.fromJson(data, Array<User>::class.java).toMutableList()
        }

        fun addUser(
            username: String, email: String, cellphone: Int, birthday: String, ci: Int,
            pickedPhotoString: String, userFirebaseId: String, context: Context
        ) {
            val newLikes: MutableList<Int> = mutableListOf()
            val newUser = User(
                id = users.size,
                name = username,
                email = email,
                cellphone = cellphone,
                birthday = birthday,
                ci = ci,
                likedIdClubs = newLikes,
                profilePictureString = pickedPhotoString
            )
            users.add(newUser)


            val usersJSON = gson.toJson(users)
            val prettyUserJSON = prettyGson.toJson(users)
            val editor = preference.edit()
            editor.putString(USERDB_KEY, usersJSON)
            editor.putBoolean(userFirebaseId, true)
            editor.apply()

        }

        fun saveUsers() {
            val usersJSON = gson.toJson(users)
            val editor = preference.edit()
            editor.putString(USERDB_KEY, usersJSON)
            editor.apply()
        }


        fun getClientByEmail(email: String): User {
            var result: User? = null
            users.forEach { user ->
                if (user.email == email) {
                    result = user
                }
            }
            return result!!
        }
    }
}

