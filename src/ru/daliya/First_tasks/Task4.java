package ru.daliya.First_tasks;
//Создайте функцию, которая возвращает true, если целое число равномерно делится
// на 5, и false в противном случае.
// Пример:
// divisibleByFive(5) ➞ true
// divisibleByFive(-55) ➞ true
// divisibleByFive(37) ➞ false

public class Task4 {
    public static void main(String[] args) {
        boolean result = divisibleByFive(5);
        System.out.println(result);
        result = divisibleByFive(-55);
        System.out.println(result);
        result = divisibleByFive(37);
        System.out.println(result);
    }

    // FIXME
    private static boolean divisibleByFive(int number) {
        if (number % 5 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
