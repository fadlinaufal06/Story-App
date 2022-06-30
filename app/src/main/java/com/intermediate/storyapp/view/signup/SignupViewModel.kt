package com.intermediate.storyapp.view.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intermediate.storyapp.data.remote.response.ApiResponse
import com.intermediate.storyapp.data.remote.retrofit.ApiConfig
import com.intermediate.storyapp.helper.Helper
import com.intermediate.storyapp.repository.StoryRepository
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterViewModel(val storyRepository: StoryRepository) : ViewModel() {

    fun register(name: String, email: String, pass: String) =
        storyRepository.register(name,email, pass)

}