package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.commit
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.TagsEnum
import com.progra.loszetaz.dataBase.UserDB
import com.progra.loszetaz.databinding.ActivityRegisterClientBinding
import com.progra.loszetaz.databinding.ActivityRegisterClubBinding
import com.progra.loszetaz.fragment.MapsFragment

class RegisterClubActivity : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterClubBinding
    val context: Context = this
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        val fragment = MapsFragment()
        supportFragmentManager.commit {
            replace(binding.mapFragment.id, fragment)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }

        fragment.setOnMapReadyListener { googleMap ->
            this.googleMap = googleMap
        }

        binding.buttonCreateaccount.setOnClickListener {
            val email: String = binding.edittextOwneremail.text.toString()
            val password: String = binding.edittextPassword.text.toString()
            clickCreateAccount(email, password)
        }
        binding.buttonRegisterMap.setOnClickListener{
            if(binding.constraintRegistermap.visibility == View.GONE){
                binding.constraintRegistermap.visibility = View.VISIBLE
            }
        }
        binding.buttonRegisterMapAccepted.setOnClickListener{
            binding.constraintRegistermap.visibility = View.GONE
        }
    }

    fun clickCreateAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val clubName: String = binding.edittextClubname.toString()
                    val license: String = binding.edittextLicense.toString()
                    val phoneNumber: Int = binding.edittextPhonenumerclub.toString().toInt()
                    val description: String = binding.edittextDescription.toString()
                    val schedule: String = binding.edittextSchedule.toString()
                    val contact: Int = binding.edittextContact.toString().toInt()
                    val cover: Int = binding.edittextCover.toString().toInt()
                    var recommendations: String = binding.edittextRecommendations.toString()
                    val tags: MutableList<Boolean> = mutableListOf()
                    val centerOfMap = googleMap.cameraPosition.target
                    val latitude = centerOfMap.latitude
                    val longitude = centerOfMap.longitude
                    tags.set(TagsEnum.TABLE.id, binding.checkboxTables.isChecked)
                    tags.set(TagsEnum.OUTSIDE.id, binding.checkboxOutside.isChecked)
                    tags.set(TagsEnum.OLDIES.id, binding.checkboxOldies.isChecked)
                    tags.set(TagsEnum.NOCOVER.id, binding.checkboxNoCover.isChecked)
                    tags.set(TagsEnum.LIVE.id, binding.checkboxLiveMusic.isChecked)
                    ClubDB.addClub(
                        name = clubName,
                        ownerEmail = email,
                        license = license,
                        ownerNumber = phoneNumber,
                        description = description,
                        latitude = latitude,
                        longitude = longitude,
                        cover = cover,
                        schedule = schedule,
                        recommendations = recommendations,
                        contactNumber = contact,
                        tags = tags,
                    )
                    val intent = Intent(context, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    val toast = Toast.makeText(this,
                        "No se pudo registrar el usuario correctamente", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
    }

}