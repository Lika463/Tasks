package ru.daliya.Second_tasks;
// Теша шел по прямой улице, по обеим сторонам которой стояло ровно n
// одинаковых домов. Номера домов на улице выглядят так:
// 1 | | 6
// 3 | | 4
// 5 | | 2
// Она заметила, что четные дома увеличиваются справа, а нечетные уменьшаются слева.
// Создайте функцию, которая принимает номер дома и длину улицы n и возвращает номер
// дома на противоположной стороне.
//Пример:
// oppositeHouse(1, 3) ➞ 6
// oppositeHouse(2, 3) ➞ 5
// oppositeHouse(3, 5) ➞ 8
// oppositeHouse(5, 46) ➞ 88

public class Task1 {
    public static void main(String[] args) {
        oppositeHouse(1, 3);
        oppositeHouse(2, 3);
        oppositeHouse(3, 5);
        oppositeHouse(5, 46);
    }

    private static void oppositeHouse(int FirstNumber, int SecondNumber) {
        if (FirstNumber % 2 != 0) {
            // Ищем местоположение дома на нечетной стороне
            int currentPlace = getPlaceHouse(FirstNumber, SecondNumber, 1);

            // Ищем местоположение дома на четной стороне
            int placeOppositeHouse = getPlaceOppositeHouse(SecondNumber, currentPlace);

            // Находим номер дома на четной стороне
            getNumberOppositeHouse(SecondNumber, placeOppositeHouse, 2);
        } else {
            // Ищем местоположение дома на четной стороне
            int currentPlace = getPlaceHouse(FirstNumber, SecondNumber + 1, 2);

            // Ищем местоположение дома на нечетной стороне
            int placeOppositeHouse = getPlaceOppositeHouse(SecondNumber, currentPlace);

            // Находим номер дома на нечетной стороне
            getNumberOppositeHouse(SecondNumber, placeOppositeHouse, 1);
        }
    }

    // Отнимаем от общего числа домов (на одну сторону) порядочный номер дома с нечетной стороны и так получим
    // порядочный номер дома с четной стороны, достаточно пройтись по домам, ожидая этот порядочный номер
    private static int getPlaceOppositeHouse(int SecondNumber, int currentPlace) {
        return SecondNumber - currentPlace + 1;
    }

    private static void getNumberOppositeHouse(int SecondNumber, int placeOppositeHouse, int startNumberOppositeHouse) {
        for (int number = startNumberOppositeHouse, counter = 1; number <= SecondNumber * 2; number = number + 2, counter++) {
            if (counter == placeOppositeHouse) {
                System.out.println(number);
                break;
            }
        }
    }

    private static int getPlaceHouse(int FirstNumber, int SecondNumber, int startNumberHouse) {
        for (int number = startNumberHouse, counter = 1; number < SecondNumber * 2; number = number + 2, counter++) {
            if (number == FirstNumber) {
                return counter;
            }
        }
        return -1;
    }

}
