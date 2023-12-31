# language: ru

    Функциональность: Избранные курсы
      @test1
      Сценарий: Клик на плитку выбранного курса
        Пусть Открыт браузер "chrome"
        * Открыта главная страница
        Если Кликнуть на плитку курса "Специализация Python"
        Тогда Проверяем название страницы выбранного курса "Специализация Python"

      @test2
      Сценарий: Клик на плитку самого раннего курса
        Пусть Открыт браузер "chrome"
        * Открыта главная страница
        Если Получаем название самого раннего курса
        Если Кликнуть на плитку самого раннего курса
        Тогда Откроется страница раннего курса

      @test3
      Сценарий: Клик на плитку самого позднего курса
        Пусть Открыт браузер "chrome"
        * Открыта главная страница
        Если Получаем название самого позднего курса
        Если Кликнуть на плитку самого позднего курса
        Тогда Откроется страница позднего курса
