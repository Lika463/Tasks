package ru.daliya.lab2;

public class Point2D {
    protected double xCoord;
    protected double yCoord;

    //двумерный класс точки
    public Point2D(double x, double y) {
        this.xCoord = x;
        this.yCoord = y;
    }
    //Конструктор по умолчанию.
    public Point2D() {
        this(0.0D, 0.0D);
    }

    //Возвращение координаты X
    public double getX() {
        return this.xCoord;
    }

    //Возвращение координаты Y
    public double getY() {
        return this.yCoord;
    }

    //Установка значения координаты X
    public void setX(double val) {
        this.xCoord = val;
    }

    //Установка значения координаты Y
    public void setY(double val) {
        this.yCoord = val;
    }
    //сравнение значения полей класса Point2D
    public boolean isEqual2D(Point2D object) {
        return this.xCoord == object.xCoord && this.yCoord == object.yCoord;
    }

}

