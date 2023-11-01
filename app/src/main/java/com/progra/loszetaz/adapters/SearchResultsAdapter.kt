package com.progra.loszetaz.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.progra.loszetaz.ClubProfileActivity
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.databinding.SearchResultItemBinding

class SearchResultsAdapter :
    RecyclerView.Adapter<SearchResultsAdapter.SearchResultsAdapterViewHolder>() {

    private var context: Context? = null
    private var searchResultList = mutableListOf<Club>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchResultsAdapter.SearchResultsAdapterViewHolder {
        context = parent.context
        return SearchResultsAdapterViewHolder(
            SearchResultItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: SearchResultsAdapter.SearchResultsAdapterViewHolder,
        position: Int
    ) {
        holder.binding(searchResultList[position])
    }

    override fun getItemCount(): Int = searchResultList.size
    inner class SearchResultsAdapterViewHolder(private val binding: SearchResultItemBinding):
            RecyclerView.ViewHolder(binding.root){

                fun binding(data: Club){
                    binding.clubName.text = data.name
                    setImage(data)
                    binding.resultItem.setOnClickListener{
                        val intent = Intent(context, ClubProfileActivity::class.java)
                        intent.putExtra(ClubProfileActivity.CLUB_KEY, data)
                        context?.startActivity(intent)
                    }
                }

                fun setImage(data: Club){
                    if(data.logoString != null)
                        binding.imgClub.setImageURI(Uri.parse(data.logoString))
                    else
                        binding.imgClub.setImageResource(data.logo)
                }
            }
        }

        fun setImage(data: Club) {
            if (data.logoString != null)
                binding.imgClub.setImageURI(Uri.parse(data.logoString))
            else
                binding.imgClub.setImageResource(data.logo)
        }
    }

    fun addResults(newResults: List<Club>) {
        searchResultList.clear()
        searchResultList.addAll(newResults)
    }
}