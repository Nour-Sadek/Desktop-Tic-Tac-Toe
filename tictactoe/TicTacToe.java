package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.List;

public class TicTacToe extends JFrame {

    protected static final int FIELD_WIDTH = 300;
    protected static final int FIELD_HEIGHT = 300;
    private static final int GAP = 5;
    protected static final Font LABEL_RESET_FONT = new Font("Courier", Font.BOLD, 11);
    protected static GameMode gameMode = GameMode.GAME_NOT_STARTED;
    protected static JLabel statusLabel = new JLabel();
    protected static StatusStartReset startOrReset = StatusStartReset.START;
    protected static PlayerType player1 = PlayerType.HUMAN;
    protected static PlayerType player2 = PlayerType.HUMAN;
    protected static JButton startResetButton = new JButton();
    protected static JButton player1Button = new JButton();
    protected static JButton player2Button = new JButton();
    private PlayingField playingField = new PlayingField();
    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FIELD_WIDTH, FIELD_HEIGHT);
        setResizable(false);
        setLayout(new BorderLayout(5, 5));

        // Add components to the frame
        add(playingField, BorderLayout.CENTER);
        setBottomPanel();
        setUpperPanel();

        setVisible(true);
    }

    private void setUpperPanel() {
        JPanel upperPanel = new JPanel();
        upperPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, 0, GAP));
        upperPanel.setLayout(new GridLayout(1, 3, GAP * 2, GAP * 2));

        setPlayer1Button();
        upperPanel.add(player1Button);

        setStartResetButton();
        upperPanel.add(startResetButton);

        setPlayer2Button();
        upperPanel.add(player2Button);

        add(upperPanel, BorderLayout.NORTH);
    }

    private void setBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, GAP, GAP, GAP));
        bottomPanel.setLayout(new BorderLayout());

        setStatusLabel();
        bottomPanel.add(statusLabel, BorderLayout.WEST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setStatusLabel() {
        statusLabel.setName("LabelStatus");
        statusLabel.setText(gameMode.getTextLabel());
        statusLabel.setFont(LABEL_RESET_FONT);
    }

    private void setStartResetButton() {
        startResetButton.setName("ButtonStartReset");
        startResetButton.setText(startOrReset.getButtonLabel());
        startResetButton.setFocusable(false);
        startResetButton.setFont(LABEL_RESET_FONT);
        startResetButton.setBackground(Color.BLACK);
        startResetButton.setForeground(UIManager.getColor ( "Panel.background" ));
        startResetButton.addActionListener(e -> {
            if (startOrReset == StatusStartReset.RESET) {

                Set<Cell> cells = Cell.getCells();
                for (Cell cell: cells) {
                    cell.setText(" ");
                    cell.setEnabled(false);
                }
                Cell.setXTurn(true);

                gameMode = GameMode.GAME_NOT_STARTED;
                statusLabel.setText(gameMode.getTextLabel());

                startOrReset = StatusStartReset.START;
                startResetButton.setText(startOrReset.getButtonLabel());

                player1Button.setEnabled(true);
                player2Button.setEnabled(true);

            } else if (startOrReset == StatusStartReset.START) {

                gameMode = GameMode.GAME_IN_PROGRESS;
                statusLabel.setText(gameMode.getTextLabel());

                startOrReset = StatusStartReset.RESET;
                startResetButton.setText(startOrReset.getButtonLabel());

                Set<Cell> cells = Cell.getCells();
                for (Cell cell: cells) {
                    cell.setEnabled(true);
                }

                player1Button.setEnabled(false);
                player2Button.setEnabled(false);

                startGame();
            }

        });
    }

    private void setPlayer1Button() {
        player1Button.setName("ButtonPlayer1");
        player1Button.setText(player1.getPlayerType());
        player1Button.setFocusable(false);
        player1Button.setFont(LABEL_RESET_FONT);
        player1Button.setBackground(UIManager.getColor ( "Panel.background" ));
        player1Button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        player1Button.addActionListener(e -> {
            if (startOrReset == StatusStartReset.START) {
                player1 = player1 == PlayerType.HUMAN ? PlayerType.ROBOT : PlayerType.HUMAN;
                player1Button.setText(player1.getPlayerType());
            }
        });
    }

    private void setPlayer2Button() {
        player2Button.setName("ButtonPlayer2");
        player2Button.setText(player2.getPlayerType());
        player2Button.setFocusable(false);
        player2Button.setFont(LABEL_RESET_FONT);
        player2Button.setBackground(UIManager.getColor ( "Panel.background" ));
        player2Button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        player2Button.addActionListener(e -> {
            if (startOrReset == StatusStartReset.START) {
                player2 = player2 == PlayerType.HUMAN ? PlayerType.ROBOT : PlayerType.HUMAN;
                player2Button.setText(player2.getPlayerType());
            }
        });
    }

    private void startGame() {
        // TODO
        if (player1 == PlayerType.ROBOT && player2 == PlayerType.ROBOT) {
            while (gameMode == GameMode.GAME_IN_PROGRESS) {
                Thread thread = new Thread(() -> {
                    pressRandomCell();
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (player1 == PlayerType.ROBOT && player2 == PlayerType.HUMAN) {
            pressRandomCell();
        }
    }

    protected static void pressRandomCell() {
        List<Cell> cells = new ArrayList<>(Cell.getCells());
        Collections.shuffle(cells);
        for (Cell cell: cells) {
            if (cell.getText().equals(" ")) {
                cell.doClick();
                return;
            }
        }
    }
}
