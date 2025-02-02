package com.example.roomdatabase.presentation.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.roomdatabase.R
import com.example.roomdatabase.data.entity.AppState

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddEditScreenUI(
    onEvent: () -> Unit = {},
    state: AppState = AppState(),
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            state.imageUri.value = it.toString()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color(red = 209, green = 155, blue= 107)),
                title = {
                    Text(
                        text = "Add Contact",
                        fontWeight = FontWeight.Bold,
                        color = Color(red = 137, blue = 41, green = 91)
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .background(color =  Color(red = 242, blue = 212, green = 227))
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(if (state.imageUri.value.isNotEmpty()) state.imageUri.value else R.drawable.default_profile_pic)
                    .crossfade(true)
                    .build(),
                contentDescription = "Contact Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .clickable {
                        imagePicker.launch("image/*")
                    }
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.name.value,
                onValueChange = {
                    state.name.value = it
                },
                placeholder = {
                    Text("Enter Name")
                },
                label = {
                    Text("Name")
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Color(red = 228, green = 180, blue = 114),
                    focusedTextColor = Color(red = 137, blue = 41, green = 91),
                    unfocusedTextColor = Color(red = 209, green = 155, blue= 107),
                    cursorColor = Color(red = 209, green = 155, blue= 107),
                    unfocusedLabelColor = Color(red = 228, green = 180, blue = 114),
                    focusedBorderColor = Color(red = 137, blue = 41, green = 91),
                    unfocusedBorderColor = Color(red = 137, blue = 41, green = 91)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.phoneNumber.value,
                onValueChange = {
                    state.phoneNumber.value = it
                },
                placeholder = {
                    Text("Enter Phone Number")
                },
                label = {
                    Text("Phone Number")
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Color(red = 228, green = 180, blue = 114),
                    focusedTextColor = Color(red = 137, blue = 41, green = 91),
                    unfocusedTextColor = Color(red = 209, green = 155, blue= 107),
                    cursorColor = Color(red = 209, green = 155, blue= 107),
                    unfocusedLabelColor = Color(red = 228, green = 180, blue = 114),
                    focusedBorderColor = Color(red = 137, blue = 41, green = 91),
                    unfocusedBorderColor = Color(red = 137, blue = 41, green = 91)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.email.value,
                onValueChange = {
                    state.email.value = it
                },
                placeholder = {
                    Text("Enter Email")
                },
                label = {
                    Text("Email")
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Color(red = 228, green = 180, blue = 114),
                    focusedTextColor = Color(red = 137, blue = 41, green = 91),
                    unfocusedTextColor = Color(red = 209, green = 155, blue= 107),
                    cursorColor = Color(red = 209, green = 155, blue= 107),
                    unfocusedLabelColor = Color(red = 228, green = 180, blue = 114),
                    focusedBorderColor = Color(red = 137, blue = 41, green = 91),
                    unfocusedBorderColor = Color(red = 137, blue = 41, green = 91)
                )
            )

            Button(
                onClick = {
                    onEvent.invoke()
                    navController.navigateUp()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 62.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(red = 137, blue = 41, green = 91))
            ) {
                Text(
                    text = "Save",
                    color = Color.White
                )
            }
        }
    }
}