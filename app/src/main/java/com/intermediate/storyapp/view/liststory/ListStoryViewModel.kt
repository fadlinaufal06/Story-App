package com.intermediate.storyapp.view.liststory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.intermediate.storyapp.data.remote.response.ListStoryItem
import com.intermediate.storyapp.repository.StoryRepository


class ListStoryViewModel(
    private val storyRepository: StoryRepository,
) : ViewModel() {

    fun getStory(token: String): LiveData<PagingData<ListStoryItem>> {
        return storyRepository.getPagingStories(token).cachedIn(viewModelScope).asLiveData()
    }
}