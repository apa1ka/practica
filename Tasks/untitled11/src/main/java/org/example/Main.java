package org.example;

public class Main {

    private double real;
    private double imaginary;

    // Конструктор для double
    public Main(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Конструктор для int
    public Main(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Методы-геттеры
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // Метод сложения
    public Main add(Main other) {
        return new Main(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Метод вычитания
    public Main subtract(Main other) {
        return new Main(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Метод умножения
    public Main multiply(Main other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new Main(newReal, newImaginary);
    }

    // Переопределение метода toString() для удобного вывода
    @Override
    public String toString() {
        return "(" + real + (imaginary >= 0 ? "+" : "") + imaginary + "i)";
    }


    public static void main(String[] args) {
        Main c1 = new Main(2.5, 3.0);
        Main c2 = new Main(1, -2);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        System.out.println("c1 + c2 = " + c1.add(c2));
        System.out.println("c1 - c2 = " + c1.subtract(c2));
        System.out.println("c1 * c2 = " + c1.multiply(c2));


        Main c3 = new Main(5, 2);
        Main c4 = new Main(3,4);

        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);

        System.out.println("c3 + c4 = " + c3.add(c4));
        System.out.println("c3 - c4 = " + c3.subtract(c4));
        System.out.println("c3 * c4 = " + c3.multiply(c4));
    }
}






