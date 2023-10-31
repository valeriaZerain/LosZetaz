package com.progra.loszetaz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.progra.loszetaz.CreatePostActivity.Companion.NAME_CLUB_KEY
import com.progra.loszetaz.adapters.FeedPostClubAdapter
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.databinding.ActivityClubProfileBinding

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
            // TODO check if the actualUser has liked the club
        }
        else{
            binding.updateInfo.visibility = View.VISIBLE
            binding.clubLayout.visibility = View.VISIBLE
            binding.clientLayout.visibility = View.INVISIBLE
        }
        actualClub = intent.getSerializableExtra(CLUB_KEY) as Club

        setProfile()
        showPosts()


        binding.textInfo.setOnClickListener{
            if(!isInfoShown){
                isInfoShown = true
               showInfoProfile()
            }
        }
        binding.textFeed.setOnClickListener {
            if(isInfoShown){
                isInfoShown = false
                showFeedProfile()
            }
        }

        binding.addPostButton.setOnClickListener{
            val intent = Intent(this,CreatePostActivity::class.java)
            intent.putExtra(NAME_CLUB_KEY, actualClub.name)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        showPosts()
    }

    fun showInfoProfile(){
        binding.feedClubScroll.visibility = View.GONE
        binding.clubInfo.visibility = View.VISIBLE
        binding.textInfo.setTextColor(
            AppCompatResources.getColorStateList
                (this, R.color.turquoise))
        binding.textFeed.setTextColor(
            AppCompatResources.getColorStateList
                (this, R.color.white))
        if(!isClientUser)
            binding.updateInfo.visibility = View.VISIBLE
        else
            binding.updateInfo.visibility = View.GONE
        binding.addPostButton.visibility = View.GONE
    }

    fun showFeedProfile(){
        binding.clubInfo.visibility = View.GONE
        binding.feedClubScroll.visibility = View.VISIBLE
        binding.textInfo.setTextColor(
            AppCompatResources.getColorStateList
                (this, R.color.white))
        binding.textFeed.setTextColor(
            AppCompatResources.getColorStateList
                (this, R.color.fucsia))
        if(!isClientUser)
            binding.addPostButton.visibility = View.VISIBLE
        else
            binding.addPostButton.visibility = View.GONE
        binding.updateInfo.visibility = View.GONE
    }

    fun setProfile(){
        binding.textClubNameFeed.text = actualClub.name
        binding.textClubName.text = actualClub.name
        binding.imageLogoClub.setImageResource(actualClub.logo)
        binding.textNumberLikes.text = actualClub.likes.toString()
        binding.textDescription.text = actualClub.description
        binding.textRecommendations.text = actualClub.recommendations
        binding.schedule.text = actualClub.schedule
        binding.textCover.text = actualClub.cover.toString()
        binding.textLocation.text = actualClub.latitude.toString()
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