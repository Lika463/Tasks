package ru.daliya.First_tasks;
//Создайте функцию, которая будет работать как оператор модуля % без
// использования оператора модуля. Оператор модуля-это способ определения
// остатка операции деления. Вместо того чтобы возвращать результат деления,
// операция по модулю возвращает остаток целого числа.
// Пример:
// mod(5, 2) ➞ 1
// mod(218, 5) ➞ 3
// mod(6, 3) ➞ 0

public class Task10 {
    public static void main(String[] args) {
        int result = mod(5, 2);
        System.out.println(result);
        result = mod(218, 5);
        System.out.println(result);
        result = mod(6, 3);
        System.out.println(result);
    }
    // FIXME
    private static int mod(int first_number, int second_number) {
        return first_number - first_number / second_number * second_number;
    }
}
