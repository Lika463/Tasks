package ru.daliya.Second_tasks;
//2. Создайте метод, который принимает строку (имя и фамилию человека) и
// возвращает строку с заменой имени и фамилии.
// Пример:
// nameShuffle("Donald Trump") ➞ "Trump Donald"
// nameShuffle("Rosie O'Donnell") ➞ "O'Donnell Rosie"
// nameShuffle("Seymour Butts") ➞ "Butts Seymour"

public class Task2 {
    public static void main(String[] args) {
        nameShuffle("Donald Trump");
        nameShuffle("Rosie O'Donnell");
        nameShuffle("Seymour Butts");
    }

    private static void nameShuffle(String name_surname) {
        String[] words = name_surname.split(" ");
        for (int counter = words.length - 1; counter >= 0; counter--) {
            System.out.print(words[counter] + " ");
        }
        System.out.println();
    }
}
