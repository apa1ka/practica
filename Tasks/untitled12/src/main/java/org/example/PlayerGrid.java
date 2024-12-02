package org.example;

import javax.swing.*;
import java.awt.*;

public class PlayerGrid extends JPanel {
    protected JButton[][] cells;
    private String name;
    private int[][] numbers;
    private MatematikoGame gameInstance;

    public PlayerGrid(String name, MatematikoGame gameInstance) {
        this.name = name;
        this.gameInstance = gameInstance;
        this.numbers = new int[5][5];
        setLayout(new BorderLayout());
        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(nameLabel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(5, 5));
        cells = new JButton[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cells[i][j] = new JButton("");
                cells[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                cells[i][j].setEnabled(false);
                gridPanel.add(cells[i][j]);

                int row = i;
                int col = j;

                // Для игрока добавляем ActionListener
                if (name.equals("Ваше поле")) {
                    cells[i][j].addActionListener(e -> {
                        if (cells[row][col].isEnabled()) {
                            int currentNumber = gameInstance.getCurrentNumber();
                            cells[row][col].setText(String.valueOf(currentNumber));
                            numbers[row][col] = currentNumber;
                            cells[row][col].setEnabled(false);
                            gameInstance.playerMadeMove(); // Вызываем метод после хода игрока
                        }
                    });
                }
            }
        }
        add(gridPanel, BorderLayout.CENTER);
    }

    public void enableCells(int number) {
        if (name.equals("Ваше поле")) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (cells[i][j].getText().equals("")) {
                        cells[i][j].setEnabled(true);
                    }
                }
            }
        }
    }

    public void disableCells() {
        if (name.equals("Ваше поле")) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    cells[i][j].setEnabled(false);
                }
            }
        }
    }

    public void setNumber(int row, int col, int number) {
        cells[row][col].setText(String.valueOf(number));
        numbers[row][col] = number;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    public boolean isFull() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cells[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
}

