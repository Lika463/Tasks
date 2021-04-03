package ru.daliya.lab4;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator{
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
    }

    @Override
//    реализует итеративную
//    функцию для фрактала Мандельброта
    public int numIterations(double x, double y) {
        return 0;
    }
    void getInitialRange(){

    }
    public static final int MAX_ITERATIONS = 2000;
    void numIterations(){

    }
}
