package ru.daliya.First_tasks;
//Создайте функцию, которая принимает три аргумента prob, prize, pay и возвращает
// true, если prob * prize > pay; в противном случае возвращает false.
// Чтобы проиллюстрировать:
// profitableGamble(0.2, 50, 9)
// ... должно давать true, так как чистая прибыль равна 1 (0.2 * 50 - 9), и 1 > 0.
// Пример:
// profitableGamble(0.2, 50, 9) ➞ true
// profitableGamble(0.9, 1, 2) ➞ false
// profitableGamble(0.9, 3, 2) ➞ true

public class Task8 {
    public static void main(String[] args) {
        boolean result = profitableGamble(0.2, 50, 9);
        System.out.println(result);
        result = profitableGamble(0.9, 1, 2);
        System.out.println(result);
        result = profitableGamble(0.9, 3, 2);
        System.out.println(result);
    }

    private static boolean profitableGamble(double prob, int prize, int pay) {
        return prob * prize > pay;
    }
}
