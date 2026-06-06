package com.studybuddymatch.app.data

import com.studybuddymatch.app.models.ChatMessage
import java.util.UUID

object ChatRepository {
    // Храним все сообщения в списке
    private val messages = mutableListOf<ChatMessage>()

    // Получить сообщения между двумя пользователями
    fun getMessages(userId1: String, userId2: String): List<ChatMessage> {
        return messages.filter {
            (it.fromUserId == userId1 && it.toUserId == userId2) ||
                    (it.fromUserId == userId2 && it.toUserId == userId1)
        }.sortedBy { it.timestamp }
    }

    // Отправить сообщение
    fun sendMessage(fromUserId: String, toUserId: String, text: String) {
        val message = ChatMessage(
            id = UUID.randomUUID().toString(),
            fromUserId = fromUserId,
            toUserId = toUserId,
            text = text
        )
        messages.add(message)
    }
}