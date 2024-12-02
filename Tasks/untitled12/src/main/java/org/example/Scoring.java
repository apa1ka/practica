package org.example;

import java.util.*;

public class Scoring {
    public static int calculateScore(PlayerGrid grid) {
        int[][] numbers = grid.getNumbers();
        int totalScore = 0;

        // Проверка строк и столбцов
        for (int i = 0; i < 5; i++) {
            int[] row = numbers[i];
            int[] column = new int[5];
            for (int j = 0; j < 5; j++) {
                column[j] = numbers[j][i];
            }
            totalScore += calculateLineScore(row, false);
            totalScore += calculateLineScore(column, false);
        }

        // Проверка диагоналей
        int[] diag1 = new int[5];
        int[] diag2 = new int[5];
        for (int i = 0; i < 5; i++) {
            diag1[i] = numbers[i][i];
            diag2[i] = numbers[i][4 - i];
        }
        totalScore += calculateLineScore(diag1, true);
        totalScore += calculateLineScore(diag2, true);

        return totalScore;
    }

    private static int calculateLineScore(int[] line, boolean isDiagonal) {
        int score = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : line) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Список чисел в линии
        List<Integer> numbersList = new ArrayList<>();
        for (int num : line) {
            numbersList.add(num);
        }

        // Флаг, чтобы избежать двойного начисления очков за одну линию
        boolean scored = false;

        // 1. За 4 единицы
        if (!scored && Collections.frequency(numbersList, 1) == 4) {
            score += isDiagonal ? 210 : 200;
            scored = true;
        }

        // 2. За числа 1, 13, 12, 11 и 10
        if (!scored && numbersList.containsAll(Arrays.asList(1, 10, 11, 12, 13))) {
            score += isDiagonal ? 160 : 150;
            scored = true;
        }

        // 3. За три раза по 1 и два раза по 13
        if (!scored && Collections.frequency(numbersList, 1) == 3 && Collections.frequency(numbersList, 13) == 2) {
            score += isDiagonal ? 110 : 100;
            scored = true;
        }

        // 4. За 5 последовательных чисел
        if (!scored && isSequence(numbersList)) {
            score += isDiagonal ? 60 : 50;
            scored = true;
        }

        // 5. За 4 одинаковых числа
        if (!scored && counts.containsValue(4)) {
            score += isDiagonal ? 170 : 160;
            scored = true;
        }

        // 6. За 3 одинаковых числа и два других одинаковых числа
        if (!scored && counts.size() == 2 && counts.containsValue(3) && counts.containsValue(2)) {
            score += isDiagonal ? 90 : 80;
            scored = true;
        }

        // 7. За 3 одинаковых числа
        if (!scored && counts.containsValue(3)) {
            score += isDiagonal ? 50 : 40;
            scored = true;
        }

        // 8. За 2 пары одинаковых чисел
        if (!scored && counts.size() == 3 && Collections.frequency(new ArrayList<>(counts.values()), 2) == 2) {
            score += isDiagonal ? 30 : 20;
            scored = true;
        }

        // 9. За 2 одинаковых числа
        if (!scored && counts.containsValue(2)) {
            score += isDiagonal ? 20 : 10;
            scored = true;
        }

        return score;
    }

    // Метод для проверки, являются ли числа последовательными
    private static boolean isSequence(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 5) {
            return false;
        }
        List<Integer> sortedNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedNumbers);
        for (int i = 0; i < sortedNumbers.size() - 1; i++) {
            if (sortedNumbers.get(i + 1) - sortedNumbers.get(i) != 1) {
                return false;
            }
        }
        return true;
    }
}

