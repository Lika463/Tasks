package ru.daliya.First_tasks;
//Исправьте код, чтобы решить эту задачу (только синтаксические ошибки).
// Посмотрите на приведенные ниже примеры, чтобы получить представление о том,
// что должна делать эта функция.
// squared(5) ➞ 25
// squared(9) ➞ 81
// squared(100) ➞ 10000
// Код:
//public class Challenge {
//    public static int squaed(int b) {
//        return a * a
//    }
//}

public class Task7 {
    public static void main(String[] args) {
        int result = squared(5);
        System.out.println(result);
        result = squared(9);
        System.out.println(result);
        result = squared(100);
        System.out.println(result);
    }
    // FIXME
    private static int squared(int number) {
        return number * number;
    }
}
