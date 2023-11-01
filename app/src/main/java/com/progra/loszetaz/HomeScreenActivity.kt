package com.progra.loszetaz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.progra.loszetaz.GlobalConfig.Companion.USER_KEY
import com.progra.loszetaz.adapters.MostLikedClubAdapter
import com.progra.loszetaz.adapters.RecentPostClubAdapter
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private val mostLikedClubAdapter by lazy { MostLikedClubAdapter() }
    private val recentPostClubAdapter by lazy { RecentPostClubAdapter() }

    private var isRecentPostShow = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.searchIcon.setOnClickListener {
            val intentHomeToSearch = Intent(this, SearchScreenActivity::class.java)
            startActivity(intentHomeToSearch)
        }
        binding.buttonGoToMap.setOnClickListener {
            val intentGoToMap = Intent(this, MapActivity::class.java)
            startActivity(intentGoToMap)
        }

        showMostLikedClubs()
        showRecentPost()

        binding.textRecentPosts.setOnClickListener {
            if(!isRecentPostShow){
                isRecentPostShow = true
                binding.mostLikedClubRecycler.visibility = View.GONE
                binding.recentPostClubRecycler.visibility = View.VISIBLE
                binding.textRecentPosts.setTextColor(AppCompatResources.getColorStateList
                    (this, R.color.turquoise))
                binding.textMostLikedClubs.setTextColor(AppCompatResources.getColorStateList
                    (this, R.color.white))

            }
        }
        binding.textMostLikedClubs.setOnClickListener {
            if(isRecentPostShow){
                isRecentPostShow = false
                binding.recentPostClubRecycler.visibility = View.GONE
                binding.mostLikedClubRecycler.visibility = View.VISIBLE
                binding.textRecentPosts.setTextColor(AppCompatResources.getColorStateList
                    (this, R.color.white))
                binding.textMostLikedClubs.setTextColor(AppCompatResources.getColorStateList
                    (this, R.color.fucsia))
            }
        }

        binding.profileButton.setOnClickListener{
            val intent = Intent(this, MyInformationActivity::class.java)
            intent.putExtra(USER_KEY,GlobalConfig.actualClient)
            startActivity(intent)
        }

        binding.buttonGoToMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        showRecentPost()
        showMostLikedClubs()
    }
    fun showMostLikedClubs(){
        mostLikedClubAdapter.addClubs(ClubDB.mostLikedClubs())
        binding.mostLikedClubRecycler.apply{
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mostLikedClubAdapter
        }
    }

    fun showRecentPost(){
        recentPostClubAdapter.addPost(PostDB.getAllPost())

        binding.recentPostClubRecycler.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = recentPostClubAdapter
        }
    }

}