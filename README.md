# Exchanger - Сервис обмена валют и сбора статистики по операциям обмена

## Описание
RESTful сервис для обмена валют и сбора статистики операций обмена. Для корректоного перевода по действительному курсу валют используется Exchange Rates Data API (https://apilayer.com/marketplace/exchangerates_data-api).
Стек: Spring Boot, Spring Data JPA, MySQL. 


## Запуск
Для запуска вам необходимо установить Docker, в терминале выполните команду `docker run -ti artemkhal/exchanger`

## Использование
Чтобы воспользоваться обменником необходимо выполнить запрос на адрес `http://localhost:8080/exchanger` с указанием параметров 
`user_id` - id пользователя,
`to` - название искомой валюты (например RUB),
`from` - название базовой валюты (например USD),
`amount` - сумма денег в базовой валюте

Для проверки работы использован Postman

В следующем примере переведем свой первый миллион фунтов стерлингов в белорусские рубли:
![Alt-текст](https://github.com/artemkhal/exchanger/blob/master/src/main/resources/images/exchanger.png?raw=true "Пример")

Для просмотра списка пользователей необходимо выполнить запрос `http://localhost:8080/stats/users`
![Alt-текст](https://raw.githubusercontent.com/artemkhal/exchanger/master/src/main/resources/images/stats%3Ausers.png "Пример")

`http://localhost:8080/stats/users/<user_id>` - просмотр переводов конкретного пользователя, `<user_id>` меняем на id интересующего пользователя
![Alt-текст](https://raw.githubusercontent.com/artemkhal/exchanger/master/src/main/resources/images/stats%3Ausers.png "Пример")

Просмотр всех переводов:
![Alt-текст](https://raw.githubusercontent.com/artemkhal/exchanger/master/src/main/resources/images/stats%3Aexchanges.png "Пример")

Можно посмотреть только те переводы, сумма которых в базовой валюте Вас интересует. Для этого необходимо указать в параметрах сумму и наименование базовой валюты
![Alt-текст](https://raw.githubusercontent.com/artemkhal/exchanger/master/src/main/resources/images/stats%3Aexchanges%3Fparams.png "Пример")
