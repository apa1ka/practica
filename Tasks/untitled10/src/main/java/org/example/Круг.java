package org.example;

import java.util.Objects;

class Круг {
    private Окружность окружность;

    public Круг(Точка центр, double радиус) throws InvalidRadiusException {
        this.окружность = new Окружность(центр, радиус);
    }

    public void задатьРазмеры(Точка центр, double радиус) throws InvalidRadiusException {
        this.окружность = new Окружность(центр, радиус);
    }

    public void изменитьРадиус(double новыйРадиус) throws InvalidRadiusException {
        окружность.setРадиус(новыйРадиус);
    }

    public boolean принадлежитТочка(Точка точка) throws PointOutOfBoundsException {
        if (точка == null) {
            throw new PointOutOfBoundsException("Точка не может быть null.");
        }
        double dx = точка.getX() - окружность.getЦентр().getX();
        double dy = точка.getY() - окружность.getЦентр().getY();
        double расстояниеКвадрат = dx * dx + dy * dy;
        double радиусКвадрат = окружность.getРадиус() * окружность.getРадиус();
        return расстояниеКвадрат <= радиусКвадрат;
    }

    // Остальные методы остаются без изменений
}


