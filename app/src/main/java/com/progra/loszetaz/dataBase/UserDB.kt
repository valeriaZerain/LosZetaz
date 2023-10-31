package com.progra.loszetaz.dataBase

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.preference.PreferenceManager
import androidx.annotation.Nullable
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.progra.loszetaz.GlobalConfig
import com.progra.loszetaz.R
import com.progra.loszetaz.dataClases.User

class UserDB {

    companion object {

        private val gson = Gson()
        private val prettyGson = GsonBuilder().setPrettyPrinting().create()

        private lateinit var preference: SharedPreferences

        val USERDB_KEY = "USERDB_KEY"

        val users: MutableList<User> = mutableListOf<User>(
//            User(
//                id = 0,
//                name = "Zein Tonconi",
//                email = "zeincho@zeincho.com",
//                cellphone = 70186881,
//                birthday = "08-12-2003",
//                ci = 15278109,
//                likedIdClubs = mutableListOf(1, 2, 3, 5),
//                profilePicture = R.drawable.photo_zein_profile,
//
//            ),
//            User(
//                id = 1,
//                name = "Valeria Zerain",
//                email = "vale@zerain.com",
//                cellphone = 60627590,
//                birthday = "17-06-2003",
//                ci = 15278110,
//                likedIdClubs = mutableListOf(4, 6, 7, 8)
//            )

        )

        fun loadUsers(){

        }

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


        fun addUser(username: String, email: String, cellphone: Int, birthday: String, ci: Int,
                    pickedBitmap: Bitmap, userFirebaseId: String, context: Context) {
            val newLikes: List<Int> = mutableListOf()
            val newUser = User(
                id = users.size,
                name = username,
                email = email,
                cellphone = cellphone,
                birthday = birthday,
                ci = ci,
                likedIdClubs = newLikes,
                profilePicture = pickedBitmap
            )
            users.add(newUser)

            preference = PreferenceManager.getDefaultSharedPreferences(context)

            val usersJSON = gson.toJson(users)
            val prettyUserJSON = prettyGson.toJson(users)
            val editor = preference.edit()
            editor.putString(USERDB_KEY, usersJSON)
            editor.putBoolean(userFirebaseId, true)
            editor.apply()

            setActualClient(newUser)
        }

        fun setActualClient(user: User){
            GlobalConfig.actualClient = user
        }

        fun getClientByEmail(email: String): User{
            var result: User? = null
            users.forEach{user ->
                if(user.email == email){
                    result = user
                }
            }
            return result!!
        }
    }

}
