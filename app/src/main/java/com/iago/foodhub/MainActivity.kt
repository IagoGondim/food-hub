package com.iago.foodhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.iago.foodhub.app.FoodHubApp

class MainActivity : ComponentActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FoodHubApp()
    }
  }
}

@Preview
@Composable
fun DefaultPreview() {
  FoodHubApp()
}

