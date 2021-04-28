package ru.daliya.lab7;

import java.net.*;

/**
 * Класс для хранения ссылки и ее глубины
 */
public class URLDepthPair {

    /**
     * Поля, устанавливающие глубину и URL
     */
    private int currentDepth;
    private String currentURL;

    /**
     * Конструктор, который устанавливает входные данные
     */
    public URLDepthPair(String URL, int depth) {
        currentDepth = depth;
        currentURL = URL;
    }
    /**
     * Возвращает текущий URL
     */
    public String getURL() {
        return currentURL;
    }
    /**
     * Вовзращает текущее значение Depth (глубины)
     */
    public int getDepth() {
        return currentDepth;
    }
    /**
     * Возвращает текущий URL-адрес и текущую глубину в
     * формате string
     */
    public String toString() {
        String stringDepth = Integer.toString(currentDepth);
        return stringDepth + '\t' + currentURL;
    }
    /**
     * Исключения для URL-адресов,
     * которые не начинаются с «http://»
     */
    public String getDocPath() {
        try {
            URL url = new URL(currentURL);
            return url.getPath();
        }
        catch (MalformedURLException e) {
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }
    /**
     * Метод, который возвращает веб-хост текущего URL-адреса.
     */
    public String getWebHost() {
        try {
            URL url = new URL(currentURL);
            return url.getHost();
        }
        catch (MalformedURLException e) {
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }


}