package com.progra.loszetaz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.progra.loszetaz.dataClases.Post
import com.progra.loszetaz.databinding.ActivityHomeScreenBinding
import com.progra.loszetaz.databinding.RecentPostClubItemBinding

class RecentPostClubAdapter: RecyclerView.Adapter<RecentPostClubAdapter.RecentPostClubAdapterViewHolder>() {

    private var context: Context? = null
    private var recentPostList = mutableListOf<Post>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentPostClubAdapter.RecentPostClubAdapterViewHolder {
        context = parent.context
        return RecentPostClubAdapterViewHolder(
            RecentPostClubItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RecentPostClubAdapter.RecentPostClubAdapterViewHolder,
        position: Int
    ) {
        holder.binding(recentPostList[position])
    }

    override fun getItemCount(): Int = recentPostList.size

    inner class RecentPostClubAdapterViewHolder(private  val binding: RecentPostClubItemBinding):
            RecyclerView.ViewHolder(binding.root){

                fun binding(data: Post){
                    binding.postTitle.text = data.title
                    binding.postImage.setImageResource(data.images[0])
                }

            }
    fun addPost(newPosts: List<Post>){
        recentPostList.clear()
        recentPostList.addAll(newPosts)
    }
}