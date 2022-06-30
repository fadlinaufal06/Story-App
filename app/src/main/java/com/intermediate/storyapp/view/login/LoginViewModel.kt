package com.intermediate.storyapp.view.login

import androidx.lifecycle.ViewModel
import com.intermediate.storyapp.repository.StoryRepository



class LoginViewModel(private val storyRepository: StoryRepository): ViewModel()  {

    fun login(email: String, pass: String) =
        storyRepository.login(email, pass)

}