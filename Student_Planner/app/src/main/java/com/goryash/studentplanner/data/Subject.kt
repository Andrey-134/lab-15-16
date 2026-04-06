package com.goryash.studentplanner.data

data class Subject(
    val id: String,
    val name: String,
    val professor: String,
    val credits: Int,
    val currentGrade: String,
    val description: String
)
val sampleSubjects = listOf(
    Subject(
        id = "1",
        name = "Разработка мобильных приложений",
        professor = "Леонтьев Д.А.",
        credits = 91,
        currentGrade = "Отлично",
        description = "Разработка нативных Android-приложений с использованием Kotlin и современных компонентов Jetpack Compose. Изучение архитектурных паттернов MVVM, работы с локальными базами данных и сетевыми API."
    ),
    Subject(
id = "2",
name = "ИСРПО",
professor = "Леонтьев Д.А.",
credits = 91,
currentGrade = "Отлично",
description = "Разработка нативных Android-приложений с использованием Kotlin и современных компонентов Jetpack Compose. Изучение архитектурных паттернов MVVM, работы с локальными базами данных и сетевыми API."
),
    Subject(
        id = "3",
        name = "Системное программирование",
        professor = "Тимур Ильич",
        credits = 91,
        currentGrade = "Хорошо",
        description = "Изучаем раст "
    ),
    Subject(
        id = "4",
        name = "Иностранный язык",
        professor = "Пенькова",
        credits = 91,
        currentGrade = "Отлично",
        description = "Изучаем новый для нас язык нужен для программирования "
    ),
    Subject(
        id = "5",
        name = "Разработка программных модулей",
        professor = "Донскова Д.А.",
        credits = 91,
        currentGrade = "Отлично",
        description = "Изучаем принципы отдельных фунукц блоков"
    ),
    Subject(
        id = "6",
        name = "ОКФС",
        professor = "Ушакова",
        credits = 91,
        currentGrade = "Хорошо",
        description = "Изучаем принципы построения и работы инф систем"
    ),
)

