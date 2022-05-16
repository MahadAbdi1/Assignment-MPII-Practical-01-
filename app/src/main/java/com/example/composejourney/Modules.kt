package com.example.composejourney

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composejourney.ui.theme.ComposeJourneyTheme
import kotlin.system.exitProcess

class Modules : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(

                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column() {
                    Text(text =
                                 " ICT Electives 3" + " \n Practical>>>> Semester One subject " +
                                "\n\n Information Systems 3 " + "\n Practical>>>> full year Year subject " +
                                  "\n\n Project Presentation 3 " + "\n Theory>>>>  Semester One subject "+
                                         "\n\n Project 3 " + "\n Practical>>>>  full year subject " +
                                    "\n\n Applications Development Theory 3 " + "\n Theory>>> full Year subject " +
                                     " \n\n Applications Development Practice 3" +"\n Practical>>>> full Year subject"+
                    "\n\n Professional Practice 3 " + "\n Theory >>>> Semester One subject" +
                                         "\n\n Project Management 3 " + "\n Theory>>>> Semester One subject",
                        fontSize = 18.sp, fontWeight = FontWeight.Bold
                    )
                    Column(
                        modifier = Modifier
//                          .fillMaxWidth()
//                            .fillMaxHeight()
                        .padding(all = 30.dp),
                        verticalArrangement = Arrangement.Bottom,
                       horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        val context = LocalContext.current
                        Button(onClick = {
                            val navigate = Intent(this@Modules, StartActivity::class.java)
                            startActivity(navigate)
                        }) { Text(
                                text = "Back ", fontSize = 18.sp,
                                 textAlign = TextAlign.Right
                            )

                        }
                    }

                }

            }
            //  warning AlertDialog
            Column(

                modifier = Modifier
                    .padding(18.dp),
                        verticalArrangement = Arrangement.Bottom,
                     horizontalAlignment = Alignment.CenterHorizontally

                )
            {
                val openDialog = remember { mutableStateOf(false)  }
                val activity = (LocalContext.current as? Activity)

                Button(onClick = {
                    openDialog.value = true
                      })
                { Text("Goodbye")
                }
                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = {
                            openDialog.value = false },
                        text = { Text("leaving now?")
                        },
                        confirmButton = {
                            Button(onClick = { openDialog.value = false
                                }) { Text("No")
                            }
                        },
                        dismissButton ={
                            Button(onClick = { openDialog.value = false
                                    //activity?.finish()
                                exitProcess(0)
                            }) { Text(text = "Yes")
                            }

                        }

                    )
                }
            }


            } // setContent


        } // onCreate
    } // modules


