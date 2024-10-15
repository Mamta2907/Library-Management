package com.mamta.librarymanagment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
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
                    HomePage()
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

        Column() {
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

                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notification"
                )

            }//Row End

            Row(horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {

                homeCard(image = R.drawable.baseline_menu_book_24, heading = "Books")
                Spacer(modifier = Modifier.size(20.dp, 8.dp))

                homeCard(image = R.drawable.group, heading = "Members")

            }
            Spacer(modifier = Modifier.size(10.dp))

            Row( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                homeCard(image = R.drawable.baseline_menu_book_24, heading = "Issue Books")
                Spacer(modifier = Modifier.size(20.dp, 8.dp))

                homeCard(image = R.drawable.group, heading = "Return Books")

            }
            Spacer(modifier = Modifier.size(10.dp))
            Row {

                homeCard(image = R.drawable.baseline_menu_book_24, heading = "Over Due Books")
                Spacer(modifier = Modifier.size(20.dp, 8.dp))

                homeCard(image = R.drawable.group, heading = "Add Books")

            }

            Spacer(modifier = Modifier.size(10.dp))
            Row {

                homeCard(image = R.drawable.baseline_menu_book_24, heading = "Add Member")
                Spacer(modifier = Modifier.size(20.dp, 8.dp))

                //homeCard(image = R.drawable.group, heading = "Add Books")

            }

        }


    }
}

@Composable
private fun homeCard(image: Int, heading: String) {
    Card(colors = CardDefaults.cardColors(Color.White), border = BorderStroke(1.dp, color = Color.Black)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
               /* modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .weight(1f)*/
        ) {
            Image(
                painterResource(id = image),
                contentDescription = "$heading",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .size(50.dp)
                    .padding(3.dp),

                )

            Text(
                text = heading,
                color = Color.Magenta,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomePagePreview() {
    HomePage()
}
