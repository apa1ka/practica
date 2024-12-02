package org.example;

import java.util.Objects;

class Окружность {
    private Точка центр;
    private double радиус;

    public Окружность(Точка центр, double радиус) throws InvalidRadiusException {
        if (радиус <= 0) {
            throw new InvalidRadiusException("Радиус должен быть положительным числом.");
        }
        this.центр = центр;
        this.радиус = радиус;
    }

    public Точка getЦентр() {
        return центр;
    }

    public double getРадиус() {
        return радиус;
    }

    public void setРадиус(double радиус) throws InvalidRadiusException {
        if (радиус <= 0) {
            throw new InvalidRadiusException("Радиус должен быть положительным числом.");
        }
        this.радиус = радиус;
    }

    // Остальные методы остаются без изменений
}


