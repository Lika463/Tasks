package ru.daliya.Second_tasks;
//9. Напишите функцию, которая находит слово "бомба" в данной строке. Ответьте
// "ПРИГНИСЬ!", если найдешь, в противном случае:"Расслабься, бомбы нет".
// Пример:
// bomb("There is a bomb.") ➞ "DUCK!"
// bomb("Hey, did you think there is a BOMB?") ➞ "DUCK!"
// bomb("This goes boom!!!") ➞ "Relax, there's no bomb."
// Примечание:
// Строка "бомба" может появляться в разных случаях символов (например, в верхнем,
// нижнем регистре, смешанном).

public class Task9 {
    public static void main(String[] args) {
        bomb("There is a bomb.");
        bomb("Hey, did you think there is a BOMB?");
        bomb("This goes boom!!!");

    }

    private static void bomb(String word) {
        if (word.contains("bomb") || word.contains("BOMB")) {
            System.out.println("DUCK!");
        }
        else{
            System.out.println("Relax, there's no bomb.");
        }
    }
}
