package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "Java - это язык программирования. Java очень популярна.";

        // разбиваем текст на слова и удаляем знаки препинания
        String[] words = text.split("[\\s.,!?]+");

        // создаем Map для хранения количества повторений слов
        Map<String, Integer> wordCount = new HashMap<>();

        // проходим по всем словам и увеличиваем их количество в Map
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        // выводим результаты на консоль
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " раз");
        }
    }
}
