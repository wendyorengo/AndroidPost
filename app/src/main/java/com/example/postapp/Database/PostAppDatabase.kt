package com.example.postapp.Database

import retrofit2.http.POST

@Database(entities = arrayOf(Post::class), version = 1)
abstract class PostAppDatabase : RoomDatabase(){
    abstract fun postDao():PostsDao

    companion object{
        private var dbInstance:PostAppDatabase? = null
        fun getDbInstance(context: Context):PostAppDatabase
                if(dbInstance == null){
            dbInstance = Room.databaseBuilder(context, PostAppDatabase::class.java)
        }
        return dbInstance as PostAppDatabase



    }
}