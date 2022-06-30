package com.intermediate.storyapp.view.storydetail

import androidx.lifecycle.ViewModel
import com.intermediate.storyapp.data.remote.response.ListStoryItem

class StoryDetailViewModel: ViewModel() {
    lateinit var storyItem: ListStoryItem

    fun setDetailStory(story: ListStoryItem) : ListStoryItem{
        storyItem = story
        return storyItem
    }

}