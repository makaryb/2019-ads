# Алгоритмы и структуры данных
Задачи для курса "Алгоритмы и структуры данных" 2019 года
[курса](https://polis.mail.ru/curriculum/program/discipline/836/) в [Технополис](https://polis.mail.ru).

## Fork
[Форкните проект](https://help.github.com/articles/fork-a-repo/), склонируйте и добавьте `upstream`:
```
$ git clone git@github.com:<username>/2019-ads.git
Cloning into '2019-ads'...
...
$ git remote add upstream git@github.com:polis-mail-ru/2019-ads.git
$ git fetch upstream
From github.com:polis-mail-ru/2019-ads
 * [new branch]      master     -> upstream/master
```

## Схема работы
В общем случае часть задач будет с [e-olymp](https://www.e-olymp.com), и проверяться будет средствами этой системы.
Но также возможны и задачи, тесты на которые будут оформлены в нашем репозитории.

### Решения задач с e-olymp.com
Первым делом регистрируемся на [e-olymp](https://www.e-olymp.com).

Для каждого нового домашнего задания заводим новую ветку в своем репозитории.
Например, домашнему заданию после первой лекции будет соответствовать ветка `part1`.
Создаем ее в локальном репозитории
```
$ git checkout -b part1
``` 
Исходники решений добавляются в java-пакет `ru.mail.polis.ads.<partX>.<username>`, где `username` - логин на Github.
Решение каждой задачи - отдельный Java-класс в этом пакете. 
Можно воспользоваться классом `ru.mail.polis.ads.SolveTemplate`, в котором остается реализовать лишь метод `solve`.

После того, как решения будут доведены до рабочего состояния (все тесты будут проходить),
можно коммитить, пушить и создавать pull request в `polis-mail-ru/2019-ads`.
В самом PR либо в его описании, либо в комментариях к каждому классу-решению
нужно добавить ссылку на submission в e-olymp, где видно, что все решение прошло все тесты. 
Эти ссылки имеют вид "https://www.e-olymp.com/ru/submissions/5707028".

Все обсуждения решения происходят в рамках комментариев к PR
(в противном случае мы зафлудим общий чатик и запутаемся окончательно :))

### Решения задач с локальными тестами
Прогон тестов будет осуществляться системами [continuous integration](https://en.wikipedia.org/wiki/Continuous_integration), 
например, [TravisCI](https://travis-ci.org) и/или [CircleCI](https://circleci.com). 
Тесты в этих системах будут исполняться при созданни PR и при добавлении новых коммитов.
В итоге у PR должна появиться зеленая галочка, говорящая об успешном прохождении тестов.

## ДЗ 1.
Задачи с e-olymp.com
  * https://www.e-olymp.com/ru/problems/1 - проверим систему
  * https://www.e-olymp.com/ru/problems/1087 - динамика
  * https://www.e-olymp.com/ru/problems/1090 - динамика
  * https://www.e-olymp.com/ru/problems/1618 - динамика
  * https://www.e-olymp.com/ru/problems/6125 - очередь

За каждое полностью рабочее решение дается 2 балла (да, даже за первую задачу).  

## ДЗ 2.
Задачи с e-olymp.com
  * https://www.e-olymp.com/ru/problems/15 - динамика
  * https://www.e-olymp.com/ru/problems/262 - динамику
  * https://www.e-olymp.com/ru/problems/3837 - стек/очередь
  * https://www.e-olymp.com/ru/problems/5327 - скобочки со стеком
  * https://www.e-olymp.com/ru/problems/6124 - стек

За каждое полностью рабочее решение дается 2 балла.  

## ДЗ 3.
Задачи с e-olymp.com

Дэдлайн - 22.10
  * https://www.e-olymp.com/ru/problems/3738 - Простая сортировка
  * https://www.e-olymp.com/ru/problems/1462 - Хитрая сортировка
  * https://www.e-olymp.com/ru/problems/4741 - Сортировка пузырьком
  * https://www.e-olymp.com/ru/problems/4827 - k-тая порядковая статистика
  * https://www.e-olymp.com/ru/problems/4037 - Сортировка слиянием
  
В задачах нельзя использовать `Arrays.sort()`/`Collections.sort()`. 
На то они и задачи на сортировку, чтобы мы сами пописали эти сортировки.  
  
## ДЗ 4.
Задачи с e-olymp.com

Дэдлайн - 29.10
  * https://www.e-olymp.com/ru/problems/3737 - Куча ли?
  * https://www.e-olymp.com/ru/problems/4039 - Хипуй
  * https://www.e-olymp.com/ru/problems/4074 - Найти медиану 2
  * https://www.e-olymp.com/ru/problems/4261 - Количество инверсий
  * https://www.e-olymp.com/ru/problems/1457 - Станция "Сортировочная"
  * https://www.e-olymp.com/ru/problems/9016 - Бинарный поиск
  * https://www.e-olymp.com/ru/problems/5149 - Коровы - в стойла
    