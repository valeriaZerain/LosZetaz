package com.progra.loszetaz.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.progra.loszetaz.ClubProfileActivity
import com.progra.loszetaz.ClubProfileActivity.Companion.CLUB_KEY
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.databinding.MostLikedClubItemBinding

class MostLikedClubAdapter: RecyclerView.Adapter<MostLikedClubAdapter.MostLikedClubAdapterViewHolder>() {

    private var context: Context? = null
    private var mostLikedClubsList = mutableListOf<Club>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MostLikedClubAdapter.MostLikedClubAdapterViewHolder {
        context = parent.context
        return MostLikedClubAdapterViewHolder(
            MostLikedClubItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: MostLikedClubAdapter.MostLikedClubAdapterViewHolder,
        position: Int
    ) {
        holder.binding(mostLikedClubsList[position])
    }

    override fun getItemCount(): Int = mostLikedClubsList.size

    inner class MostLikedClubAdapterViewHolder(private val binding: MostLikedClubItemBinding):
        RecyclerView.ViewHolder(binding.root){

            fun binding(data: Club){
                binding.clubName.text = data.name
                binding.textNumberLikes.text = data.likes.toString()
                setImageClub(data)
                binding.textShowMore.setOnClickListener {
                    val intent = Intent(context, ClubProfileActivity::class.java)
                    intent.putExtra(CLUB_KEY, data)
                    context?.startActivity(intent)
                }
            }

            fun setImageClub(data: Club){
                if(data.logoString != null)
                    binding.imgClub.setImageURI(Uri.parse(data.logoString))
                else
                    binding.imgClub.setImageResource(data.logo)
            }

    }

    fun addClubs(newClubs: List<Club>){
        mostLikedClubsList.clear()
        mostLikedClubsList.addAll(newClubs)
    }
}