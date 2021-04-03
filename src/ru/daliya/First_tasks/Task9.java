package ru.daliya.First_tasks;
//Создайте метод, который возвращает количество кадров, показанных за заданное
// количество минут для определенного FPS.
// Пример:
// frames(1, 1) ➞ 60
// frames(10, 1) ➞ 600
// frames(10, 25) ➞ 15000


public class Task9 {
    public static void main(String[] args) {
        int result = frames(1, 1);
        System.out.println(result);
        result = frames(10, 1);
        System.out.println(result);
        result = frames(10, 25);
        System.out.println(result);
    }

    private static int frames(int image, int fps) {
        return image * 60 * fps;
    }

}
