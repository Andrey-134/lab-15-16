1. Что такое NavController и для чего он используется?
NavController — это центральный объект в навигационной системе Android Jetpack Compose, который управляет перемещением между экранами.

Роль NavController:

Хранит историю переходов (back stack)

Позволяет перемещаться на новые экраны (navigate())

Возвращаться на предыдущие экраны (popBackStack())

Управлять состоянием навигации

Почему rememberNavController()? Эта функция создаёт и сохраняет NavController при перекомпозиции (перерисовке интерфейса). Без неё контроллер бы каждый раз создавался заново, теряя историю переходов.

2. Как передать параметр в маршрут навигации?
Процесс:

Определение маршрута с параметром:

kotlin
sealed class Screen(val route: String) {
    object Profile : Screen("profile/{userId}")
}
Передача параметра при навигации:

kotlin
navController.navigate("profile/123")
Извлечение параметра в NavHost:

kotlin
composable("profile/{userId}") { backStackEntry ->
    val userId = backStackEntry.arguments?.getString("userId")
    ProfileScreen(userId = userId)
}
Разница между обязательными и опциональными параметрами:

Обязательные: "profile/{userId}" — параметр всегда должен присутствовать

Опциональные: "profile?userId={userId}" — параметр может быть null

3. Зачем использовать sealed class для маршрутов?
Преимущества sealed class перед строками:

Type safety (безопасность типов) — компилятор проверяет существование маршрута

Автодополнение в IDE

Единое место для всех маршрутов

Пример ошибки, которую sealed class предотвращает:

kotlin
// Без sealed class (ошибка только во время выполнения)
navController.navigate("profil")  // опечатка → краш

// С sealed class (ошибка на этапе компиляции)
navController.navigate(Screen.Profil)  // нет такого объекта → не скомпилируется
4. Что такое Back Stack и как им управлять?
Back Stack — это стек экранов, который хранит историю навигации.

Схема для Home → Profile → Settings:

text
Settings    ← верхушка стека
Profile
Home        ← дно стека
Что произойдёт при popBackStack() на экране Settings?

Settings удаляется из стека

Пользователь возвращается на экран Profile

5. Как работает startDestination в NavHost?
startDestination определяет, какой экран будет показан первым при запуске приложения.

Можно ли изменить startDestination динамически?
Да, можно. Например, в зависимости от того, авторизован ли пользователь:

kotlin
val startDestination = if (isLoggedIn) Screen.Home.route else Screen.Login.route
NavHost(startDestination = startDestination, ...)
6. Что произойдёт, если навигировать на несуществующий маршрут?
Как NavController обрабатывает неизвестные маршруты?

Приложение крашнется с ошибкой IllegalArgumentException

Ошибка будет содержать сообщение о том, что маршрут не найден

Как обработать такую ситуацию?

Использовать sealed class для маршрутов (ошибка на этапе компиляции)

Добавить обработчик для неизвестных маршрутов в NavHost

7. Зачем нужен параметр launchSingleTop?
launchSingleTop = true предотвращает создание дублирующихся экранов.

Проблема без launchSingleTop:

kotlin
// Пользователь нажимает на уведомление о новом сообщении
// → создаётся новый экран чата поверх старого
// → в back stack два одинаковых экрана чата
