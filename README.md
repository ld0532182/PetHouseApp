# PetHouseApp
Приложение было создано с целью отработки SQL запросов, работы с несколькими таблицами и JDBC API.

Взаимодействие с пользователем происходит с помощью окон.

Предлагается выбрать животных из sql таблицы, которая обновляется при запуске приложения. На выбор пользователю дается два варианта:

1. Настроить предпочтения по собственному желанию, животное выбирается по совпадению вида и одного из трех вариантов: цвет, пол, размер.
2. Добавить сразу несколько пользователей из файла и найти совпадения с имеющимися животными из списка.

После того, как найдутся совпадения, пользователь и животное изымаются из таблицы.

Для работы используется MySQL, JDBC и JavaFX. 

Часть настроек находится в properties файле, там указаны параметры соеднинения с SQL сервером и названия таблиц.



