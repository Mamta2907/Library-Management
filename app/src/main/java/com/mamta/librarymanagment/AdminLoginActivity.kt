package com.mamta.librarymanagment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mamta.librarymanagment.ui.theme.LibraryManagmentTheme

class AdminLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryManagmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdminLoginToolbar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminLoginToolbar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Admin Login", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF00BCD4),
                    titleContentColor = Color.White,
                    scrolledContainerColor = Color.LightGray
                )
            )
        }) { it ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            AdminLoginScreen()
        }
    }
}

@Composable
fun AdminLoginScreen() {

    val context = LocalContext.current
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Enter Your Email") },
            trailingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )

        Spacer(modifier = Modifier.size(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password"
                )
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter Your Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )

        Spacer(modifier = Modifier.size(18.dp))

        OutlinedButton(
            onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp, 0.dp, 50.dp, 0.dp),
            shape = RoundedCornerShape(10.dp),

            ) {
            Text(text = "Login")
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Check",
                modifier = Modifier
                    .size(30.dp)
                    .padding(8.dp)
            )

        }


    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun AdminLoginScreenPreview() {
    AdminLoginToolbar()
}