package ru.daliya.lab2;
import java.util.Scanner;
public class laba2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите x1: ");
        String str = scan.nextLine();
        double x1 = Double.parseDouble(str);
        System.out.println("Введите y1: ");
        str = scan.nextLine();
        double y1 = Double.parseDouble(str);
        System.out.println("Введите z1: ");
        str = scan.nextLine();
        double z1 = Double.parseDouble(str);
        System.out.println("Введите x2: ");
        str = scan.nextLine();
        double x2 = Double.parseDouble(str);
        System.out.println("Введите y2: ");
        str = scan.nextLine();
        double y2 = Double.parseDouble(str);
        System.out.println("Введите z2: ");
        str = scan.nextLine();
        double z2 = Double.parseDouble(str);
        System.out.println("Введите x3: ");
        str = scan.nextLine();
        double x3 = Double.parseDouble(str);
        System.out.println("Введите y3: ");
        str = scan.nextLine();
        double y3 = Double.parseDouble(str);
        System.out.println("Введите z3: ");
        str = scan.nextLine();
        double z3 = Double.parseDouble(str);
        scan.close();
        Point3D coordinate1 = new Point3D(x1, y1, z1);
        Point3D coordinate2 = new Point3D(x2, y2, z2);
        Point3D coordinate3 = new Point3D(x3, y3, z3);
        if (!coordinate1.CompareCoord3d(coordinate2) && !coordinate2.CompareCoord3d(coordinate3) && !coordinate3.CompareCoord3d(coordinate1)) {
            System.out.println("Площадь треугольника: " + computeArea(coordinate1, coordinate2, coordinate3));
        } else {
            System.out.println("Ошибка, проверьте правильность введённых координат.");
        }

    }
    //принимает
    //три объекта типа Point3d и вычисляет площадь треугольника, образованного
    //этими точками
    public static Double computeArea(Point3D object1, Point3D object2, Point3D object3) {
        double a = object1.distanceTo(object2);
        double b = object2.distanceTo(object3);
        double c = object3.distanceTo(object1);
        double p = (a + b + c) / 2.0D;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    }

