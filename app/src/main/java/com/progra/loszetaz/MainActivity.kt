package com.progra.loszetaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.progra.loszetaz.dataBase.UserDB


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(UserDB.getAllUsers())
        println(UserDB.getUserById(10))
        println(UserDB.getUserById(0) ?: "No existe el usuario")

    }
}