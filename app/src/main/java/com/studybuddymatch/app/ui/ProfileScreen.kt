package com.studybuddymatch.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.studybuddymatch.app.data.MockDataProvider

@Composable
fun ProfileScreen(navController: NavController) {
    val user = MockDataProvider.currentUser

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Мой профиль", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Имя: ${user.name}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Университет: ${user.university}")
        Text(text = "Интересы: ${user.interests.joinToString()}")
        Text(text = "Предметы: ${user.subjects.joinToString()}")
        Text(text = "О себе: ${user.bio}")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("edit_profile") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Редактировать профиль")
        }
    }
}