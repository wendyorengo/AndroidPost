
package com.example.postapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.R
import com.example.postapp.ViewModel.PostViewModel
import com.example.postapp.repository.PostRepository
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostViewModel
    lateinit var postsViewModelFactory: PostViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postsRepository = PostRepository()
        postsViewModelFactory = PostViewModelFactory(postsRepository)
        postsViewModel = ViewModelProvider(this, postsViewModelFactory).get(PostViewModel::class.java)
        postsViewModel.getPosts()
        postsViewModel.postsLiveData.observe(this,{postsList -> Toast.makeText(baseContext,"${postsList.size}posts fetched", Toast.LENGTH_LONG).show()
            if(posts.isEmpty()){
                postsViewModel.getApiPosts()
            }
            else{
                val postsAdapter = PostsRvAdapter(posts)
                rvPosts.apply {
                    layoutManager = LinearLayoutManager(baseContext)
                    adapter = PostsAdapter
                }
            }
        })
        postsViewModel.postsFailedLiveData.observe(this, {error-> Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()
        })

    }
}