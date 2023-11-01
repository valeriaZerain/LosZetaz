package com.progra.loszetaz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.model.LatLng
import com.progra.loszetaz.CreatePostActivity.Companion.NAME_CLUB_KEY
import com.progra.loszetaz.GlobalConfig.Companion.actualClient
import com.progra.loszetaz.GlobalConfig.Companion.actualClub
import com.progra.loszetaz.GlobalConfig.Companion.coordinateProfileClub
import com.progra.loszetaz.GlobalConfig.Companion.isUserClient
import com.progra.loszetaz.adapters.FeedPostClubAdapter
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.dataBase.UserDB
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.databinding.ActivityClubProfileBinding
import com.progra.loszetaz.fragment.EmptyMapFragment
import com.progra.loszetaz.fragment.MapsFragment

class ClubProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClubProfileBinding
    private val feedClubAdapter by lazy { FeedPostClubAdapter() }

    private lateinit var club: Club

    private var isInfoShown: Boolean = true
    private var hasLiked: Boolean = true
    private lateinit var fragment: EmptyMapFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragment = EmptyMapFragment()
        if(isUserClient){
            club = intent.getSerializableExtra(CLUB_KEY) as Club
            binding.clubLayout.visibility = View.INVISIBLE
            binding.clientLayout.visibility = View.VISIBLE

            hasLiked = actualClient!!.likedIdClubs.contains(club.id)
            if(hasLiked)
                binding.imageFavorite.setImageResource(R.drawable.favorite_full)
            else
                binding.imageFavorite.setImageResource(R.drawable.favorite_border)

            binding.imageFavorite.setOnClickListener {
                hasLiked = !hasLiked
                if(hasLiked){
                    binding.imageFavorite.setImageResource(R.drawable.favorite_full)
                    actualClient!!.likedIdClubs.add(club.id)
                    ClubDB.getClubById(club.id)!!.likes++
                    club.likes++
                }
                else{
                    binding.imageFavorite.setImageResource(R.drawable.favorite_border)
                    actualClient!!.likedIdClubs.remove(club.id)
                    ClubDB.getClubById(club.id)!!.likes--
                    club.likes--
                }
                setProfile()
                ClubDB.saveClubs()
                UserDB.saveUsers()
            }
        }
        else{
            club = actualClub!!
            binding.updateInfo.visibility = View.VISIBLE
            binding.clubLayout.visibility = View.VISIBLE
            binding.clientLayout.visibility = View.INVISIBLE
        }

        setMap()
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
            intent.putExtra(NAME_CLUB_KEY, club.name)
            startActivity(intent)
        }

        binding.profileIcon.setOnClickListener {
            val intent = Intent(this,MyInformationActivity::class.java)
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
        if(!isUserClient)
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
        if(!isUserClient)
            binding.addPostButton.visibility = View.VISIBLE
        else
            binding.addPostButton.visibility = View.GONE
        binding.updateInfo.visibility = View.GONE
    }

    fun setMap(){
        coordinateProfileClub = LatLng( club.latitude, club.longitude)
        supportFragmentManager.commit {
            replace(binding.mapFragment.id, fragment)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
    fun setProfile(){
        binding.textClubNameFeed.text = club.name
        binding.textClubName.text = club.name
        binding.textNumberLikes.text = club.likes.toString()
        binding.textDescription.text = club.description
        binding.textRecommendations.text = club.recommendations
        binding.schedule.text = club.schedule
        binding.textCover.text = club.cover.toString()


        setProfileImage()
    }

    fun setProfileImage(){
        if(club.logoString != null)
            binding.imageLogoClub.setImageURI(Uri.parse(club.logoString))
        else
            binding.imageLogoClub.setImageResource(club.logo)
    }
    fun showPosts(){

        feedClubAdapter.addFeedPost(PostDB.getPostFromClub(club.id))

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