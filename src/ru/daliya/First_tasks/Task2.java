package ru.daliya.First_tasks;
//Вы подсчитываете очки за баскетбольный матч, учитывая количество забитых 2-х
// и 3-х очков, находите окончательные очки для команды и возвращаете это
// значение.
// Пример:
// points(13, 12) ➞ 62
// points(17, 12) ➞ 70
// points(38, 8) ➞ 100

public class Task2 {
    public static void main(String[] args) {
        int result = points(13, 12);
        System.out.println(result);
        result = points(17, 12);
        System.out.println(result);
        result = points(38, 8);
        System.out.println(result);
    }

    // TODO: Codestyle
    private static int points(int twopoint, int thirdpoint) {
        return twopoint * 2 + thirdpoint * 3;
    }
}
