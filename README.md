Краткая история.

Spotify ушел из России и я не смог снова зайти в аккаунт. На аккаунте остались плейлисты, которые мне стало жаль просто так оставлять. 
Решение нашлось в виде LastFM, который я подключил к спотику как только начал его слушать. Сложить два плюс два и мы получаем все мои плейлисты,
спрятанные в скробблах ласт фм. Благо ласт фм позволяет напрямую выкачать все скробблы, они же прослушивания.

Собственно здесь скрипт, который парсит скроблы и записывает их все в бд. Также есть еще скрипт, который делает главную задачу - поиск плейлистов во всех скроблах.
Принцип работы алгоритма следующий: перебрать все последовательные группы прослушиваний и найти дубликаты групп. Алгоритм не очень эффективный, но со списком
прослушиваний в 24 тыс. справился примерно секунд за 30. Никаких настроек для алгоритма не предустроено, при желании его можно подкорректировать и весьма вероятно,
значительно оптимизировать.

Наверное было бы лучше, если все было сделано на скриптовом языке типа Python, а не на Java, но на данный момент это единственный язык, которым я владею. 
Также здесь совершенно не требуется ни Spring, ни maven, но для меня это было самым быстрым способом все реализовать.
 
В конце концов скрипт запишет все полученные плейлисты в txt файл. В моем случае из входных 24 тыс. прослушиваний я получил 378 плейлистов, многие из которых просто
целые альбомы, также возможно некоторое количество дубликатов. Полностью свои плейлисты я не перебрал, если сильно интересно их послушать, то их можно найти [у меня
в Яндекс Музыке](https://music.yandex.ru/users/nufirdy/playlists)