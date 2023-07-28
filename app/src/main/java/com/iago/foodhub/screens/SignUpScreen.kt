package com.iago.foodhub.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iago.foodhub.R
import com.iago.foodhub.components.ButtonComponent
import com.iago.foodhub.components.CheckboxComponent
import com.iago.foodhub.components.ClickableLoginTextComponent
import com.iago.foodhub.components.DividerTextComponent
import com.iago.foodhub.components.HeadingTextComponent
import com.iago.foodhub.components.MyTextFieldComponent
import com.iago.foodhub.components.NormalTextComponent
import com.iago.foodhub.components.PasswordTextFieldComponent
import com.iago.foodhub.data.LoginViewModel
import com.iago.foodhub.data.UIEvent
import com.iago.foodhub.navigation.FoodHubAppRouter
import com.iago.foodhub.navigation.Screen
import com.iago.foodhub.navigation.SystemBackButtonHandler

@Composable
fun SignUpScreen(loginViewModel: LoginViewModel = viewModel()) {
  
  Surface(
    color = Color.White,
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)
      .padding(28.dp)
  ) {
    Column(modifier = Modifier.fillMaxSize()) {
      NormalTextComponent(value = stringResource(id = R.string.hello))
      HeadingTextComponent(value = stringResource(id = R.string.create_account))
      
      Spacer(modifier = Modifier.height(20.dp))
      
      MyTextFieldComponent(
        labelValue = stringResource(id = R.string.first_name),
        painterResource = painterResource(id = R.drawable.profile),
        onTextSelected = {
          loginViewModel.onEvent(UIEvent.FirstNameChanged(it))
        }
      )
      MyTextFieldComponent(
        labelValue = stringResource(id = R.string.last_name),
        painterResource = painterResource(id = R.drawable.profile),
        onTextSelected = {
          loginViewModel.onEvent(UIEvent.LastNameChanged(it))
        }
      )
      MyTextFieldComponent(
        labelValue = stringResource(id = R.string.email),
        painterResource = painterResource(id = R.drawable.email),
        onTextSelected = {
          loginViewModel.onEvent(UIEvent.EmailChanged(it))
        }
      )
      PasswordTextFieldComponent(
        labelValue = stringResource(id = R.string.password),
        painterResource = painterResource(id = R.drawable.lock),
        onTextSelected = {
          loginViewModel.onEvent(UIEvent.PasswordChanged(it))
        }
      )
      CheckboxComponent(
        value = stringResource(id = R.string.terms_and_conditions),
        onTextSelected = {
          FoodHubAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
        })
      
      Spacer(modifier = Modifier.height(40.dp))
      
      ButtonComponent(value = stringResource(id = R.string.register), onButtonClicked = {
        loginViewModel.onEvent(UIEvent.RegisterButtonClicked)
      })
      
      Spacer(modifier = Modifier.height(20.dp))
      
      DividerTextComponent()
      
      ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
        FoodHubAppRouter.navigateTo(Screen.LoginScreen)
      })
    }
    
    SystemBackButtonHandler {
      FoodHubAppRouter.navigateTo(Screen.SignUpScreen)
    }
  }
}

@Preview
@Composable
fun DefaultPreviewSignUpScreen() {
  SignUpScreen()
}