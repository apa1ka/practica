package org.example;

public class Main {
    public static void main(String[] args) {
        Point center = new Point(0, 0);
        double radius = 5;
        Circle circle = new Circle(center, radius);
        System.out.println("Круг: " + circle);

        Point point1 = new Point(3, 4);
        Point point2 = new Point(6, 8);

        System.out.println("Точка " + point1 + (circle.contains(point1) ? " принадлежит " : " не принадлежит ") + "кругу");
        System.out.println("Точка " + point2 + (circle.contains(point2) ? " принадлежит " : " не принадлежит ") + "кругу");

        circle.setRadius(10);
        System.out.println("Круг: " + circle);
    }
}
