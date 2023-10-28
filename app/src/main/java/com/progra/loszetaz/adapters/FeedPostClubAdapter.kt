package com.progra.loszetaz.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.dataClases.Post
import com.progra.loszetaz.databinding.FeedPostClubItemBinding

class FeedPostClubAdapter: RecyclerView.Adapter<FeedPostClubAdapter.FeedPostClubAdapterViewHolder>() {

    private var context: Context? = null
    private var feedPostList = mutableListOf<Post>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeedPostClubAdapter.FeedPostClubAdapterViewHolder {
        context = parent.context
        return FeedPostClubAdapterViewHolder(
            FeedPostClubItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: FeedPostClubAdapter.FeedPostClubAdapterViewHolder,
        position: Int
    ) {
       holder.binding(feedPostList[position])
    }

    override fun getItemCount(): Int = feedPostList.size

    inner class FeedPostClubAdapterViewHolder(private val binding: FeedPostClubItemBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun binding(data: Post){
                    binding.titlePost.text = data.title
                    binding.datePost.text = data.date
                    binding.descriptionPost.text = data.description
                    binding.imgPost.setImageBitmap(data.image)
                }

            }

    fun addFeedPost(newPost: List<Post>){
        feedPostList.clear()
        feedPostList.addAll(newPost)
    }

}