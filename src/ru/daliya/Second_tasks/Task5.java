package ru.daliya.Second_tasks;
//Создайте функцию, которая принимает три целочисленных аргумента (a, b, c) и
// возвращает количество целых чисел, имеющих одинаковое значение.
// Пример:
// equal(3, 4, 3) ➞ 2
// equal(1, 1, 1) ➞ 3
// equal(3, 4, 1) ➞ 0

public class Task5 {
    public static void main(String[] args) {
        int result = equal(3, 4, 3);
        System.out.println(result);
        result = equal(1, 1, 1);
        System.out.println(result);
        result = equal(3, 4, 1);
        System.out.println(result);
    }

    private static int equal(int a, int b, int c) {

        if ((a==b) && (b==c) && (a==c)){
            return 3;
        }
        else {
            if ((a==b) || (a==c) || (c==b)){
                return 2;
            }

        }
    return 0;
    }
}
