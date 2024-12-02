package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    public boolean makeMove(PlayerGrid grid, int number) {
        Random random = new Random();
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid.cells[i][j].getText().equals("")) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }
        if (emptyCells.isEmpty()) {
            return false; // Нет доступных клеток
        } else {
            int[] cell = emptyCells.get(random.nextInt(emptyCells.size()));
            grid.setNumber(cell[0], cell[1], number);
            return true;
        }
    }
}

