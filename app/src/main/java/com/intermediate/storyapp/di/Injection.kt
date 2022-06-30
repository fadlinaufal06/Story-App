package com.intermediate.storyapp.di

import android.content.Context
import com.intermediate.storyapp.data.remote.retrofit.ApiConfig
import com.intermediate.storyapp.repository.StoryRepository
import com.intermediate.storyapp.room.StoryDatabase

object Injection {
  fun provideStoryRepository(context: Context): StoryRepository {
    val database = StoryDatabase.getInstance(context)
    val apiService = ApiConfig.getApiService()
    return StoryRepository(database, apiService)
  }
}