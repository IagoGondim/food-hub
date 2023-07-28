package com.iago.foodhub.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iago.foodhub.R
import com.iago.foodhub.ui.theme.BgColor
import com.iago.foodhub.ui.theme.GrayColor
import com.iago.foodhub.ui.theme.Primary
import com.iago.foodhub.ui.theme.TextColor
import com.iago.foodhub.ui.theme.componentsShapes

@Composable
fun NormalTextComponent(value: String) {
  Text(
    text = value,
    modifier = Modifier
      .fillMaxWidth()
      .heightIn(min = 40.dp),
    style = TextStyle(
      fontSize = 24.sp,
      fontWeight = FontWeight.Normal,
      fontStyle = FontStyle.Normal
    ),
    color = colorResource(id = R.color.colorText),
    textAlign = TextAlign.Center
  )
}

@Composable
fun HeadingTextComponent(value: String) {
  Text(
    text = value,
    modifier = Modifier
      .fillMaxWidth()
      .heightIn(),
    style = TextStyle(
      fontSize = 30.sp,
      fontWeight = FontWeight.Bold,
      fontStyle = FontStyle.Normal
    ),
    color = colorResource(id = R.color.colorText),
    textAlign = TextAlign.Center
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(labelValue: String, painterResource: Painter) {
  
  val textValue = remember {
    mutableStateOf("")
  }
  
  OutlinedTextField(
    modifier = Modifier
      .fillMaxWidth()
      .clip(componentsShapes.small),
    label = { Text(text = labelValue) },
    colors = TextFieldDefaults.outlinedTextFieldColors(
      focusedBorderColor = Primary,
      focusedLabelColor = Primary,
      cursorColor = Primary,
      containerColor = BgColor
    ),
    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    value = textValue.value,
    singleLine = true,
    maxLines = 1,
    onValueChange = {
      textValue.value = it
    },
    leadingIcon = {
      Icon(painter = painterResource, contentDescription = "")
    },
    
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(labelValue: String, painterResource: Painter) {
  
  val localFocusManager = LocalFocusManager.current
  
  val password = remember {
    mutableStateOf("")
  }
  
  val passwordVisible = remember {
    mutableStateOf(false)
  }
  
  OutlinedTextField(
    modifier = Modifier
      .fillMaxWidth()
      .clip(componentsShapes.small),
    label = { Text(text = labelValue) },
    colors = TextFieldDefaults.outlinedTextFieldColors(
      focusedBorderColor = Primary,
      focusedLabelColor = Primary,
      cursorColor = Primary,
      containerColor = BgColor
    ),
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.Password,
      imeAction = ImeAction.Done
    ),
    singleLine = true,
    keyboardActions = KeyboardActions {
      localFocusManager.clearFocus()
    },
    maxLines = 1,
    value = password.value,
    onValueChange = {
      password.value = it
    },
    leadingIcon = {
      Icon(painter = painterResource, contentDescription = "")
    },
    trailingIcon = {
      val iconImage = if (passwordVisible.value) {
        Icons.Filled.Visibility
      } else {
        Icons.Filled.VisibilityOff
      }
      
      val description = if (passwordVisible.value) {
        stringResource(id = R.string.hide_password)
      } else {
        stringResource(id = R.string.show_password)
      }
      
      IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
        
        Icon(imageVector = iconImage, contentDescription = description)
        
      }
    },
    visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
  )
}

@Composable
fun CheckboxComponent(value: String, onTextSelected: (String) -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .heightIn(56.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    
    val checkedState = remember {
      mutableStateOf(false)
    }
    Checkbox(checked = checkedState.value,
      onCheckedChange = {
        checkedState.value != checkedState.value
      })
    
    ClickableTextComponent(value = value, onTextSelected)
    
  }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
  val initialText = "By continuing you accept our "
  val privacyPolicyText = "Privacy Policy "
  val andText = "and "
  val termsAndConditionsText = "Term of Use"
  
  val annotatedString = buildAnnotatedString {
    append(initialText)
    withStyle(style = SpanStyle(color = Primary)) {
      pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
      append(privacyPolicyText)
    }
    append(andText)
    withStyle(style = SpanStyle(color = Primary)) {
      pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
      append(termsAndConditionsText)
    }
  }
  
  ClickableText(text = annotatedString, onClick = { offset ->
    
    annotatedString.getStringAnnotations(offset, offset)
      .firstOrNull()?.also { span ->
        Log.d("ClickableTextComponent", "{${span.item}}")
        
        if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)) {
          onTextSelected(span.item)
        }
        
        
      }
    
  })
}

@Composable
fun ButtonComponent(value: String) {
  Button(
    onClick = { },
    modifier = Modifier
      .fillMaxWidth()
      .heightIn(48.dp),
    contentPadding = PaddingValues(),
    colors = ButtonDefaults.buttonColors(Color.Transparent)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp)
        .shadow(16.dp, shape = RoundedCornerShape(50.dp))
        .background(
          color = (Primary),
          shape = RoundedCornerShape(50.dp)
        ),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = value,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
      )
      
    }
  }
}

@Composable
fun DividerTextComponent() {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Divider(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
      color = GrayColor,
      thickness = 1.dp
    )
    
    Text(
      modifier = Modifier.padding(8.dp),
      text = stringResource(id = R.string.or),
      fontSize = 14.sp,
      color = TextColor
    )
    
    Divider(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f),
      color = GrayColor,
      thickness = 1.dp
    )
  }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
  val initialText =
    if (tryingToLogin) "Already have an account? " else "Don’t have an account yet? "
  val loginText = if (tryingToLogin) "Login" else "Register"
  
  val annotatedString = buildAnnotatedString {
    append(initialText)
    withStyle(style = SpanStyle(color = Primary)) {
      pushStringAnnotation(tag = loginText, annotation = loginText)
      append(loginText)
    }
  }
  
  ClickableText(
    modifier = Modifier
      .fillMaxWidth()
      .heightIn(min = 40.dp),
    style = TextStyle(
      fontSize = 21.sp,
      fontWeight = FontWeight.Normal,
      fontStyle = FontStyle.Normal,
      textAlign = TextAlign.Center
    ),
    text = annotatedString,
    onClick = { offset ->
      
      annotatedString.getStringAnnotations(offset, offset)
        .firstOrNull()?.also { span ->
          Log.d("ClickableTextComponent", "{${span.item}}")
          
          if (span.item == loginText) {
            onTextSelected(span.item)
          }
        }
      
    },
  )
}

@Composable
fun UnderLinedTextComponent(value: String) {
  Text(
    text = value,
    modifier = Modifier
      .fillMaxWidth()
      .heightIn(min = 40.dp),
    style = TextStyle(
      fontSize = 18.sp,
      fontWeight = FontWeight.Normal,
      fontStyle = FontStyle.Normal
    ),
    color = colorResource(id = R.color.colorGray),
    textAlign = TextAlign.Center,
    textDecoration = TextDecoration.Underline
  )
}






















