package com.iago.foodhub.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.iago.foodhub.navigation.FoodHubAppRouter
import com.iago.foodhub.navigation.Screen
import com.iago.foodhub.screens.HomeScreen
import com.iago.foodhub.screens.LoginScreen
import com.iago.foodhub.screens.SignUpScreen
import com.iago.foodhub.screens.TermsAndConditionsScreen

@Composable
fun FoodHubApp() {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = Color.White
  ) {
    
    Crossfade(targetState = FoodHubAppRouter.currentScreen) { currentState ->
      when (currentState.value) {
        is Screen.SignUpScreen -> {
          SignUpScreen()
        }
        
        is Screen.TermsAndConditionsScreen -> {
          TermsAndConditionsScreen()
        }
        
        is Screen.LoginScreen -> {
          LoginScreen()
        }
        
        is Screen.HomeScreen -> {
          HomeScreen()
        }
      }
    }
    
  }
}