package com.progra.loszetaz

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.firebase.auth.FirebaseUser
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.UserDB
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.dataClases.User

class GlobalConfig {
    companion object{
        var actualClient: User? = null
        var actualClub: Club? = null
        var userFirebase: FirebaseUser? = null
        var isUserAClient: Boolean = true
        private lateinit var preference: SharedPreferences
        fun initPreferences(context: Context){
            preference = PreferenceManager.getDefaultSharedPreferences(context)
        }

        fun initUser(currentUserFirebase: FirebaseUser?){
            userFirebase = currentUserFirebase
            isUserAClient = preference.getBoolean(userFirebase!!.uid, false)
            if(isUserAClient)
                actualClient = UserDB.getClientByEmail(userFirebase!!.email!!)
            else
                actualClub = ClubDB.getClubByEmail(userFirebase!!.email!!)
        }
        fun isUserAClient(): Boolean{
            when{
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