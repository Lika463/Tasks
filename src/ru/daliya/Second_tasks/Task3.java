package ru.daliya.Second_tasks;
//3. Создайте функцию, которая принимает два аргумента: исходную цену и процент
// скидки в виде целых чисел и возвращает конечную цену после скидки.
// Пример:
// discount(1500, 50) ➞ 750
// discount(89, 20) ➞ 71.2
// discount(100, 75) ➞ 25


public class Task3 {
    public static void main(String[] args) {
        double rez = discount(1500, 50);
        System.out.println(rez);
        double rez1 = discount(89, 20);
        System.out.println(rez1);
        double rez2 = discount(100, 75);
        System.out.println(rez2);

    }

    private static double discount(double sum, double persent) {
        return sum - sum * persent / 100;

    }
}
