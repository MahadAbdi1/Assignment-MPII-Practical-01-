package com.example.composejourney

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composejourney.ui.theme.ComposeJourneyTheme

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxSize(),

//               .background(color = androidx.compose.ui.graphics.Color.LightGray)
//                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,


                ) {
                Text(
                    text = "Full Name: Mahad Hassan " ,
                    fontWeight = FontWeight.Bold,style = TextStyle(Color.LightGray),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth()
                )
                Text(
                    text = " Course : Application  Development",
                    fontWeight = FontWeight.Bold,style = TextStyle(Color.LightGray),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxWidth()
                )
                Text(
                    text = " Department : Information Technology",
                    fontWeight = FontWeight.Bold,style = TextStyle(Color.LightGray),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth()

                )
                Text(
                    text = "Student Number:219122822",
                    fontWeight = FontWeight.Bold,style = TextStyle(Color.LightGray),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxWidth()

                )

                val context = LocalContext.current
                // dummy button
                TextButton(onClick = {
                    Toast.makeText(context, "mobile programming2", Toast.LENGTH_SHORT).show()
                }) {
                    Text("  current modules  ", fontSize = 18.sp, style = TextStyle.Default)
                    // Text(text = "Current Modules", style = TextStyle(Color.White))
                }
                // back to welcome screen button
                Button(onClick = {
                    val navigate = Intent(this@StartActivity, MainActivity::class.java)
                    startActivity(navigate)
                }) {
                    Text(
                        text = "Back ", fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }


        }


    }
}

