package com.intermediate.storyapp.view.storydetail

import android.graphics.text.LineBreaker
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.intermediate.storyapp.R
import com.intermediate.storyapp.data.remote.response.ListStoryItem
import com.intermediate.storyapp.databinding.ActivityStoryDetailBinding
import com.intermediate.storyapp.helper.Helper
import java.util.*

class StoryDetailActivity : AppCompatActivity() {
    private lateinit var story: ListStoryItem
    private lateinit var binding: ActivityStoryDetailBinding

    private val vm: StoryDetailViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            run {
                binding.tvDescription.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
            }
        }

        story = intent.getParcelableExtra(EXTRA_STORY)!!
        vm.setDetailStory(story)
        displayResult()
        setupToolbar()
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun displayResult() {
        with(binding){
            tvName.text = vm.storyItem.name
            tvCreatedTime.text = getString(
                R.string.uploaded_at, Helper.formatDate(vm.storyItem.createdAt,
                TimeZone.getDefault().id ))
            tvDescription.text = vm.storyItem.description

            Glide.with(ivStory)
                .load(vm.storyItem.photoUrl) // URL Avatar
                .placeholder(R.drawable.ic_image_holder)
                .error(R.drawable.ic_broken_image_24)
                .into(ivStory)
        }
    }

    companion object {
        const val EXTRA_STORY = "story"
    }
}