package com.iago.foodhub.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iago.foodhub.R
import com.iago.foodhub.components.ButtonComponent
import com.iago.foodhub.components.ClickableLoginTextComponent
import com.iago.foodhub.components.DividerTextComponent
import com.iago.foodhub.components.HeadingTextComponent
import com.iago.foodhub.components.MyTextFieldComponent
import com.iago.foodhub.components.NormalTextComponent
import com.iago.foodhub.components.PasswordTextFieldComponent
import com.iago.foodhub.components.UnderLinedTextComponent
import com.iago.foodhub.data.LoginUIEvent
import com.iago.foodhub.data.LoginViewModel
import com.iago.foodhub.navigation.FoodHubAppRouter
import com.iago.foodhub.navigation.Screen
import com.iago.foodhub.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
  
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    
    Surface(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(28.dp)
    ) {
      
      Column(
        modifier = Modifier
          .fillMaxSize()
      ) {
        
        NormalTextComponent(value = stringResource(id = R.string.login))
        HeadingTextComponent(value = stringResource(id = R.string.welcome))
        Spacer(modifier = Modifier.height(20.dp))
        
        MyTextFieldComponent(
          labelValue = stringResource(id = R.string.email),
          painterResource(id = R.drawable.email),
          onTextChanged = {
            loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
          },
          errorStatus = loginViewModel.loginUIState.value.emailError
        )
        
        PasswordTextFieldComponent(
          labelValue = stringResource(id = R.string.password),
          painterResource(id = R.drawable.lock),
          onTextChanged = {
            loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
          },
          errorStatus = loginViewModel.loginUIState.value.passwordError
        )
        
        Spacer(modifier = Modifier.height(40.dp))
        UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))
        
        Spacer(modifier = Modifier.height(40.dp))
        
        ButtonComponent(
          value = stringResource(id = R.string.login),
          onButtonClicked = {
            loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
          },
          isEnabled = loginViewModel.allValidationsPassed.value
        )
        
        Spacer(modifier = Modifier.height(20.dp))
        
        DividerTextComponent()
        
        ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
          FoodHubAppRouter.navigateTo(Screen.SignUpScreen)
        })
      }
    }
    
    if (loginViewModel.loginInProgress.value) {
      CircularProgressIndicator()
    }
  }
  
  
  SystemBackButtonHandler {
    FoodHubAppRouter.navigateTo(Screen.SignUpScreen)
  }
}

@Preview
@Composable
fun LoginScreenPreview() {
  LoginScreen()
}