package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.MessageFormat;

public class Cell extends JButton {

    private static Set<Cell> cells = new HashSet<>();
    private static boolean xTurn = true;
    private static final Font LABEL_FONT = new Font("Courier", Font.BOLD, 32);
    private static final Color CELL_COLOR = Color.ORANGE;
    private static final Set<Set<String>> WINNING_PATTERNS = new HashSet<>();

    static {
        Set<String> pattern1 = new HashSet<>(Arrays.asList("A1", "A2", "A3"));
        Set<String> pattern2 = new HashSet<>(Arrays.asList("B1", "B2", "B3"));
        Set<String> pattern3 = new HashSet<>(Arrays.asList("C1", "C2", "C3"));
        Set<String> pattern4 = new HashSet<>(Arrays.asList("A3", "B3", "C3"));
        Set<String> pattern5 = new HashSet<>(Arrays.asList("A2", "B2", "C2"));
        Set<String> pattern6 = new HashSet<>(Arrays.asList("A1", "B1", "C1"));
        Set<String> pattern7 = new HashSet<>(Arrays.asList("A1", "B2", "C3"));
        Set<String> pattern8 = new HashSet<>(Arrays.asList("A3", "B2", "C1"));

        WINNING_PATTERNS.add(pattern1);
        WINNING_PATTERNS.add(pattern2);
        WINNING_PATTERNS.add(pattern3);
        WINNING_PATTERNS.add(pattern4);
        WINNING_PATTERNS.add(pattern5);
        WINNING_PATTERNS.add(pattern6);
        WINNING_PATTERNS.add(pattern7);
        WINNING_PATTERNS.add(pattern8);
    }
    private String label;

    public Cell(String label) {
        this.label = label;
        setFocusable(false);
        setText(" ");
        setName("Button" + label);
        setBackground(CELL_COLOR);
        setFont(LABEL_FONT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setEnabled(false);
        addActionListener(e -> {
            if (TicTacToe.startOrReset == StatusStartReset.RESET) {
                if (TicTacToe.gameMode == GameMode.GAME_IN_PROGRESS && this.getText().equals(" ")) {
                    String text = xTurn ? "X" : "O";
                    setText(text);
                    xTurn = !xTurn;
                    determineGameStatus(text);
                    if (TicTacToe.player1 == PlayerType.ROBOT && TicTacToe.player2 == PlayerType.HUMAN && xTurn) {
                        TicTacToe.pressRandomCell();
                    }
                    if (TicTacToe.player1 == PlayerType.HUMAN && TicTacToe.player2 == PlayerType.ROBOT && !xTurn) {
                        TicTacToe.pressRandomCell();
                    }
                }
            }
        });

        cells.add(this);
    }

    public static Set<Cell> getCells() {
        return Cell.cells;
    }

    public String getLabel() {
        return this.label;
    }

    public static void setXTurn(boolean xTurn) {
        Cell.xTurn = xTurn;
    }
    public static boolean getXTurn() { return Cell.xTurn; }

    private static void determineGameStatus(String text) {
        if (text.equals("X") && winningPatternPresent(text)) {
            TicTacToe.gameMode = GameMode.X_WINS;
            TicTacToe.statusLabel.setText(MessageFormat.format(TicTacToe.gameMode.getTextLabel(), TicTacToe.player1.getPlayerType()));
            return;
        }
        if (text.equals("O") && winningPatternPresent(text)) {
            TicTacToe.gameMode = GameMode.O_WINS;
            TicTacToe.statusLabel.setText(MessageFormat.format(TicTacToe.gameMode.getTextLabel(), TicTacToe.player2.getPlayerType()));
            return;
        }

        // Check if there is a draw
        for (Cell cell: cells) {
            if (cell.getText().equals(" ")) {
                String turn = xTurn ? "X" : "O";
                String currentPlayerType = xTurn ? TicTacToe.player1.getPlayerType() : TicTacToe.player2.getPlayerType();
                TicTacToe.statusLabel.setText(MessageFormat.format(TicTacToe.gameMode.getTextLabel(), currentPlayerType, turn));
                return;
            }
        }

        // There is a draw
        TicTacToe.gameMode = GameMode.DRAW;
        TicTacToe.statusLabel.setText(TicTacToe.gameMode.getTextLabel());
    }

    private static boolean winningPatternPresent(String mark) {

        // Get the cells that have their text equal to <mark>
        Set<String> labelsWithMark = new HashSet<>();
        for (Cell cell: cells) {
            if (cell.getText().equals(mark)) labelsWithMark.add(cell.getLabel());
        }

        // Checking if there is a winning pattern
        for (Set<String> winningPattern: WINNING_PATTERNS) {
            if (labelsWithMark.containsAll(winningPattern)) return true;
        }

        return false;

    }

}
