package com.example.postapp.Database

import android.app.Application
import android.content.Context

class PostApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        PostApp.appContext = applicationContext
        Stetho.initializeWithDefaults(baseContext)
    }
    companion object{
        lateinit var appContext: Context
    }
}