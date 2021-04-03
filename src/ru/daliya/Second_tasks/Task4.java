package ru.daliya.Second_tasks;
//4. Создайте функцию, которая принимает массив и возвращает разницу между
// наибольшим и наименьшим числами.
// Пример:
// differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]) ➞ 82
// Smallest number is -50, biggest is 32.
// differenceMaxMin([44, 32, 86, 19]) ➞ 67
// Smallest number is 19, biggest is 86.

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 4, 1, 4, -10, -50, 32, 21};
        differenceMaxMin(array);
        int[] Secondarray = new int[]{44, 32, 86, 19};
        differenceMaxMin(Secondarray);
    }

    private static void differenceMaxMin(int[] array) {

        int maximum = 1000;

        for (int counter = 0; counter < array.length; counter++) {
            if (array[counter] > maximum) {
                maximum = array[counter];
            }
        }

        int minimum = 1000;

        for (int counter = 0; counter < array.length; counter++) {
            if (array[counter] < minimum) {
                minimum = array[counter];
            }
        }
        int result = maximum-minimum;
        System.out.println(result);
    }
}
