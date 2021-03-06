package com.example.composejourney
/*
* author : Mahad Hassan
* student number(219122822)
* */

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color.red
import android.graphics.Paint
import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontSynthesis.Companion.Style
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejourney.ui.theme.ComposeJourneyTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Welcome()
            CustomAlet()

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement=Arrangement.Bottom
            ) {
              Button(onClick = {
                  val navigate = Intent(this@MainActivity, StartActivity::class.java)
                  startActivity(navigate)
               }) {
                  Text(text = "Start journey", fontSize = 18.sp, )
              }

            }


        } // set content
    }
}

@Preview
@Composable

fun Welcome() {
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(all = 30.dp),
        verticalArrangement = Arrangement.Top,

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Welcome to My Jetpack Compose Journey!",
            style = MaterialTheme.typography.h5,


        )
        //CustomAlet(content = "Info", icon = Icons.Outlined.Menu)
       // Text(text="Info", fontSize = 18.sp)


        // i replaced "menu" to "info" text from practical one, nothing else changes from the code
    }


} // welcome text

// dailog alert
@Composable
fun CustomAlet()
{
    val openDialog=remember{mutableStateOf(false)}
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement=Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally
    )
    {
        Button(onClick = { openDialog.value = true },
            colors= ButtonDefaults.buttonColors())
        {
            Icon(imageVector = Icons.Filled.Info,
                contentDescription = "",
            )

            Text(text="Info",style= TextStyle(Color.White), fontSize = 18.sp)
        }

    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = {
                Text(text = "Alert Dialog",
                    fontFamily = androidx.compose.ui.text.font.FontFamily.Serif, fontSize = 16.sp)
            },
            text = {
                Text(text =
                "i was very interesting to learn mobile programming since last year ,"  +
                        "\n after i completed mobile programming 1 i had no hesitation to start mobile programming 2 " +
                        "\n and what makes so interesting is that we using jetpack compose which is  interesting to learn  and easier then xml that i did last year", fontSize = 18.sp)
            },
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value=false
                }){
                    Text(text = "Close")
                }

            },
        )
    }
}


