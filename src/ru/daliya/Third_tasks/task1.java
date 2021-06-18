package ru.daliya.Third_tasks;

public class task1 {

    public static void main(String[] args) {

        System.out.println ("Задание №1. ");
        String [] city = {"Nice","Abu Dhabi", "Naples", "Vatican City"};
        int [] count = {942208, 1482816, 2186853, 572};
        millionsRounding(city,count);
        String [] city1 = {"Manila","Kuala Lumpur", "Jakarta"};
        int [] count1 = {13923452, 7996830, 10770487};
        millionsRounding(city1,count1);


        System.out.println ("Задание №2. ");
        otherSides(1);
        otherSides(12);
        otherSides(2);
        otherSides(3);


        System.out.println ("Задание №3. ");
        System.out.println (rps("rock", "paper"));
        System.out.println (rps("paper", "rock"));
        System.out.println (rps("paper", "scissors"));
        System.out.println (rps("scissors", "scissors"));
        System.out.println (rps("scissors", "paper"));


        System.out.println ("Задание №4. ");
        int [] a = {2, 8, 7, 5};
        System.out.println (warOfNumbers(a));
        int [] b = {12, 90, 75};
        System.out.println (warOfNumbers(b));
        int [] c = {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243};
        System.out.println (warOfNumbers(c));


        System.out.println ("Задание №5. ");
        System.out.println (reverseCase("Happy Birthday"));
        System.out.println (reverseCase("MANY THANKS"));
        System.out.println (reverseCase("sPoNtAnEoUs"));


        System.out.println ("Задание №6. ");
        System.out.println (inatorInator("Shrink"));
        System.out.println (inatorInator("Doom"));
        System.out.println (inatorInator("EvilClone"));


        System.out.println ("Задание №7. ");
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));


        System.out.println ("Задание №8. ");
        totalDistance(70.0, 7.0, 0, false);
        totalDistance(36.1, 8.6, 3, true);
        totalDistance(55.5, 5.5, 5, false);


        System.out.println ("Задание №9. ");
        int [] q = {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3};
        System.out.println (mean(q));
        int [] w = {2, 3, 2, 3};
        System.out.println (mean(w));
        int [] e = {3, 3, 3, 3, 3};
        System.out.println (mean(e));


        System.out.println ("Задание №10. ");
        System.out.println (parityAnalysis(243));
        System.out.println (parityAnalysis(12));
        System.out.println (parityAnalysis(3));
    }
    // Задание 1
    // Учитывая массив городов и населения, верните массив, в котором все население
    // округлено до ближайшего миллиона.
    public static void millionsRounding(String [] a, int [] b){
        for(int i=0;i< a.length;i++){

            int c=b[i]/1000000;
            int o=b[i]%1000000;
            if (o>=500000)
                c+=1;
            System.out.println(a[i]+", "+c*1000000);
        }
    }
    //Задание 2
    //Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
    //найти другие 2 стороны (верните самую длинную сторону, сторону средней
    //длины).
    static void otherSides(double a){
        System.out.print(a*2+", ");
        System.out.printf("%.2f",Math.sqrt(3*a*a));
        System.out.println();
    }

    //Задание 3
    // Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция
    // принимает входные данные обоих игроков (камень, ножницы или бумага), первый
    // параметр от первого игрока, второй от второго игрока. Функция возвращает
    // результат как таковой:
    public static String rps(String s1, String s2){
        if (s1.equalsIgnoreCase(s2))
            return "TIE";
        else
        if (s1.equalsIgnoreCase("rock"))
            if (s2.equalsIgnoreCase("paper"))
                return "Player 2 wins";
            else return "Player 1 wins";
        else if (s1.equalsIgnoreCase("paper"))
            if (s2.equalsIgnoreCase("rock"))
                return "Player 1 wins";
            else return "Player 2 wins";
        else if (s2.equalsIgnoreCase("rock"))
            return "Player 2 wins";
        else return "Player 1 wins";
    }
    //Задание 4
    //Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные
    //числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.
    public static int warOfNumbers(int [] mas){
        int a=0, b=0;
        for (int i = 0; i<mas.length; i++){
            if (mas[i]%2==0)
                a=a+mas[i];
            else b=b+mas[i];
        }
        return Math.abs(a-b);
    }
    //Задание 5
    //Учитывая строку, создайте функцию для обратного обращения. Все буквы в
    //нижнем регистре должны быть прописными, и наоборот.
    public static String reverseCase(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            //Character класс обертывает значение типа примитива char в объекте.
            if (Character.isUpperCase(chars[i]))
            {
                chars[i] = Character.toLowerCase(chars[i]);
            }
            else
                chars[i] = Character.toUpperCase(chars[i]);
        }
        return new String(chars);
    }
    //Задание 6 'b', 'c', 'd','f', 'j', 'h','g', 'k', 'l', 'm', 'n','p', 'q', 'r', 's', 't','v', 'w', 'x', 'z'
    // Создайте функцию, которая принимает строку из одного слова и выполняет
    // следующие действия:
    // Конкатенирует inator до конца, если слово заканчивается согласным, в противном
    // случае вместо него конкатенирует -inator
    // Добавляет длину слова исходного слова в конец, снабженный '000'.
    public static String inatorInator(String str){
        char[] chars = str.toCharArray();
        char l = chars[chars.length-1];
        if (l=='a' || l=='e'|| l=='i' || l=='o' || l=='u' || l=='y')
            str = str + "-inator " + chars.length + "000";

        else
            str = str + "inator " + chars.length + "000";
        return str;
    }
    //Задание 7
    //    Напишите функцию, которая принимает три измерения кирпича: высоту(a),
    //    ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
    //    отверстие с шириной(w) и высотой(h).
    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        if((w==a && h==b)||(w==b && h==a))
            return true;
        else if ((w==b && h==c)||(w==c && h==b))
            return true;
        else return (w == a && h == c) || (w == c && h == a);
    }
    //Задание 8
    //    Напишите функцию, которая принимает топливо (литры), расход топлива
    //(литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
    //    максимальное расстояние, которое может проехать автомобиль.
    //            топливо-это количество литров топлива в топливном баке.
    static void totalDistance(double top, double ras, int chel, boolean con){
        ras+=ras*chel/20;
        if(con)
            ras+=ras/10;
        System.out.printf("%.2f",top*100/ras);
        System.out.println();
    }
    //Задание 9
    //Создайте функцию, которая принимает массив чисел и возвращает среднее
    //значение (average) всех этих чисел.
    public static double mean(int [] mas){
        int s=0;
        for (int i = 0; i<mas.length; i++)
            s+=mas[i];
        s/=mas.length;
        return s;
    }
    //Задание 10
    // Создайте функцию, которая принимает число в качестве входных данных и
    // возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
    // противном случае верните false.
    public static boolean parityAnalysis(int a){
        int sum = 0;
        int s = a;
        while (a!=0) {
            sum+=a%10;
            a/=10;
        }
        return (s % 2 == 0 && sum % 2 == 0) || (s % 2 != 0 && sum % 2 != 0);
    }
}