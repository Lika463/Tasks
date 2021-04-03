package ru.daliya.First_tasks;
// Создайте функцию, которая принимает количество побед, ничьих и поражений и
// вычисляет количество очков, набранных футбольной командой на данный момент.
// выигрыш – получают 3 очка
// ничья – получают 1 очко
// проигрыш – получают 0 очков
// Пример:
// footballPoints(3, 4, 2) ➞ 13
// footballPoints(5, 0, 2) ➞ 15
// footballPoints(0, 0, 1) ➞ 0

public class Task3 {
    public static void main(String[] args) {
        int result = footballPoints(3, 4, 2);
        System.out.println(result);
        result = footballPoints(5, 0, 2);
        System.out.println(result);
        result = footballPoints(0, 0, 1);
        System.out.println(result);
    }

    private static int footballPoints(int thirdpoints, int onepoint, int zeropoint) {
        return thirdpoints * 3 + onepoint * 1 + zeropoint * 0;
    }
}
