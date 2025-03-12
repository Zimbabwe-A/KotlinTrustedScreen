package com.example.training_vers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrustedScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrustedScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 40.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            "Доверенные устройства",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                            )
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        // Обработка нажатия "Назад"
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                },

                )
        }
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            val devices = listOf(
                PhoneModel(
                    namePhone = "IPhone 13",
                    timeSign = "Текущее устройство",
                    osVersion = "iOS 14.3"
                ),
                PhoneModel(
                    namePhone = "iPhone 14 Pro",
                    timeSign = "17.02.2024, 16:00",
                    osVersion = "iOS 17.3.1"
                ),
                PhoneModel(
                    namePhone = "Redmi Note",
                    timeSign = "16.02.2024, 21:45",
                    osVersion = "Android 14"
                ),
            )

            itemsIndexed(devices) {_, item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .padding(all = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.phone),
                            contentDescription = "Phone",
                            modifier = Modifier.size(30.dp),
                        )
                        Column (
                            modifier = Modifier.padding(start = 20.dp)
                        ){
                            Text(
                                text = item.namePhone,
                                style = TextStyle(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 16.sp,
                                )
                            )
                            Text(
                                text = item.timeSign,
                                style = TextStyle(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            )
                        }
                        Spacer(
                            modifier = Modifier.width(140.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = item.osVersion,
                                maxLines = 1,
                                style = TextStyle(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 16.sp,
                                    color = Color.Gray
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground =  true
)
@Composable
fun PreviewTrustedDevicesScreen() {
    TrustedScreen()
}

data class PhoneModel(
    val namePhone: String,
    val timeSign: String,
    val osVersion: String,
)



