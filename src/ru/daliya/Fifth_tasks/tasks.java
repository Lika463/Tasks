package ru.daliya.Fifth_tasks;


import java.text.SimpleDateFormat;
import java.util.*;

public class tasks {

    public static void main(String[] args) {
        System.out.println ("Задание №1. ");
        System.out.println(sameLetterPattern("ABAB","CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println ("Задание №2. ");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println ("Задание №3. ");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println ("Задание №4. ");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"},"tossed"));

        System.out.println ("Задание №5. ");
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9 }));
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15 }));
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15 }));

        System.out.println ("Задание №6. ");
        System.out.println(takeDownAverage(new int[]{95,83,90,87,88,93}));
        System.out.println(takeDownAverage(new int[]{10}));
        System.out.println(takeDownAverage(new int[]{53,79}));

        System.out.println ("Задание №7. ");
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(rearrange("the4 t3o man5 Happ1iest of6 no7 birt2hday steel8!"));
        System.out.println(rearrange("is2 Thi1s T4est 3a"));
        System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println(rearrange(" "));

        System.out.println ("Задание №8. ");
        System.out.println(maxPossible(9328,456));
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255) );

        System.out.println ("Задание №9. ");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println ("Задание №10. ");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }
    // Задание 1
    //Создайте функцию, которая возвращает true, если две строки имеют один и тот же
    //буквенный шаблон, и false в противном случае.
    public static int stringToPatter (String a) {
        int pat =0;
        a=a.toLowerCase(Locale.ROOT);
        char[] arr = a.toCharArray();
        String checkStr= "";
        for (char temp:arr) {
            if(!checkStr.contains(String.valueOf(temp)))
                checkStr += String.valueOf(temp);
        }

        for (int i=0; i<a.length();i++){
            pat += (checkStr.indexOf(arr[i]) + 1) * Math.pow(10,i);
        }
        return pat;
    }
    public static boolean sameLetterPattern(String first, String second){
        return stringToPatter(first) == stringToPatter(second);
    }

    // Задание 2
    //Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и
    //радиалами, помеченными по часовой стрелке сверху как A-H.
    static class Point {
        private String letter;
        private int rad;

        public Point(String p) {
            this.letter = String.valueOf(p.charAt(0));
            rad = Integer.valueOf(String.valueOf(p.charAt(1)));
        }

        public Point(String letter, int rad) {
            this.letter = letter;
            this.rad = rad;
        }

        public int getRad() {
            return rad;
        }

        public String getLetter() {
            return letter;
        }
    }

    public static double BetweenP(Point begining, Point moveTo) {
        if (begining.getLetter().equals(moveTo.getLetter())) return 1;
        else{
            int a = begining.getRad();
            int b = moveTo.getRad();
            return Math.sqrt(a*a + b*b - 2*a*b* Math.cos(Math.toRadians(45)));
        }

    }

    public static double calculateS(Point begining, Point moveTo, Point fly){

        Map<String, Integer> web = new HashMap<String,Integer>();
        // метод используется, чтобы связать указанное значение с указанным ключом в этой карте.
        web.put("A",0);
        web.put("B",1);
        web.put("C",2);
        web.put("D",3);
        web.put("E",4);
        web.put("F",5);
        web.put("G",6);
        web.put("H",7);


        int angle, a, b;
        double distance;
        int difference = Math.abs(web.get(moveTo.getLetter()) - web.get(fly.getLetter()));
        //get(Object k):возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, то возвращается значение null

        if (difference<=4)
            angle =  difference*45;
        else angle = (8 - difference)*45;
        a = moveTo.getRad();
        b = fly.getRad();
        if (difference!=0 && moveTo.getRad()!=0)
            distance = Math.sqrt(a*a + b*b - 2*b*a*Math.cos(Math.toRadians(angle)));
        else distance=Math.abs(a-b);
        distance = distance+BetweenP(begining,moveTo);
        return distance;
    }

    public static Point minimumDistance(Point spider,Point fly, Point moveTo1, Point moveTo2 ){
        if (calculateS(spider, moveTo1,fly)<calculateS(spider, moveTo2,fly)) return moveTo1;
        else return moveTo2;
    }

    public static Point whereToGo(Point spider, Point fly){
        Map<Integer, String> revWeb = new HashMap<Integer,String>();
        revWeb.put(0,"A");
        revWeb.put(1,"B");
        revWeb.put(2,"C");
        revWeb.put(3,"D");
        revWeb.put(4,"E");
        revWeb.put(5,"F");
        revWeb.put(6,"G");
        revWeb.put(7,"H");


        Map<String, Integer> web = new HashMap<String,Integer>();
        web.put("A",0);
        web.put("B",1);
        web.put("C",2);
        web.put("D",3);
        web.put("E",4);
        web.put("F",5);
        web.put("G",6);
        web.put("H",7);

        Point first;
        Point second;
        Point third;
        Point fourth;
        Point fin;


        String nextLetter;
        String pastLetter;


        if (spider.getRad()==0) {
            return fin = new Point(fly.getLetter(),1);
        }

        if (!spider.getLetter().equals("H"))
            nextLetter = revWeb.get(web.get(spider.getLetter()) + 1);
        else
            nextLetter = "A";

        if (!spider.getLetter().equals("A"))
            pastLetter = revWeb.get(web.get(spider.getLetter()) - 1);
        else
            pastLetter = "H";


        third = new Point(nextLetter, spider.getRad());
        fourth = new Point(pastLetter, spider.getRad());
        fin = minimumDistance(spider,fly,third,fourth);


        if (spider.getRad()<4 && spider.getRad()>0) {
            first = new Point(spider.getLetter(), spider.getRad() + 1);
            second = new Point(spider.getLetter(), spider.getRad() - 1);
            fin = minimumDistance(spider,fly,fin, minimumDistance(spider,fly,first,second));
        }
        else if (spider.getRad()==4){
            second = new Point(spider.getLetter(), spider.getRad() - 1);
            fin = minimumDistance(spider,fly,fin,second);
        }
        return fin;
    }

    public static String spiderVsFly(String spider, String fly){
        Point begining = new Point(spider);
        Point ending = new Point(fly);
        String way = "";
        while (!begining.getLetter().equals(ending.getLetter()) || begining.getRad()!=ending.getRad()){

            way += begining.getLetter() + String.valueOf(begining.getRad())+"-";
            begining = whereToGo(begining,ending);

        }
        way += begining.getLetter() + String.valueOf(begining.getRad());
        return way;
    }

    // Задание 3
    //Создайте функцию, которая будет рекурсивно подсчитывать количество цифр
    //числа. Преобразование числа в строку не допускается, поэтому подход является
    //рекурсивным.
    public static int digitsCount(long num){
        if (num!=0) {
            if (num>=10) {
                num = Math.floorDiv(num, 10);
                return 1 + digitsCount(num);
            }
            else {
                num = Math.floorDiv(num, 10);
                return digitsCount(num);
            }
        }
        else return 1;
    }
    // Задание 4
    //В игроки пытаются набрать очки, формируя слова, используя буквы из 6-
    //буквенного скремблированного слова. Они выигрывают раунд, если им удается
    //успешно расшифровать слово из 6 букв.
    //Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-
    //буквенное слово и возвращает общее количество очков, набранных игроком в
    //определенном раунде, используя следующую рубрику:
    //        3-буквенные слова-это 1 очко
    //        4-буквенные слова-это 2 очка
    //        5-буквенные слова-это 3 очка
    //        6-буквенные слова-это 4 очка + 50 пт бонуса (за расшифровку слова)
    //Помните, что недопустимые слова (слова, которые не могут быть сформированы из 6-
    //        буквенных расшифрованных слов) считаются 0 очками
    public static int totalPoints(String[] tries, String answer){
        char[] arrAnswer = answer.toCharArray();
        Map<Character, Integer> count = new HashMap<>();

        for (Character letter:arrAnswer){
            if (!count.containsKey(letter))
                count.put(letter,1);
            else
                count.put(letter,count.get(letter)+1);
        }
        int sumOfPoints=0;
        for (String word: tries) {
            boolean doesItCount = true;
            int points=0;

            char[] arrTries = word.toCharArray();
            Map<Character, Integer> ansCount = new HashMap<>();

            for (Character letter:arrTries){
                if (!ansCount.containsKey(letter))
                    ansCount.put(letter,1);
                else
                    ansCount.put(letter,ansCount.get(letter)+1);
            }

            for (Character letter:arrTries) {
                if (!count.containsKey(letter) || count.get(letter)<ansCount.get(letter))
                    doesItCount=false;
            }
            if (doesItCount==true) {
                if (arrTries.length == arrAnswer.length) points += 54;
                else if (arrTries.length == 3) points += 1;
                else if (arrTries.length == 4) points += 2;
                else if (arrTries.length == 5) points += 3;
            }
            sumOfPoints+=points;

        }
        return sumOfPoints;
    }

    // Задание 5
    //Последовательный прогон-это список соседних последовательных целых чисел.
    //Этот список может быть как увеличивающимся, так и уменьшающимся. Создайте
    //функцию, которая принимает массив чисел и возвращает длину самого длинного
    //последовательного запуска.
    public static int longestRun(int[] arr){
        int longest = 1;
        int currentRun = 1;
        int difference=0;
        for (int i = 0 ; i<arr.length-1; i++){
            if (Math.abs(arr[i] - arr[i+1])==1 && (arr[i] - arr[i+1]==difference  || difference==0) ) {
                difference=arr[i] - arr[i+1];
                currentRun+=1;
                if (currentRun>longest) longest=currentRun;
            }
            else {
                currentRun=1;
                difference=0;
            }
        }
        return longest;
    }
    // Задание 6
    //Какой процент вы можете набрать на тесте, который в одиночку снижает средний
    //балл по классу на 5%? Учитывая массив оценок ваших одноклассников, создайте
    //функцию, которая возвращает ответ. Округлите до ближайшего процента.
    public static int takeDownAverage(int[] arr){
        double mean,sumOfScores=0;
        int myScore;
        for (int toSum: arr) {
            sumOfScores+=toSum;
        }
        mean = Math.round(sumOfScores/arr.length) - 5 ;
        myScore = (int)(mean*(arr.length+1) - sumOfScores);
        return myScore;
    }
    // Задание 7
    //Учитывая предложение с числами, представляющими расположение слова,
    //встроенного в каждое слово, верните отсортированное предложение.
    public static String rearrange(String mixed){
        String[] words = mixed.split(" ");
        String out="";
        int position=1;
        if (words.length!=1)
            while (position<= words.length)
                for (String word:words) {
                    //contains - содержит ли String указанную последовательность символов.
                    if (word.contains(String.valueOf(position))) {
                        //replace() заменяет указанный символ (или подстроку) в строке на новый
                        word = word.replace(String.valueOf(position), "");
                        out += word + " ";
                        position++;
                    }
                }
        return out;
    }
    // Задание 8
    //Напишите функцию, которая делает первое число как можно больше, меняя его
    //цифры на цифры во втором числе.
    public static String maxPossible(int a, int b){
        ArrayList<Integer> firstNum = new ArrayList<>();
        ArrayList<Integer> secondNum = new ArrayList<>();

        while (a>0){
            int temp = a % 10;
            firstNum.add(temp);
            a = Math.floorDiv(a,10);
        }
        Collections.reverse(firstNum);//переворот листа

        while (b>0){
            int temp = b % 10;
            secondNum.add(temp);
            b = Math.floorDiv(b,10);
        }
        //reverseOrder - способ сортировки массива в обратном порядке
        Collections.sort(secondNum, Collections.reverseOrder());
        for (int i=0; i< firstNum.size();i++){
            for (int j=0; j<secondNum.size();j++) {
                if (firstNum.get(i) < secondNum.get(j)){
                    firstNum.remove(i);
                    firstNum.add(i,secondNum.get(j));
                    secondNum.remove(j);
                    secondNum.add(j,0);
                }
            }
        }
        String num = "";
        for (Integer number: firstNum) {
            num += String.valueOf(number);
        }
        return num;
    }
    // Задание 9
    // В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух
    // разных городах. Вам дается строка cityA и связанная с ней строка timestamp

    public static String timeDifference(String townA, String date, String townB)
    {
        String answer = "";
        date = date.replace(",", "");
        date = date.replace(":", " ");
        String[] dateS = date.split(" ");
        String monthS = dateS[0];
        int hour = Integer.parseInt(dateS[3]);
        int minutes = Integer.parseInt(dateS[4]);
        int dateNum = Integer.parseInt(dateS[1]);
        int year = Integer.parseInt(dateS[2]);
        int monthIndex = 0;
        String[] towns = {"Los Angeles","New York","Caracas","Buenos Aires","London","Rome","Moscow","Tehran","New Delhi","Beijing","Canberra"};
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int[] townsTime = {-480,-300,-270,-180,0,60,180,210,330,480,600};
        int indexOne = 0, indexTwo = 0;
        for (int i = 0;i < towns.length;i++)
        {
            if (towns[i].equals(townA))
                indexOne = i;
            if (towns[i].equals(townB))
                indexTwo = i;
        }

        for (int i = 0;i < months.length;i++)
        {
            if (monthS.equals(months[i]))
                monthIndex = i;
        }

        Calendar calendar = new GregorianCalendar(year, monthIndex , dateNum);
        calendar.set(Calendar.HOUR,hour);
        calendar.set(Calendar.MINUTE,minutes);


        calendar.add(Calendar.MINUTE,Math.max(townsTime[indexOne],townsTime[indexTwo]) - Math.min(townsTime[indexOne],townsTime[indexTwo]));
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-M-d HH:mm");
        answer = formater.format(calendar.getTime());
        return answer;
    }
    // Задание 10
    // Новое число-это число, которое не является перестановкой любого меньшего
    // числа. 869-это не новое число, потому что это просто перестановка меньших чисел,
    // 689 и 698. 509-это новое число, потому что оно не может быть образовано
    // перестановкой любого меньшего числа (ведущие нули не допускаются).
    // Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
    // если целое число является новым числом, и false, если это не так.
    public static boolean isNew(int num) {
        int count =0;
        String str = Integer.toString(num);
        str = str.replaceAll("0", "");

        String[] numb = str.split("");

        int[] numArr = new int[numb.length];

        for (int i = 0; i < numb.length; i++)
            numArr[i] = Integer.parseInt(numb[i]);

        for (int i =0; i < numArr.length-1; i++)
        {
            if (numArr[i] > numArr[i+1])
                count = count +1;
        }
        return count <= 0;
    }
}

