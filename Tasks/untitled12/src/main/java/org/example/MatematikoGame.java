package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatematikoGame extends JFrame implements ActionListener {
    private Deck deck;
    private PlayerGrid playerGrid;
    private PlayerGrid computerGrid;
    private JLabel currentNumberLabel;
    private JButton nextNumberButton;
    protected int currentNumber;
    private ComputerPlayer computerPlayer;
    private boolean gameEnded;

    public MatematikoGame() {
        setTitle("Математико");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());

        deck = new Deck();
        playerGrid = new PlayerGrid("Ваше поле", this);
        computerGrid = new PlayerGrid("Поле компьютера", this);
        computerPlayer = new ComputerPlayer();

        // Верхняя панель с текущим числом и кнопкой
        JPanel topPanel = new JPanel();
        currentNumberLabel = new JLabel("Нажмите 'Следующее число' для начала игры");
        currentNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nextNumberButton = new JButton("Следующее число");
        nextNumberButton.addActionListener(this);
        topPanel.add(currentNumberLabel);
        topPanel.add(nextNumberButton);

        // Центральная панель с полями игрока и компьютера
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(playerGrid);
        centerPanel.add(computerGrid);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        gameEnded = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameEnded) {
            if (deck.hasNext()) {
                currentNumber = deck.drawCard();
                currentNumberLabel.setText("Текущее число: " + currentNumber);

                // Ход компьютера
                boolean computerMoved = computerPlayer.makeMove(computerGrid, currentNumber);

                // Активируем возможность игроку сделать ход
                playerGrid.enableCells(currentNumber);
                nextNumberButton.setEnabled(false);

                // Если компьютер не смог сделать ход (поле заполнено)
                if (!computerMoved) {
                    proceedToNextNumber();
                }
            }
        }
    }
    public void proceedToNextNumber() {
        nextNumberButton.setEnabled(true);
        playerGrid.disableCells();

        // Проверяем, заполнены ли поля
        if (playerGrid.isFull() && computerGrid.isFull()) {
            gameEnded = true;
            currentNumberLabel.setText("Игра окончена!");
            nextNumberButton.setEnabled(false);

            // Подсчет очков
            int playerScore = Scoring.calculateScore(playerGrid);
            int computerScore = Scoring.calculateScore(computerGrid);

            // Отображение результатов
            JOptionPane.showMessageDialog(this,
                    "Ваши очки: " + playerScore + "\nОчки компьютера: " + computerScore,
                    "Результаты игры",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void playerMadeMove() {
        // Этот метод вызывается после того, как игрок сделал ход
        proceedToNextNumber();
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MatematikoGame game = new MatematikoGame();
            game.setVisible(true);
        });
    }
}

