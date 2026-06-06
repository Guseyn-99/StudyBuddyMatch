package com.studybuddymatch.app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.studybuddymatch.app.data.ChatRepository
import com.studybuddymatch.app.data.MockDataProvider

@Composable
fun ChatScreen(navController: NavController, partnerId: String? = null) {
    val context = LocalContext.current
    val chatPartnerId = partnerId ?: MockDataProvider.users.firstOrNull()?.id ?: ""
    val currentUserId = "me"

    var messageText by remember { mutableStateOf("") }
    // Используем mutableStateListOf для автоматического обновления UI
    val messages = remember { mutableStateListOf<com.studybuddymatch.app.models.ChatMessage>() }

    // Загружаем сообщения при первом запуске
    LaunchedEffect(chatPartnerId) {
        messages.clear()
        messages.addAll(ChatRepository.getMessages(currentUserId, chatPartnerId))
    }

    val chatPartner = MockDataProvider.users.find { it.id == chatPartnerId }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Чат с ${chatPartner?.name ?: "пользователем"}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider()

        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(messages) { message ->
                val isMine = message.fromUserId == currentUserId
                Card(
                    modifier = Modifier.fillMaxWidth().padding(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isMine) MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Text(text = message.text, modifier = Modifier.padding(8.dp))
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it },
                label = { Text("Сообщение") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (messageText.isNotBlank()) {
                        ChatRepository.sendMessage(currentUserId, chatPartnerId, messageText)
                        // Добавляем новое сообщение в список вручную
                        val newMessage = com.studybuddymatch.app.models.ChatMessage(
                            id = java.util.UUID.randomUUID().toString(),
                            fromUserId = currentUserId,
                            toUserId = chatPartnerId,
                            text = messageText
                        )
                        messages.add(newMessage)
                        messageText = ""
                    }
                }
            ) {
                Text("Отправить")
            }
        }
    }
}