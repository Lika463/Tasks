package ru.daliya.Sixth_tasks;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class tasks {
    public static void main(String[] args) {
        System.out.println ("Задание №1. ");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.",
                "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        System.out.println ("Задание №2. ");
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        System.out.println ("Задание №3. ");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println ("Задание №4. ");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15, 3}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));

        System.out.println ("Задание №5. ");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println ("Задание №6. ");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println ("Задание №7. ");
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));

        System.out.println ("Задание №8. ");
        System.out.println(generateNonconsecutive(1));
        System.out.println(generateNonconsecutive(2));
        System.out.println(generateNonconsecutive(3));
        System.out.println(generateNonconsecutive(4));

        System.out.println ("Задание №9. ");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println ("Задание №10. ");
        System.out.println(sumsUp(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(sumsUp(new int[] { 1, 2, 3, 7, 9 }));
        System.out.println(sumsUp(new int[] { 10, 9, 7, 2, 8 }));
        System.out.println(sumsUp(new int[] { 1, 6, 5, 4, 8, 2, 3, 7 }));
    }

    // Задание 1
    public static String hiddenAnagram(String str, String anagramLettersStr) {
        //Игнорируйте регистр символов и любые встроенные не-альфа-символы.
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        anagramLettersStr = anagramLettersStr.toLowerCase().replaceAll("[^a-z]", "");

        //создаём лист чаров из 2 строки
        List<Character> anagramChars = anagramLettersStr.chars()
                .mapToObj(it -> (char) it)//заполнение символами
                .collect(Collectors.toList());//проеобразование к коллекции типа лист

        StringBuilder resultBuilder = new StringBuilder();
        boolean isResultFound = false;

        for (int i = 0; i < str.length() && !isResultFound; i++) {
            //resultBuilder = new StringBuilder();
            List<Character> tempAnagramChars = new ArrayList<>(anagramChars);
            for (int j = i; j < str.length(); j++) {
                char symbol = str.charAt(j);
                if (tempAnagramChars.contains(symbol)) {//если содержит лист символ джитый
                    resultBuilder.append(symbol);//+=
                    tempAnagramChars.remove(Character.valueOf(symbol));//удаляем
                    if (tempAnagramChars.isEmpty()) {//возвращает true, если этот список не содержит элементов
                        isResultFound = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return isResultFound ? resultBuilder.toString() : "noutfond";
    }

    // Задание 2
    public static String[] collect(String str, int razrez)
    {
        String[] arr;
        //Возвращает пустой массив, если заданная строка меньше n
        if (str.length() < razrez)
        {
            arr = new String[1];
        }
        else
        {
            arr = new String[str.length() / razrez];//размерность
            arr[0] = str.substring(0, razrez);
            String[] otherArr = collect(str.substring(razrez), razrez);//массив от razrez до конца
            for (int i=1; i< arr.length; i++)
            {
                if (otherArr.length > i-1)
                {
                    arr[i] = otherArr[i-1];
                }
            }
            //Убедитесь, что результирующий массив лексикографически упорядочен
            Arrays.sort(arr);
        }
        return arr;
    }

    // Задание 3
    public static String nicoCipher(String message, String key) {
        message = message.replaceAll(" ", "");
        char[] messageChars = message.toCharArray();

        //заполнение символами и проеобразование к коллекции типа лист
        List<Character> keys = key.chars().mapToObj(it -> (char) it).collect(Collectors.toList());
        //возвращает отсортированные данные
        List<Character> sortedKeys = keys.stream().sorted().collect(Collectors.toList());

        Map<Integer, char[]> columns = new HashMap<>();
        //округляет дробь в большую сторону
        int rowsCount = (int) Math.ceil(messageChars.length / (double) keys.size());

        for (int i = 0; i < keys.size(); i++) {
            char[] columnChars = new char[rowsCount];
            Arrays.fill(columnChars, ' ');//заполнение массива
            for (int j = i; j < messageChars.length; j += keys.size()) {
                columnChars[j / keys.size()] = messageChars[j];
            }
            //Найти в строке символ и его индекс
            int index = sortedKeys.indexOf(keys.get(i));
            columns.put(index, columnChars);
            sortedKeys.set(index, ' ');//добав эл в колл, если нет
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columns.size(); j++) {
                //обновление значения объекта +
                resultBuilder.append(columns.get(j)[i]);
            }
        }
        return resultBuilder.toString();
    }

    // Задание 4
    public static int[] twoProduct(int[] arr, int n) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] * arr[i] == n) return new int[] {arr[j], arr[i]};
            }
        }
        return new int[0];
    }

    // Задание 5
    public static int[] isExact(int n) {
        try {
            return new int[] { n, isExact(n, 2) };
        } catch (Exception e) {
            return new int[0];
        }
    }

    private static int isExact(float n, float divider) {
        float result = n / divider;

        if (result > 1) return isExact(result, ++divider);
        else if (result == 1) return (int)n;
        else throw new IllegalArgumentException("Первый аргумент не является факториалом!");
    }

    // Задание 6

    public static String fractions(String chislo)
    {
        int dotIndex = chislo.indexOf(".");//ищем индекс .
        int bracketIndex = chislo.indexOf("(");
        //преобразует строку в число и возвращает новую строку, которая является подстрокой данной строки
        int wholePart = Integer.parseInt(chislo.substring(0, dotIndex));
        String unrepeatPart = chislo.substring(dotIndex + 1, bracketIndex);
        String repeatPart = chislo.substring(bracketIndex + 1, chislo.length() - 1);
        int firstBit = 0;
        if (unrepeatPart.length() > 0)
        {
            firstBit = Integer.parseInt(unrepeatPart);
        }
        int chisl = Integer.parseInt(unrepeatPart+repeatPart) - firstBit;
        String znam_str = "";
        for (int i=0; i < repeatPart.length(); i++)
        {
            znam_str += "9";
        }
        for (int i=0; i < unrepeatPart.length(); i++)
        {
            znam_str += "0";
        }
        int znam = Integer.parseInt(znam_str);
        int k = 2;
        int t = Math.max(chisl, znam);//максимальное число из двух
        while (k < t)
        {
            if (chisl % k == 0 && znam % k == 0)
            {
                chisl /= k;
                znam /= k;
            }
            else
            {
                k++;
            }

        }
        return Integer.toString(wholePart*znam + chisl) + "/" + Integer.toString(znam);
    }

    // Задание 7
    public static String pilish_string(String s)
    {
        String  Pi = "314159265358979";
        String ans = "";
        if (s.length() == 0)
        {
            return ans;
        }
        int currentIndex = 0;
        for(int i=0; i<Pi.length(); i++)
        {
            int bitSize = Integer.parseInt(Pi.substring(i, i+1));
            int sLostLen = s.substring(currentIndex, s.length()).length();
            if (sLostLen == 0)
            {
                break;
            }
            if (sLostLen < bitSize)
            {
                String repeat = s.substring(s.length()-1);
                String dop = repeat;
                ans += s.substring(currentIndex, s.length());
                for (int j=1; j < bitSize - sLostLen ; j++ )
                {
                    dop += repeat;
                }
                ans += dop;
                break;
            }
            else
            {
                ans += s.substring(currentIndex, currentIndex + bitSize) + " ";
            }
            currentIndex += bitSize;
        }
        return ans;
    }

    // Задание 8
    public static String generateNonconsecutive(int binary_chislo)
    {
        return recurse(binary_chislo,false,"");
    }

    public static String recurse(int binary_chislo, boolean isOne,String s)
    {
        if(binary_chislo == 1)
        {
            if(isOne)
            {
                return s + "0 ";
            }
            else
            {
                return s + "0" + " " + s + "1 ";
            }
        }
        if (isOne)
        {
            return recurse(binary_chislo - 1, false, s + "0");
        }
        else
        {
            return recurse(binary_chislo - 1, false, s + "0") + recurse(binary_chislo - 1, true, s + "1");
        }
    }

    // Задание 9
    public static String isValid(String s1)
    {
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i=0; i< s1.length(); i++)
        {
            String sym = s1.substring(i, i+1);
            //возвращает заданное представление ключей, содержащихся в этой карте
            //Возвращает истину, если этот набор содержит указанный элемент
            if (dictionary.keySet().contains(sym))
            {
                int old = dictionary.get(sym);
                //по ключу заменяет все символы в строке
                dictionary.replace(sym, old, old+1);
            }
            else
            {
                dictionary.put(sym, 1);
            }
        }
        int count = 0;
        int sum = 0;
        int mis = 0;
        String ans = "YES";
        //проходимся по значениям
        for (int value: dictionary.values())
        {
            if (count != 0 && Math.abs(sum / count - value) > 1 )
            {
                ans = "NO";
                break;
            }
            sum+= value;
            count++;
            if ( (double) sum/ count != sum / count)
            {
                mis++;
                sum -= value;
                count--;
                if (mis > 1)
                {
                    ans = "NO";
                    break;
                }
            }
        }
        return ans;
    }


    // Задание 10
    public static String sumsUp(int[] arr)
    {
        String ans = "[";
        List<int[]> newA = new ArrayList<int[]>();
        for (int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]+arr[j]==8)
                {
                    int[] pair = {Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
                    newA.add(pair);
                }
            }
        }
        for(int[] el: newA)
        {
            ans += Arrays.toString(el) + " ";
        }
        ans += "]";
        return ans;
    }
}

