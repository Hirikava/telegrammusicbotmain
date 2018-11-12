# SonaMusicBot
Версия: 1.0

Авторы: Александр Да'ас и Артем Гафетинов

## Описание
Сделать бота для Телеграмма: Бот умеет принимать запрос и по запросу ищет
первое видео на YouTube и отправляет аудио-трек из него.

## Доработки:
1. 1. Стилестические косяки УБРАТЬ. В греппе лежит xml, загрузить в ideaSettings.CodeStyle
    2. Методы с маленькой буквы
2. Отправку пользователю сделать синхронной (handle заканчивается после отправки)
3. Вынести класс сендер и хранить в нём экземпляр бота. Реализовать ISender.
4. Вывод stackTrace-ов для всех исключений
5. Отвязать RunableHandler от YouTubeAudioLoadHandler
6. Декомпозировать YouTubeVideoLoader.


## Новая задача
Реализовать процесс запускающийся по расписанию опрос ютуба, топ 5 композиций на выбранную тематику.
Пользователь может подписаться и отписаться от некоторых тематик
Если он подписан после опроса ютуба отправлять ссылки на заданную тематику
Настройки подписок хранить в txt(лучше json) 
Создать модели при тестировании, не завязывая тестирование на сторонние сервисы.
Framework Mockito посмотреть что такое.
Dependency injection посмотреть что такое.
Больше тестов ! 