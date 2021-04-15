package ru.daliya.lab5.fractals;

import ru.daliya.lab5.Complex;
import ru.daliya.lab5.FractalGenerator;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.height = 3;
        range.width = 3;
    }


    //    реализует итеративную
    //    функцию для фрактала Мандельброта
    @Override
    public int numIterations(double x, double y) {
        int iterations = 0;
        Complex c = new Complex(x, y);
        Complex z = new Complex(0, 0);
        while (iterations < MAX_ITERATIONS) {
            iterations++;
            z = z.step2().sum(c);
            if (z.isMoreThan(2)) {
                return iterations;
            }
        }
        return -1;

    }

    @Override
    public String toString() {
        return "Mandelbrot";
    }
}
