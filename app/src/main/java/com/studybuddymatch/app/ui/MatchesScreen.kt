package com.studybuddymatch.app.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.studybuddymatch.app.data.MockDataProvider

@Composable
fun MatchesScreen(navController: NavController) {
    val context = LocalContext.current
    val users = MockDataProvider.users

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(users) { user ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("partner_profile/${user.id}")
                    }
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = user.name, style = MaterialTheme.typography.titleLarge)
                    Text(text = user.university, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Предметы: ${user.subjects.joinToString()}", style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            Toast.makeText(context, "Запрос отправлен ${user.name}", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text("Connect")
                    }
                }
            }
        }
    }
}