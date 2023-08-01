package com.iago.foodhub

import android.app.Application
import com.google.firebase.FirebaseApp

class FoodHubApp : Application() {
  
  override fun onCreate() {
    super.onCreate()
    
    FirebaseApp.initializeApp(this)
  }
}