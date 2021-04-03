package ru.daliya.Second_tasks;
//7. Вы наняли трех программистов и (надеюсь) платите им. Создайте функцию,
// которая принимает три числа (почасовая заработная плата каждого программиста)
// и возвращает разницу между самым высокооплачиваемым программистом и самым
// низкооплачиваемым.
// Пример:
// programmers(147, 33, 526) ➞ 493
// programmers(33, 72, 74) ➞ 41
// programmers(1, 5, 9) ➞ 8

public class Task7 {
    public static void main(String[] args) {

        programmers(147, 33, 526);
        programmers(33, 72, 74);
        programmers(1, 5, 9);
    }

    private static void programmers(int first, int second, int third) {
        int minimum = 1000;
        int maximum = 0;

        if (first>maximum){
                maximum = first;
            }
        if (second>maximum) {
                maximum = second;
            }
        if (third>maximum){
                maximum = third;
            }

        if (first<minimum){
            minimum = first;
        }
        if (second<minimum) {
            minimum = second;
        }
        if (third<minimum){
            minimum = third;
        }

        int result = maximum - minimum;
        System.out.println(result);


    }
}
