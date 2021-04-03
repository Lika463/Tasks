package ru.daliya.First_tasks;
//В Java есть логический оператор &&. Оператор && принимает два логических
// значения и возвращает true, если оба значения истинны.
// Рассмотрим a && b:
// a проверяется, является ли оно истинным или ложным.
// Если a равно false, возвращается false.
// b проверяется, является ли оно истинным или ложным.
// Если b имеет значение false, возвращается значение false.
// В противном случае возвращается true (поскольку и a, и b, следовательно, истинны ).
// Оператор && вернет true только для true && true.
// Создайте функцию с помощью оператора&&.
//Пример:
// and(true, false) ➞ false
// and(true, true) ➞ true
// and(false, true) ➞ false
// and(false, false) ➞ false

public class Task5 {
    public static void main(String[] args) {
        boolean result = and(true, false);
        System.out.println(result);
        result = and(true, true);
        System.out.println(result);
        result = and(false, true);
        System.out.println(result);
        result = and(false, false);
        System.out.println(result);

    }

    private static boolean and(boolean firstvalue, boolean secondvalue) {
        return firstvalue && secondvalue;
    }
}
