package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Точка центр = new Точка(0, 0);
            Круг круг = new Круг(центр, 5);

            Точка точка1 = new Точка(3, 4);
            Точка точка2 = new Точка(6, 8);

            System.out.println("Точка (3, 4) принадлежит кругу: " + круг.принадлежитТочка(точка1)); // true
            System.out.println("Точка (6, 8) принадлежит кругу: " + круг.принадлежитТочка(точка2)); // false

            круг.изменитьРадиус(10);
            System.out.println("Изменен радиус круга на 10");

            System.out.println("Точка (6, 8) принадлежит кругу: " + круг.принадлежитТочка(точка2)); // true

            System.out.println(круг); // Вывод информации о круге

            // Пример с недопустимым радиусом
            круг.изменитьРадиус(-5); // Это вызовет исключение

        } catch (InvalidRadiusException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (PointOutOfBoundsException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}

