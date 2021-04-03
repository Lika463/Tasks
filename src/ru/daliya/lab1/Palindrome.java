package ru.daliya.lab1;


public class Palindrome {
    public static void main(String[] args) {
        for (int counter = 0; counter < args.length; counter++) {
            String string = args[counter];
            String reverseString = reverseString(string);

            if (string.equals(reverseString)) {
                System.out.println("Палиндром: " + string + " " + reverseString);
            } else {
                System.out.println("Не палиндром: " + string + " " + reverseString);
            }

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
