package ru.daliya.Second_tasks;
//6. Создайте метод, который принимает строку в качестве аргумента и возвращает ее в
// обратном порядке.
// Пример:
// reverse("Hello World") ➞ "dlroW olleH"
// reverse("The quick brown fox.") ➞ ".xof nworb kciuq ehT"
// reverse("Edabit is really helpful!") ➞ "!lufpleh yllaer si tibadE"

public class Task6 {
    public static void main(String[] args) {

        for (int counter = 0; counter < args.length; counter++) {
            String string = args[counter];
            String reverseString = reverseString(string);
            System.out.println(reverseString);
        }
    }

    public static String reverseString(String word) {
        String string = "";
        int length = word.length();

        for (int counter = length - 1; counter >= 0; counter--) {
            string += word.charAt(counter);
        }

        return string;
    }
}


