package org.example;

import java.util.Objects;

class Точка {
    private double x;
    private double y;

    public Точка(double x, double y) throws PointOutOfBoundsException {
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new PointOutOfBoundsException("Координаты не могут быть NaN.");
        }
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) throws PointOutOfBoundsException {
        if (Double.isNaN(x)) {
            throw new PointOutOfBoundsException("Координата X не может быть NaN.");
        }
        this.x = x;
    }

    public void setY(double y) throws PointOutOfBoundsException {
        if (Double.isNaN(y)) {
            throw new PointOutOfBoundsException("Координата Y не может быть NaN.");
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "Точка(" + x + ", " + y + ")";
    }
}


