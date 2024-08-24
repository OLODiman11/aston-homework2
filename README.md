# Aston Домашнее задание 2
Практика использования Stream API в Java. 
### Что нового узнал:
- Чтобы отсортировать объекты по полю можно использовать конструкцию `sorted(Comparator.comparing(Transaction::getValue))`;
- Чтобы объединить список строк можно использовать `collect(Collectors.joining(", "))`;
- Чтобы получить сумму целых чисел нужно перевести поток в `IntStream` с помощью `mapToInt()`. Тогда станет доступен метод `sum()`;
- Методы `min()` и `max()` возвращают `Optional<T>`, так как поток может быть пустым.

### Вывод программы
```
1. [{Trader:Brian in Cambridge, year: 2011, value: 300}, {Trader:Raoul in Cambridge, year: 2011, value: 400}]
2. [Cambridge, Milan]
3. [Trader:Alan in Cambridge, Trader:Brian in Cambridge, Trader:Raoul in Cambridge]
4. Alan, Brian, Mario, Raoul
5. Трейдер из Милана существует
6. 2650
7. 1000
8. {Trader:Brian in Cambridge, year: 2011, value: 300}
```