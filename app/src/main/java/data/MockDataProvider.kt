package com.studybuddymatch.app.data

import com.studybuddymatch.app.models.User

object MockDataProvider {
    // Список других пользователей (партнёров)
    val users = listOf(
        User(
            id = "1",
            name = "Анна Иванова",
            university = "МГУ",
            interests = listOf("Программирование", "Математика"),
            subjects = listOf("Котлин", "Алгоритмы"),
            bio = "Ищу напарника для подготовки к экзаменам"
        ),
        User(
            id = "2",
            name = "Дмитрий Петров",
            university = "СПбГУ",
            interests = listOf("ИИ", "Data Science"),
            subjects = listOf("Python", "Статистика"),
            bio = "Люблю решать сложные задачи"
        ),
        User(
            id = "3",
            name = "Елена Смирнова",
            university = "МГУ",
            interests = listOf("Мобильная разработка", "Дизайн"),
            subjects = listOf("Android", "UI/UX"),
            bio = "Создаю удобные интерфейсы"
        ),
        User(
            id = "4",
            name = "Алексей Козлов",
            university = "ВШЭ",
            interests = listOf("Спорт", "Экономика"),
            subjects = listOf("Микроэкономика", "Английский"),
            bio = "Готов учиться новому"
        )
    )

    // Текущий авторизованный пользователь (для демонстрации)
    var currentUser = User(
        id = "me",
        name = "Алексей",
        university = "МГУ",
        interests = listOf("Kotlin", "Android"),
        subjects = listOf("Разработка", "UI/UX"),
        bio = "Люблю учиться и помогать другим"
    )
        private set

    // Функция обновления данных текущего пользователя
    fun updateCurrentUser(
        name: String,
        university: String,
        interests: List<String>,
        subjects: List<String>,
        bio: String
    ) {
        currentUser = currentUser.copy(
            name = name,
            university = university,
            interests = interests,
            subjects = subjects,
            bio = bio
        )
    }
}