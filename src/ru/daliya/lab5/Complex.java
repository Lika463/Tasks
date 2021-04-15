package ru.daliya.lab5;

import static java.lang.Math.abs;

public class Complex {
    public double x;
    public double y;

    Complex() {
        x = 0;
        y = 0;
    }

    public Complex(double x, double y) {
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

    public Complex step2sopr() {
        double temp = x;
        x = x * x - y * y;
        y = -2 * temp * y;
        return this;
    }

    public Complex AbsImAndReParts() {
        x = abs(x);
        y = abs(y);
        return this;
    }

    public boolean isMoreThan(double other) {
        return (x * x + y * y) > other * other;
    }
}