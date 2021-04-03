package ru.daliya.First_tasks;
//У меня есть ведро с большим количеством темно-синей краски, и я хотел бы
//  покрасить как можно больше стен. Создайте функцию, которая возвращает
//  количество полных стен, которые я могу покрасить, прежде чем мне нужно будет
//  отправиться в магазины, чтобы купить еще.
//  n - это количество квадратных метров, которые я могу нарисовать.
//  w и h-это ширина и высота одной стены в метрах.
//Пример:
// howManyWalls(54, 1, 43) ➞ 1
// howManyWalls(46, 5, 4) ➞ 2
// howManyWalls(100, 4, 5) ➞ 5
// howManyWalls(10, 15, 12) ➞ 0
// howManyWalls(41, 3, 6) ➞ 2

public class Task6 {
    public static void main(String[] args) {
        int result = howManyWalls(54, 1, 43);
        System.out.println(result);
        result = howManyWalls(46, 5, 4);
        System.out.println(result);
        result = howManyWalls(100, 4, 5);
        System.out.println(result);
        result = howManyWalls(10, 15, 12);
        System.out.println(result);
        result = howManyWalls(41, 3, 6);
        System.out.println(result);
    }

    private static int howManyWalls(int count, int weight, int height) {
        return (count / (weight * height));
    }
}
