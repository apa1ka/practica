package org.example;

import java.io.*;

public class FileHandler {
    public void saveCircleToFile(Круг круг, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(круг);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public Круг loadCircleFromFile(String filename) throws CircleNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Круг) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new CircleNotFoundException("Файл не найден: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка чтения из файла: " + e.getMessage());
            return null;
        }
    }
}

