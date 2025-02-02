package com.example.roomdatabase.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.roomdatabase.R
import com.example.roomdatabase.data.entity.AppState
import com.example.roomdatabase.data.entity.Contact
import com.example.roomdatabase.data.entity.ContactViewModel
import com.example.roomdatabase.presentation.navigation.Routes

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenUI(
    state: AppState = AppState(),
    viewModel: ContactViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color(red = 137, blue = 41, green = 91),
                onClick = {
                    navController.navigate(Routes.AddEditScreen)
                }
            ) {
                Icon(Icons.Rounded.Add, contentDescription = "Add Contact")
            }
        }
    ) {
        it
        LazyColumn(
            modifier = Modifier
                .background(color = Color(red = 242, blue = 212, green = 227))
                .fillMaxSize()
                .padding(12.dp)
        ) {
            items(state.allContacts.size) {
                ContactItemUI(
                    contact = state.allContacts[it],
                    viewModel = viewModel,
                    navController = navController
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactItemUI(
    contact: Contact,
    viewModel: ContactViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

            },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(red = 200, green = 168, blue = 141)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = {
                        Toast.makeText(context, "Long Click to Update", Toast.LENGTH_SHORT).show()
                    },
                    onLongClick = {
                        viewModel.state.value.id.value = contact.id
                        viewModel.state.value.name.value = contact.name
                        viewModel.state.value.phoneNumber.value = contact.phoneNumber
                        viewModel.state.value.email.value = contact.email
                        viewModel.state.value.imageUri.value = contact.imageUri
                        navController.navigate(Routes.AddEditScreen)
                    }
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(if (contact.imageUri.isNotEmpty()) contact.imageUri else R.drawable.default_profile_pic)
                    .crossfade(true)
                    .build(),
                contentDescription = "Contact Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = contact.name,
                    fontSize = 20.sp,
                    color = Color(red = 137, blue = 41, green = 91)
                )
                Text(
                    text = contact.phoneNumber,
                    fontSize = 16.sp,
                    color = Color(red = 137, blue = 41, green = 91)
                )
                Text(
                    text = contact.email,
                    fontSize = 16.sp,
                    color = Color(red = 137, blue = 41, green = 91)
                )
            }

            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        viewModel.state.value.id.value = contact.id
                        viewModel.state.value.name.value = contact.name
                        viewModel.state.value.phoneNumber.value = contact.phoneNumber
                        viewModel.state.value.email.value = contact.email
                        viewModel.state.value.imageUri.value = contact.imageUri
                        viewModel.deleteContact()
                    },
                tint = Color(red = 137, blue = 41, green = 91)
            )
        }
    }
}
