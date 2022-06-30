package com.intermediate.storyapp.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*
import androidx.core.util.Pair
import com.intermediate.storyapp.R
import com.intermediate.storyapp.data.remote.response.ListStoryItem
import com.intermediate.storyapp.databinding.ListStoryItemBinding
import com.intermediate.storyapp.helper.Helper
import com.intermediate.storyapp.view.storydetail.StoryDetailActivity

class StoryAdapter :
    PagingDataAdapter<ListStoryItem, StoryAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListStoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class ViewHolder(private var binding: ListStoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(story: ListStoryItem) {
            with(binding) {
                Glide.with(imgItemImage)
                    .load(story.photoUrl) // URL Avatar
                    .placeholder(R.drawable.ic_image_holder)
                    .error(R.drawable.ic_broken_image_24)
                    .into(imgItemImage)
                tvUploaderName.text = story.name
                tvDescription.text = story.description
                tvUploadTime.text =
                    binding.root.resources.getString(R.string.uploaded_at, Helper.formatDate(story.createdAt, TimeZone.getDefault().id))

                // image OnClickListener
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, StoryDetailActivity::class.java)
                    intent.putExtra(StoryDetailActivity.EXTRA_STORY, story)
                    itemView.context.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity).toBundle())
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStoryItem>() {
            override fun areItemsTheSame(
                oldItem: ListStoryItem,
                newItem: ListStoryItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListStoryItem,
                newItem: ListStoryItem
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}














