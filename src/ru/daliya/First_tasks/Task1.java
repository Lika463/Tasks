package ru.daliya.First_tasks;

//1. Напишите функцию, которая принимает целое число минут и преобразует его в
// секунды.
// Пример:
// convert(5) ➞ 300
// convert(3) ➞ 180
// convert(2) ➞ 120

public class Task1 {

    public static void main(String[] args) {
        int seconds = convert(5);
        System.out.println(seconds);
        seconds = convert(3);
        System.out.println(seconds);
        seconds = convert(2);
        System.out.println(seconds);
    }

    private static int convert(int minutes) {
        return minutes * 60;
    }
}
