package ru.daliya.lab7;

import java.net.*;
import java.util.*;
import java.io.*;

/**
 Этот класс реализует основные функции нашего приложения-поискового робота.
 Он имеет метод getAllLinks для хранения всех ссылок на данной веб-странице в
 дополнение к основному методу, отслеживающему важные переменные.
 */
public class Crawler {

    /**
     * Основной метод Crawler. Программа должна принимать строку представляющую собой URL-адрес,
     * с которого следует начать просмотр, и положительное целое число
     * обозначающее максимальную глубину поиска. Отслеживает обработанные ссылки, ожидающие ссылки,
     * ссылки просмотреные и глубину. Выписывает список всех обработанных ссылок
     * с их глубиной. Перебирает ожидающие URL-адреса для getAllLinks и добавляет
     * их на обработанные URL и просмотренные URL.
     */
    public static void main(String[] args1) {

        String args[] = new String[2];
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter URL: ");
        args[0] = scanstr.nextLine();
        System.out.println("Enter the depth: ");
        args[1] = scanstr.nextLine();
        // Переменная для текущей глубины.
        int depth = 0;

        // Проверяет правильность длины ввода.
        if (args.length != 2) {
            System.out.println("usage: java Crawler <URL> <depth>");
            System.exit(1);
        }
        // Если ввод правильный, продолжаем.
        else {
            try {
                // Преобразование строкового аргумента в целочисленное значение.
                depth = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException nfe) {
                // Второй аргумент не является допустимым целым числом. Остановить и
                //вывести сообщение.
                System.out.println("usage: java Crawler <URL> <depth>");
                System.exit(1);
            }
        }

        // Связанный список для представления ожидающих URL.
        LinkedList<URLDepthPair> pendingURLs = new LinkedList<URLDepthPair>();

        // Связанный список для представления обработанных URL-адресов.
        LinkedList<URLDepthPair> processedURLs = new LinkedList<URLDepthPair>();

        // Пара глубины URL-адреса для представления веб-сайта, введенного пользователем
        //с глубиной 0.
        URLDepthPair currentDepthPair = new URLDepthPair(args[0], 0);

        // Добавляем текущий веб-сайт из пользовательского ввода в ожидающие URL-адреса.
        pendingURLs.add(currentDepthPair);

        // Список массивов для представления просмотренных URL. Добавить текущий сайт
        ArrayList<String> seenURLs = new ArrayList<String>();
        seenURLs.add(currentDepthPair.getURL());

        // Пока pendingURL не пустой, перебираем, посещаем каждый веб-сайт,
        //и получаем все ссылки из каждого.
        while (pendingURLs.size() != 0) {

            // Получаем следующий URL из pendingURL, добавляем к обработанным URL и
            //сохраняем его глубину.
            URLDepthPair depthPair = pendingURLs.pop();
            processedURLs.add(depthPair);
            int myDepth = depthPair.getDepth();

            // Получаем все ссылки с сайта и сохраняем их в новом связанном списке.
            LinkedList<String> linksList = new LinkedList<String>();
            linksList = Crawler.getAllLinks(depthPair);

            // Если мы не достигли максимальной глубины, добавляем ссылки с сайта
            //            // которые ранее не просматривались в pendingURLs и visibleURL.
            if (myDepth < depth) {
                // Перебираем ссылки с сайта.
                for (int i=0;i<linksList.size();i++) {
                    String newURL = linksList.get(i);
                    // Если мы уже видели ссылку, продолжаем.
                    if (seenURLs.contains(newURL)) {
                        continue;
                    }
                    // Если мы не видели ссылку, создаем новый URLDepthPair
                    //                    // с глубиной на единицу больше текущей глубины и добавляем
                    //                    // к ожидающим URL и просмотренным URL.
                    else {
                        URLDepthPair newDepthPair = new URLDepthPair(newURL, myDepth + 1);
                        pendingURLs.add(newDepthPair);
                        seenURLs.add(newURL);
                    }
                }
            }
        }
        // Распечатать все обработанные URL с глубиной.
        Iterator<URLDepthPair> iter = processedURLs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    /**
     * Метод, который принимает URLDepthPair и возвращает LinkedList из String
     * тип. Подключается к сайту в URLDepthPair, находит все ссылки
     * на сайте и добавляет их в новый LinkedList, который возвращается.
     */
    private static LinkedList<String> getAllLinks(URLDepthPair myDepthPair) {

        //Массив со ссылками на странице
        LinkedList<String> URLs = new LinkedList<String>();

    // Инициализация сокета
        Socket socket;

    //Создание пары: хост и порт
        try {
            socket = new Socket(myDepthPair.getWebHost(), 80);
        }
    //Ошибка UnknownHostException:
        catch (UnknownHostException e) {
            System.err.println("UnknownHostException: " + e.getMessage());
            return URLs;
        }
        //  Поймать IOException и вернуть пустой список.
        //Ошибка IOException
        catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
            return URLs;
        }

        //После установки соединения с сервером готовмися выполнить запрос
        //Также устанавливаем таймаут, чтобы не пришлось долго ждать ответа
        //(это тормозит поток)
        try {
            socket.setSoTimeout(3000);
        }
        catch (SocketException exc) {
            System.err.println("SocketException: " + exc.getMessage());
            return URLs;
        }

        //Определяем вебхост и путь до документа, чтобы выоплнить запрос
        String docPath = myDepthPair.getDocPath();
        String webHost = myDepthPair.getWebHost();

//Инициализация OutputStream
        OutputStream outStream;

        //Поток вывода данных, через него реализуется отправка запроса
        try {
            outStream = socket.getOutputStream();
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return URLs;
        }

        //Формирование http запроса на сервер
//true значит, что файл будет закрыт автоматически
        PrintWriter req = new PrintWriter(outStream, true);
        req.println("GET " + docPath + " HTTP/1.1");
        req.println("Host: " + webHost);
        req.println("Connection: close");
        req.println();

        //Дальше следует обработка входящих данных с сервера
//Реализовано с использованием inputStream
        InputStream inStream;
        try {
            inStream = socket.getInputStream();
        }
        catch (IOException e){
            System.err.println("IOException: " + e.getMessage());
            return URLs;
        }

        //В buffReader хранится ответа сервера и оттуда происходит чтение
        InputStreamReader inStreamReader = new InputStreamReader(inStream);
        BufferedReader BuffReader = new BufferedReader(inStreamReader);

//Обработка ответа будет проходить до конца, пока не закончится текст
        while (true) {
//Раз за разом читаем строку
            String line;
            try {
                line = BuffReader.readLine();
            }
            catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
                return URLs;
            }
//Если строка пустая, то это конец ответа
            if (line == null)
                break;
//Инициализация переменных для отбора ссылок
            int beginIndex = 0; //индекс начала ссылки
            int endIndex = 0; //индекс конца ссылки
            int index = 0; //текущий индекс

            //Поиск всех ссылок в строке проходит пока они не закончатся
            while (true) {
//так начинается и заканчивается ссылка в html коде
                String START_URL = "a href=\"";
                String END_URL = "\"";

//Определение начала ссылки, начиная с текущей
//Если больше нет - закончить
                index = line.indexOf(START_URL, index);
                if (index == -1)
                    break;

                //Определение начала и конца ссылки
                index += START_URL.length();
                beginIndex = index;

                endIndex = line.indexOf(END_URL, index);
                index = endIndex;

                //Здесь достается ссылка из текста и определяется, что с ней делать
//Либо игнорировать, либо добавить в список ссылок
                try {
                    String newLink = line.substring(beginIndex, endIndex);

//Если ссылка начинается с протокола, то всё хорошо
                    if(newLink.startsWith("http")) {

                    }else if(newLink.startsWith("tel")) { //Если с tel, то игнорируем
                        continue;
                    }else {
//Иначе - собираем ссылку до полной и добавляем
                        if(newLink.startsWith("/"))
                            newLink = "http://"+webHost+""+newLink;
                        else
                            newLink = "http://"+webHost+"/"+newLink;

                    }
//Если ссылка уже есть, то пропускаем
                    if(URLs.contains(newLink))
                        continue;
//Добавляем
                    URLs.add(newLink);

                }catch(Exception e) {
                    System.err.println("Error while substringing: "+beginIndex + " " + endIndex);
                    break;
                }

            }

        }
        return URLs;
    }

}
