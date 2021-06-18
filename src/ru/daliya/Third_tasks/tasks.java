package ru.daliya.Third_tasks;

import java.util.Scanner;

public class tasks {
    static void millionsRounding(String[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            double c = Math.round((double) b[i] / 1000000);
            System.out.println(a[i] + ", " + (int) c * 1000000);
        }
    }

    static void otherSides(double a) {
        System.out.print("Сторона второго катета = ");
        System.out.printf("%.2f", Math.sqrt(3 * a * a));
        System.out.println();
        System.out.println("Сторона гипотенузы = " + a * 2);
    }

    static void rpc(String first, String second) {
        if (first.equals(second)) {
            System.out.println("Ничья");
            return;
        }
        if ((first.equals("Камень") && second.equals("Ножницы")) || (first.equals("Ножницы") && second.equals("Бумага")) || (first.equals("Бумага") && second.equals("Камень")))
            System.out.println("Первый игрок победил");
        else System.out.println("Второй игрок победил");
    }

    static void warOfNumbers(int[] a) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) sum1 += a[i];
            else sum2 += a[i];
        }
        System.out.println("Разница чётных и нечётных чисел = " + Math.abs(sum1 - sum2));
    }

    static void reverseCase(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) ch[i] = Character.toLowerCase(ch[i]);
            else ch[i] = Character.toUpperCase(ch[i]);
            System.out.print(ch[i]);
        }
        System.out.println();
    }

    static void inatorInator(String str) {
        char[] ch = str.toCharArray();
        if (ch[ch.length - 1] == 97 || ch[ch.length - 1] == 101 || ch[ch.length - 1] == 105 || ch[ch.length - 1] == 111 || ch[ch.length - 1] == 117 || ch[ch.length - 1] == 121)
            System.out.println(str + "-inator" + " " + ch.length + "000");
        else System.out.println(str + "inator" + " " + ch.length + "000");
    }

    static boolean doesBrickFit(int a, int b, int c, int a1, int b1) {
        int squared = a * b;
        if (a * c < squared) squared = a * c;
        if (b * c < squared) squared = b * c;

        if (squared <= a1 * b1) return true;
        else return false;
    }

    static void totalDistance(double a, double b, int c, boolean d) {
        b += b * c / 20;
        if (d) b += b / 10;
        System.out.print("Максимальное расстояние = ");
        System.out.printf("%.2f", a * 100 / b);
    }

    static void mean(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) sum += a[i];
        sum /= a.length;
        System.out.println("Среднее значение = " + sum);
    }

    static boolean parityAnalysis(int a) {
        int sum = 0;
        int s = a;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        if ((s % 2 == 0 && sum % 2 == 0) || (s % 2 != 0 && sum % 2 != 0)) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int h = 1;
        while (h == 1) {
            System.out.println("Введите задание:");
            int Task = scan.nextInt();
            switch (Task) {
                case 1:
                    System.out.println("Введите количество городов: ");
                    int countCity = scan.nextInt();
                    String[] city = new String[countCity];
                    int[] count = new int[countCity];
                    System.out.println("Введите город и население");
                    for (int i = 0; i < countCity; i++) {
                        System.out.println("Город №" + (i + 1));
                        city[i] = sc.nextLine();
                        System.out.println("Население");
                        count[i] = scan.nextInt();
                    }
                    millionsRounding(city, count);
                    break;
                case 2:
                    System.out.println("Введите наименьший катет:");
                    double b = scan.nextDouble();
                    otherSides(b);
                    break;
                case 3:
                    System.out.println("Ход первого игрока:");
                    String first = sc.nextLine();
                    System.out.println("Ход второго игрока:");
                    String second = sc.nextLine();
                    rpc(first, second);

                    break;
                case 4:
                    System.out.println("Введите размер массива: ");
                    int n = scan.nextInt();
                    int[] a = new int[n];
                    for (int i = 0; i < n; i++) {
                        a[i] = (int) (Math.random() * 100) - 50;
                        System.out.print(a[i] + " ");
                    }
                    System.out.println();
                    warOfNumbers(a);
                    break;
                case 5:
                    System.out.println("Введите предложение");
                    String str = sc.nextLine();
                    reverseCase(str);
                    break;
                case 6:
                    System.out.println("Введите слово: ");
                    String str1 = sc.nextLine();
                    inatorInator(str1);
                    break;
                case 7:
                    int a1 = 2;
                    int b1 = 2;
                    int c1 = 1;
                    int a2 = 1;
                    int b2 = 1;
                    System.out.println("Длина кирпича = " + a1);
                    System.out.println("Ширина кирпича = " + b1);
                    System.out.println("Высота кирпича = " + c1);
                    System.out.println("Ширина отверстия = " + a2);
                    System.out.println("Высота отверстия = " + b2);
                    System.out.println("Результат: " + doesBrickFit(a1, b1, c1, a2, b2));
                    break;
                case 8:
                    double fuel = 36.1;
                    double fuelKilometres = 8.6;
                    int people = 3;
                    boolean condicioner = true;
                    totalDistance(fuel, fuelKilometres, people, condicioner);
                    System.out.println();
                    break;
                case 9:
                    int[] arr = new int[20];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = (int) (Math.random() * 100) - 50;
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    mean(arr);
                    break;
                case 10:
                    int number = 12;
                    System.out.println("Результат: " + parityAnalysis(number));
                    break;
            }
            System.out.println("Нажмите 1, чтобы остаться, 0 - выйти:");
            h = scan.nextInt();
            if (h == 0) break;
        }

    }
}

