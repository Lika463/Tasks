package ru.daliya.lab5;

public class Complex {
    public double x;
    public double y;

    Complex() {
        x = 0;
        y = 0;
    }

    Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Complex sum(Complex other) {
        Complex complex = new Complex();
        complex.x = this.x + other.x;
        complex.y = this.y + other.y;
        return complex;
    }

    public Complex step2() {
        double temp = x;
        x = x * x - y * y;
        y = 2 * temp * y;
        return this;
    }

    public boolean isMoreThan(double other) {
        return (x * x + y * y) > other * other;
    }
}