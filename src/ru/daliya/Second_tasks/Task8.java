package ru.daliya.Second_tasks;
//8. Создайте функцию, которая принимает строку, проверяет, имеет ли она одинаковое
// количество x и o и возвращает либо true, либо false.
// Правила:
// - Возвращает логическое значение (true или false).
// - Верните true, если количество x и o одинаковы.
// - Верните false, если они не одинаковы.
// - Строка может содержать любой символ.
// - Если "x" и "o" отсутствуют в строке, верните true.
// Пример:
// getXO("ooxx") ➞ true
// getXO("xooxx") ➞ false
// getXO("ooxXm") ➞ true
// Case insensitive.
// getXO("zpzpzpp") ➞ true
// Returns true if no x and o.
// getXO("zzoo") ➞ false

public class Task8 {
    public static void main(String[] args) {

        getXO("ooxx");
        getXO("xooxx");
        getXO("ooxXm");
        getXO("zpzpzpp");
        getXO("zzoo");

    }

    private static void getXO(String string) {
        int k = 0; int m = 0;
        char [] letter = string.toCharArray();
        for (int counter = 0; counter < string.length(); counter++) {
            if ((letter[counter] == 'x') || (letter[counter] == 'X')) {
                k = k + 1;
            }
            if ((letter[counter] == 'o') || (letter[counter] == 'O')) {
                m = m+1;
            }
        }
        if (m == k) {
            System.out.println("true");;
        }
        else if (k!=m) {
            System.out.println("false");
        }
        else if ((m==0) && (k==0)){
            System.out.println("true");
        }

    }
}
