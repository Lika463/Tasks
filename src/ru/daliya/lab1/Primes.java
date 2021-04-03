package ru.daliya.lab1;

public class Primes {
    public static void main(String[] args) {
        int n = 100;
        for (int counter = 2; counter < n; counter++) {
            if (isPrime(counter)) {
                System.out.println(counter);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int counter = 2; counter <= 9; counter++) {
            if ((n % counter == 0) && n != counter)
                return false;
        }
        return true;
    }
}
