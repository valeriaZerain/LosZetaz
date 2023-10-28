package com.progra.loszetaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.progra.loszetaz.adapters.FeedPostClubAdapter
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.dataClases.Post
import com.progra.loszetaz.databinding.ActivityClubProfileBinding
import java.util.Date

class ClubProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClubProfileBinding
    private val feedClubAdapter by lazy { FeedPostClubAdapter() }

    private var isInfoShown: Boolean = true
    private lateinit var actualClub: Club

    private val isClientUser = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(isClientUser){
            binding.clubLayout.visibility = View.INVISIBLE
            binding.clientLayout.visibility = View.VISIBLE
        }
        else{
            binding.clubLayout.visibility = View.VISIBLE
            binding.clientLayout.visibility = View.INVISIBLE
        }
        actualClub = intent.getSerializableExtra(CLUB_KEY) as Club

        showProfile()
        showPosts()


        binding.textInfo.setOnClickListener{
            if(!isInfoShown){
                isInfoShown = true
                binding.feedClubScroll.visibility = View.GONE
                binding.clubInfo.visibility = View.VISIBLE
                binding.textInfo.setTextColor(
                    AppCompatResources.getColorStateList
                        (this, R.color.turquoise))
                binding.textFeed.setTextColor(
                    AppCompatResources.getColorStateList
                        (this, R.color.white))

            }
        }
        binding.textFeed.setOnClickListener {
            if(isInfoShown){
                isInfoShown = false
                binding.clubInfo.visibility = View.GONE
                binding.feedClubScroll.visibility = View.VISIBLE
                binding.textInfo.setTextColor(
                    AppCompatResources.getColorStateList
                        (this, R.color.white))
                binding.textFeed.setTextColor(
                    AppCompatResources.getColorStateList
                        (this, R.color.fucsia))
            }
        }

    }

    fun showProfile(){
        binding.textClubName.text = actualClub.name
        binding.imageLogoClub.setImageResource(actualClub.logo)
        binding.textNumberLikes.text = actualClub.likes.toString()
        binding.textDescription.text = actualClub.description
        binding.textRecommendations.text = actualClub.recommendations
        binding.schedule.text = actualClub.schedule
        binding.textCover.text = actualClub.cover.toString()
        binding.textLocation.text = actualClub.location
    }
    fun showPosts(){

        feedClubAdapter.addFeedPost(PostDB.getPostFromClub(actualClub.id))

        binding.feedClubRecycler.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = feedClubAdapter
        }

    }

    companion object{
        val CLUB_KEY = "club_key"
    }
}