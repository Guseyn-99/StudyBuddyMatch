package com.studybuddymatch.app.models

data class ChatMessage(
    val id: String,
    val fromUserId: String,
    val toUserId: String,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)