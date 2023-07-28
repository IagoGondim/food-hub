package com.iago.foodhub.screens;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iago.foodhub.R
import com.iago.foodhub.components.HeadingTextComponent
import com.iago.foodhub.navigation.FoodHubAppRouter
import com.iago.foodhub.navigation.Screen
import com.iago.foodhub.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .background(color = Color.White)
      .padding(16.dp)
  ) {
    HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
  }
  
  SystemBackButtonHandler {
    FoodHubAppRouter.navigateTo(Screen.SignUpScreen)
  }
  
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview() {
  TermsAndConditionsScreen()
}
