package com.mamta.librarymanagment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mamta.librarymanagment.ui.theme.LibraryManagmentTheme

class SelectRoleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryManagmentTheme {
                // A surface container using the 'background' color from the theme
                //MainUI()
                val navController = rememberNavController()
                Scaffold(topBar = { RoleToolBar() }) { it ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(it)
                    ) {
                        SelectRole()
                    }

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleToolBar() {
    TopAppBar(
        title = { Text(text = "Select Role") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF03A9F4),
            titleContentColor = Color.White
        ),
        scrollBehavior = null
    )
}

@Composable
fun SelectRole() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(8.dp)
                .clickable {
                    context.startActivity(Intent(context, AdminLoginActivity::class.java))
                },
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(10.dp),
            border = BorderStroke(1.dp, Color.LightGray),

            ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.admin),
                    contentDescription = "Admin",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Admin",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Blue
                )
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(8.dp)
                .clickable {
                    context.startActivity(Intent(context, MemberLoginActivity::class.java))
                },
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(10.dp),
        )
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.group),
                    contentDescription = "Member",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = "Member",
                    color = Color.Blue,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

