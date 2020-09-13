package com.example.postapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.postapp.repository.PostRepository

class PostViewModel (val postsRepository: PostRepository): ViewModel(){
    var postsLivedData = MutableLiveData<List<Post>>()
    var postsFailedLivedData = MutableLiveData<String>()
    fun getPosts(){
        ViewModelScope.launch {
            val response = PostRepository.getPosts()
            if (response.isSuccessful){
                postsLivedData.postValue(response.body())
            }
            else{
                postsFailedLivedData.postValue(response.errorBody()?.string())
            }
        }

    }

}