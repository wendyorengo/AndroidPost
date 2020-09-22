package com.example.postapp.Database

import androidx.lifecycle.LiveData
import retrofit2.http.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.postapp.Model.post

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post:post)
    @Query("SELECT * FROM post")
    fun getPosts(): LiveData<List<post>>
}