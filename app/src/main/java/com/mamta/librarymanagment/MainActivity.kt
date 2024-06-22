package com.mamta.librarymanagment

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mamta.librarymanagment.ui.theme.LibraryManagmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryManagmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Composable
private fun HomePage() {

    val name by remember { mutableStateOf("Mamta") }
    val greeting by remember { mutableStateOf("Good Morning \uD83D\uDC4B") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.admin
                ),
                contentDescription = "ProfileLogo",
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .border(1.dp, color = Color.LightGray, CircleShape)
                    .padding(4.dp)

            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "$name", fontSize = 12.sp)
                Text(text = "$greeting", fontSize = 12.sp)

            }

            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notification")

        }//Row End

        Row {
            homeCard(image = painterResource(R.drawable.group), heading = "Hello")
        }

    }
}

@Composable
private fun homeCard(image: Painter, heading: String) {
    Card(colors = CardDefaults.cardColors(Color.LightGray)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = "$heading",
                modifier = Modifier
                    .size(80.dp)
                    .padding(3.dp)
            )
            Text(
                text =
                "$heading",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomePagePreview() {
    HomePage()
}
