package com.intermediate.storyapp.view.uploadstory

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intermediate.storyapp.data.model.UserModel
import com.intermediate.storyapp.data.remote.response.ApiResponse
import com.intermediate.storyapp.data.remote.retrofit.ApiConfig
import com.intermediate.storyapp.helper.Helper
import com.intermediate.storyapp.repository.StoryRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UploadStoryViewModel(private val storyRepository: StoryRepository) : ViewModel() {
    fun postStory(
        token: String,
        description: RequestBody,
        imageMultipart: MultipartBody.Part,
        lat: RequestBody? = null,
        lon: RequestBody? = null
    ) = storyRepository.postStory(token, description, imageMultipart, lat, lon)
}