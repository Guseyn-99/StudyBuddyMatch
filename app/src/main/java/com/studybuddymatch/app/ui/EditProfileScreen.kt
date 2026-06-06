package com.studybuddymatch.app.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.studybuddymatch.app.data.MockDataProvider

@Composable
fun EditProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val currentUser = MockDataProvider.currentUser

    var name by remember { mutableStateOf(currentUser.name) }
    var university by remember { mutableStateOf(currentUser.university) }
    var interestsText by remember { mutableStateOf(currentUser.interests.joinToString(", ")) }
    var subjectsText by remember { mutableStateOf(currentUser.subjects.joinToString(", ")) }
    var bio by remember { mutableStateOf(currentUser.bio) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Редактирование профиля", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = university,
            onValueChange = { university = it },
            label = { Text("Университет") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = interestsText,
            onValueChange = { interestsText = it },
            label = { Text("Интересы (через запятую)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = subjectsText,
            onValueChange = { subjectsText = it },
            label = { Text("Предметы (через запятую)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text("О себе") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val interests = interestsText.split(",").map { it.trim() }.filter { it.isNotEmpty() }
                val subjects = subjectsText.split(",").map { it.trim() }.filter { it.isNotEmpty() }
                MockDataProvider.updateCurrentUser(name, university, interests, subjects, bio)
                Toast.makeText(context, "Профиль обновлён", Toast.LENGTH_SHORT).show()
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить")
        }

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Отмена")
        }
    }
}