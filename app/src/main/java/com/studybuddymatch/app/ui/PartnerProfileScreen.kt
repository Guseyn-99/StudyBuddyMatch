package com.studybuddymatch.app.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.studybuddymatch.app.data.MockDataProvider

@Composable
fun PartnerProfileScreen(
    navController: NavController,
    userId: String
) {
    val context = LocalContext.current
    val user = MockDataProvider.users.find { it.id == userId }

    if (user == null) {
        // Если пользователь не найден, показываем ошибку и возвращаемся назад
        Toast.makeText(context, "Пользователь не найден", Toast.LENGTH_SHORT).show()
        navController.popBackStack()
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = user.name, style = MaterialTheme.typography.headlineMedium)
        Text(text = user.university, style = MaterialTheme.typography.titleMedium)
        Text(text = "Интересы: ${user.interests.joinToString()}")
        Text(text = "Предметы: ${user.subjects.joinToString()}")
        Text(text = "О себе: ${user.bio}")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("chat/${user.id}")
                // Позже здесь будет переход в чат или уведомление
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Отправить запрос")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Назад")
        }
    }
}