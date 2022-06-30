package com.intermediate.storyapp.view.maps

import androidx.lifecycle.ViewModel
import com.intermediate.storyapp.repository.StoryRepository

class MapsViewModel(private val storyRepository: StoryRepository) : ViewModel() {

  fun getStories(token: String) = storyRepository.getStoryMap(token)

}