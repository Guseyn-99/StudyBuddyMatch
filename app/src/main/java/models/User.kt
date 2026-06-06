package com.studybuddymatch.app.models

data class User(
    val id: String,
    val name: String,
    val university: String,
    val interests: List<String>,
    val subjects: List<String>,
    val bio: String = ""
)