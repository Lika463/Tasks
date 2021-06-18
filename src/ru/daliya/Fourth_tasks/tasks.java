package ru.daliya.Fourth_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class tasks {

    public static void main(String[] args) {
        System.out.println ("Задание №1. ");
        int [] a = {1, 2, 3, 4, 5, 6, 7};
        int [] b = {8, 6, 33, 100};
        int [] c = {2, 55, 60, 97, 86};
        System.out.println(sevenBoom(a));
        System.out.println(sevenBoom(b));
        System.out.println(sevenBoom(c));


        System.out.println ("Задание №2. ");
        int [] a1 = {5, 1, 4, 3, 2};
        int [] b1 = {5, 1, 4, 3, 2, 8};
        int [] c1 = {5, 6, 7, 8, 9, 9};
        System.out.println (cons(a1));
        System.out.println (cons(b1));
        System.out.println (cons(c1));


        System.out.println ("Задание №3. ");
        System.out.println (unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println (unmix("123456"));
        System.out.println (unmix("badce"));


        System.out.println ("Задание №4. ");
        System.out.println (noYelling("What went wrong?????????"));
        System.out.println (noYelling("Oh my goodness!!!"));
        System.out.println (noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println (noYelling("Oh my goodness!"));
        System.out.println (noYelling("I just cannot believe it."));


        System.out.println ("Задание №5. ");
        System.out.println (xPronounce("Inside the box was a xylophone"));
        System.out.println (xPronounce("The x ray is excellent"));
        System.out.println (xPronounce("OMG x box unboxing video x D"));



        System.out.println ("Задание №6. ");
        int [] a2 = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
        int [] b2 = {14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7};
        int [] c2 = {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9};
        System.out.println (largestGap(a2));
        System.out.println (largestGap(b2));
        System.out.println (largestGap(c2));


        System.out.println ("Задание №7. ");
        System.out.println(Fff(832));
        System.out.println(Fff(51));
        System.out.println(Fff(7977));
        System.out.println(Fff(1));
        System.out.println(Fff(665));
        System.out.println(Fff(149));



        System.out.println ("Задание №8. ");
        System.out.println (commonLastVowel("Hello World!"));
        System.out.println (commonLastVowel("Watch the characters dance!"));
        System.out.println (commonLastVowel("OOI UUI EEI AAI"));


        System.out.println ("Задание №9. ");
        System.out.println (memeSum(26, 39));
        System.out.println (memeSum(122, 81));
        System.out.println (memeSum(1222, 30277));


        System.out.println ("Задание №10. ");
        System.out.println (unrepeated("teshahset"));
        System.out.println (unrepeated("hello"));
        System.out.println (unrepeated("aaaaa"));
        System.out.println (unrepeated("WWE!!!"));
        System.out.println (unrepeated("call 911"));

    }
    //Задание 1
    // Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
    // массиве появляется цифра 7. В противном случае верните "в массиве нет 7"
    public static String sevenBoom(int [] a){
        for(int i=0; i< a.length; i++){
            int c = a[i];
            while(c!=0){
                if (c%10==7)
                    return "Boom!";
                c=c/10;
            }
        }
        return "There is no 7 in the array";
    }
    //Задание 2
    // Создайте функцию, которая определяет, могут ли элементы в массиве быть
    // переупорядочены, чтобы сформировать последовательный список чисел, где
    // каждое число появляется ровно один раз.
    public static boolean cons(int [] a){
        for (int i=0; i< a.length; i++){
            int k=i;
            int x = a[i];
            for (int j=i+1; j< a.length; j++){
                while (a[j]<x){
                    k=j;
                    x=a[j];
                }
            }
            a[k]=a[i];
            a[i]=x;
        }

        //System.out.println (Arrays.toString(a));
        for (int i=0; i< a.length-1; i++){
            if(a[i] != (a[i+1]-1))
                return false;
        }
        return true;
    }
    //Задание 3
    // lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста,
    // помогите мне распутать эти строки!
    // Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
    // Помоги отменить это, чтобы снова понять строки.
    public static String unmix(String str){
        // преобразует данную строку в новый массив символов.
        char[] ch = str.toCharArray();
        //System.out.println (ch.length);
        for (int i = 0; i <= ch.length-2; i+=2){
            //System.out.println (ch[i]);
            char x = ch[i];
            ch[i] = ch[i+1];
            ch[i+1] = x;
        }
        return new String(ch);
    }
    //Задание 4
    // Создать функцию, которая преобразует предложения, заканчивающиеся
    // несколькими вопросительными знаками ? или восклицательными знаками ! в
    // предложение, заканчивающееся только одним, без изменения пунктуации в
    // середине предложений.
    public static String noYelling(String str){
        char[] ch = str.toCharArray();
        if (ch[ch.length-1] == '!' || ch[ch.length-1] == '?'){
            int k=ch.length;
            if (ch[ch.length-1] == '!'){
                int j = ch.length-1;
                while (ch[j] == '!'){
                    k--;
                    j--;
                }
                char[] ch2 = Arrays.copyOfRange(ch, 0, k+1);
                return new String(ch2);
            }
            else {
                int j = ch.length-1;
                while (ch[j] == '?'){
                    k--;
                    j--;
                }
                char[] ch2 = Arrays.copyOfRange(ch, 0, k+1);
                return new String(ch2);
            }
        }
        else
            return new String(ch);
    }
    //Задание 5
    // Создайте функцию, которая заменяет все x в строке следующими способами:
    // Замените все x на "cks", ЕСЛИ ТОЛЬКО:
    // Слово начинается с "x", поэтому замените его на "z".
    // Слово-это просто буква "х", поэтому замените ее на " cks "
    public static String xPronounce(String str){
        String[] arr = str.split(" ");//разделение строки по " "
        String newStr = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("x"))
                arr[i] = "ecks";
            else {
                if (arr[i].charAt(0) == 'x') //вытащить определенный символ в какой-то строке
                    arr[i] = arr[i].replace('x', 'z');//заменяет указанный символ (или подстроку) в строке на новый.
                else
                    arr[i]=arr[i].replaceAll("x","cks");//метод позволяет заменить слово в строке.
            }
            newStr += arr[i] + " ";
        }
        return newStr;
    }
    //Задание 6
    // Учитывая массив целых чисел, верните наибольший разрыв между
    // отсортированными элементами массива.
    // Например, рассмотрим массив:
    //    [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]
    // ... в котором после сортировки массив становится:
    //     [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26]
    // ... так что теперь мы видим, что самый большой разрыв в массиве находится между 9 и 20,
    // что равно 11.
    public static int largestGap(int [] a){
        for (int i=0; i< a.length; i++){
            int k=i;
            int x = a[i];
            for (int j=i+1; j< a.length; j++){
                while (a[j]<x){
                    k=j;
                    x=a[j];
                }
            }
            a[k]=a[i];
            a[i]=x;
        }

        int k = -100;
        for (int i = 0; i < a.length-1; i++){
            if ((a[i+1]-a[i]) > k)
                k = a[i+1]-a[i];
        }
        return k;
    }
    //Задание 7
    // Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
    // создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
    // чтобы удовлетворить соотношение между входами и выходами.
    // Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных
    // ниже производит показанные примеры выходных данных.
    public static int Fff(int a){
        ArrayList<Integer> myA = new ArrayList<Integer>();
        int i = -1;
        int newA = 0;
        int memory = a;
        while (a > 0){
            myA.add(a % 10);
            a = Math.floorDiv(a, 10);
            i++;
        }
        Collections.sort(myA);
        for (int c:myA) {//от 0 до myA
            newA += c * (Math.pow(10, i));//возводим 10 в степень i
            i--;
        }
        return memory-newA;
    }
    //Задание 8
    // Создайте функцию, которая принимает предложение в качестве входных данных и
    // возвращает наиболее распространенную последнюю гласную в предложении в
    // виде одной символьной строки
    public static String commonLastVowel(String str){
        str = str.toLowerCase(Locale.ROOT);
        String[] ar = str.split(" ");
        int a = 0; int e = 0; int i = 0; int o = 0; int u = 0; int y = 0;
        for (int j = 0; j < ar.length; j++){
            String str2 = ar[j];
            char[] ch = str2.toCharArray();
            if (ar[j].charAt(ch.length-1) == 'a')
                a++;
            if (ar[j].charAt(ch.length-1) == 'e')
                e++;
            if (ar[j].charAt(ch.length-1) == 'i')
                i++;
            if (ar[j].charAt(ch.length-1) == 'o')
                o++;
            if (ar[j].charAt(ch.length-1) == 'u')
                u++;
            if (ar[j].charAt(ch.length-1) == 'y')
                y++;
        }

        if (a>e && a>i && a>o && a>u && a>y)
            return "a";
        else if (e>i && e>o && e>u && e>y)
            return "e";
        else if (i>o && i>u && i>y)
            return "i";
        else if (o>u && o>y)
            return "o";
        else if (u>y)
            return "u";
        else return "y";
    }
    //Задание 9
    public static int helpFunc(int mult, int howMuch){
        while (howMuch > 0) {
            mult = mult * 10;
            howMuch = Math.floorDiv(howMuch, 10);
        }
        return mult;
    }
    public static int memeSum(int a, int b){
        int sum = 0;
        while (a != 0 || b != 0) {
            int i = a % 10 + b % 10;
            sum += helpFunc(i, sum);
            a = Math.floorDiv(a, 10);//возвращает целочисленный результат деления a на 10
            b = Math.floorDiv(b, 10);
        }
        return sum;
    }
    //Задание 10
    // Создайте функцию, которая удалит все повторяющиеся символы в слове,
    // переданном этой функции. Не просто последовательные символы, а символы,
    // повторяющиеся в любом месте строки.
    public static String unrepeated(String str){
        char[] array = str.toCharArray();
        String newStr = "";
        for (Character i:array){
            if (!newStr.contains(String.valueOf(i))) // метод чтобы проверить, содержит ли String указанную последовательность символов
            {
                newStr = newStr + String.valueOf(i);//возвращает строковое представление объекта аргумента
            }
        }
        return newStr;
    }
}
