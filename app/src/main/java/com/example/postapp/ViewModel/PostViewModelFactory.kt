package com.example.postapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.repository.PostRepository

class PostViewModelFactory (val postsRepository: PostRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass,isAssignableFrom(PostViewModel:: class.java)){
            return PostViewModel(postsRepository) as T
        }
        throw IllegalArgumentException("unknown view model")
    }
}
