package ru.daliya.lab2;

public class Point3D extends Point2D{

    private double zCoord;
    //трехмерный класс точки
    public Point3D(double x, double y, double z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }
    // создание нового объекта Point3d с тремя значениями с плавающей точкой (double)
    public Point3D() {
        this(0.0D, 0.0D, 0.0D);
    }
    //Возвращение координаты Z
    public double getZ() {
        return this.zCoord;
    }
    //Установка значения координаты Z
    public void SetZ(double val) {
        this.zCoord = val;
    }
    //   метод для сравнения значений двух объектов Point3d
    public boolean CompareCoord3d(Point3D object) {
        return this.xCoord == object.xCoord && this.yCoord == object.yCoord && this.zCoord == object.zCoord;
    }
    //вычисляет расстояние между двумя точками
    //с точность двух знаков после запятой и возвращает полученное значение.
    public double distanceTo(Point3D object) {
        return Math.floor(Math.sqrt(Math.pow(object.xCoord - this.xCoord, 2.0D) + Math.pow(object.yCoord - this.yCoord, 2.0D) + Math.pow(object.zCoord - this.zCoord, 2.0D)) * 100.0D) / 100.0D;
    }


}
