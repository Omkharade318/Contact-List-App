package com.example.roomdatabase.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Add Contact")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Add Contact",
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = CircleShape)
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
                }
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
                }
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
                }
            )

            Button(
                onClick = {
                    onEvent.invoke()
                    navController.navigateUp()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 62.dp)
            ) {
                Text("Save")
            }
        }
    }
}