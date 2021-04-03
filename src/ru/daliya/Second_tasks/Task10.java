package ru.daliya.Second_tasks;
//10. Возвращает true, если сумма значений ASCII первой строки совпадает с суммой
// значений ASCII второй строки, в противном случае возвращает false.
// Пример:
// sameAscii("a", "a") ➞ true
// sameAscii("AA", "B@") ➞ true
// sameAscii("EdAbIt", "EDABIT") ➞ false

public class Task10 {
    public static void main(String[] args) {
        sameAscii("a", "a");
        sameAscii("AA", "B@");
        sameAscii("EdAbIt", "EDABIT");
    }

    private static void sameAscii(String first_string, String second_string) {
        char[] first = first_string.toCharArray();
        char[] second = second_string.toCharArray();
        int firstsum = 0, secondsum = 0;
        for (int counter = 0; counter < first.length; counter++) {
            firstsum = firstsum +first[counter];
        }
        for (int counter = 0; counter < second.length; counter++) {
            secondsum= secondsum + second[counter];
        }
        System.out.println(firstsum);
        System.out.println(secondsum);
        if (firstsum == secondsum){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

}
