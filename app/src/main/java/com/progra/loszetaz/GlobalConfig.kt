package com.progra.loszetaz

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.FirebaseUser
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.UserDB
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.dataClases.User

class GlobalConfig {
    companion object {

        val USER_KEY = "user_key"
        val CLUB_KEY = "club_key"

        var actualClient: User? = null
        var actualClub: Club? = null
        var userFirebase: FirebaseUser? = null
        var isUserClient: Boolean = true
        lateinit var preference: SharedPreferences

        var coordinateProfileClub: LatLng? = null
        fun initPreferences(context: Context) {
            preference = PreferenceManager.getDefaultSharedPreferences(context)
        }

        fun markAsClient(user: FirebaseUser?) {
            val editor = preference.edit()
            editor.putBoolean(user!!.uid, true)
            editor.apply()
        }

        fun markAsClub(user: FirebaseUser?) {
            val editor = preference.edit()
            editor.putBoolean(user!!.uid, false)
            editor.apply()
        }

        fun initUser(currentUserFirebase: FirebaseUser?) {
            userFirebase = currentUserFirebase
            isUserClient = preference.getBoolean(userFirebase!!.uid, false)
            if (isUserClient)
                actualClient = UserDB.getClientByEmail(userFirebase!!.email!!)
            else
                actualClub = ClubDB.getClubByEmail(userFirebase!!.email!!)
        }

        fun isUserAClient(): Boolean {
            when {
                actualClient != null ->
                    return true

                actualClub != null ->
                    return false

                else ->
                    return preference.getBoolean(userFirebase!!.uid, false)
            }
        }
    }
}