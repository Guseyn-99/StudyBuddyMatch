package com.studybuddymatch.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF7B2FF7),
            Color(0xFFF107A3)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "👋 Добро пожаловать!",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )

        Text(
            text = "Найдите идеального учебного партнёра и достигайте целей вместе.",
            color = Color.White.copy(alpha = 0.9f)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text("👨‍🎓 Студентов")
                Text(
                    "4",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text("🤝 Совпадений")
                Text(
                    "2",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text("💬 Сообщений сегодня")
                Text(
                    "7",
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("🔍 Найти партнёра")
        }
    }
}