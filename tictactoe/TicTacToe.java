package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class TicTacToe extends JFrame {

    protected static final int FIELD_WIDTH = 300;
    protected static final int FIELD_HEIGHT = 300;
    private static final int GAP = 5;
    protected static final Font LABEL_RESET_FONT = new Font("Courier", Font.BOLD, 11);
    protected static GameMode gameMode = GameMode.GAME_NOT_STARTED;
    private PlayingField playingField = new PlayingField();
    protected static JLabel statusLabel = new JLabel();
    protected static JButton resetButton = new JButton();
    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FIELD_WIDTH, FIELD_HEIGHT);
        setResizable(false);
        setLayout(new BorderLayout(5, 5));

        // Add components to the frame
        add(playingField, BorderLayout.CENTER);
        setBottomPanel();

        setVisible(true);
    }

    private void setBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        bottomPanel.setLayout(new BorderLayout());

        setStatusLabel();
        bottomPanel.add(statusLabel, BorderLayout.WEST);

        setResetButton();
        bottomPanel.add(resetButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setStatusLabel() {
        statusLabel.setName("LabelStatus");
        statusLabel.setText(gameMode.getTextLabel());
        statusLabel.setFont(LABEL_RESET_FONT);
    }

    private void setResetButton() {
        resetButton.setName("ButtonReset");
        resetButton.setText("Reset");
        resetButton.setFocusable(false);
        resetButton.setFont(LABEL_RESET_FONT);
        resetButton.setBackground(Color.BLACK);
        resetButton.setForeground(UIManager.getColor ( "Panel.background" ));
        resetButton.addActionListener(e -> {
            Set<Cell> cells = Cell.getCells();
            for (Cell cell: cells) {
                cell.setText(" ");
            }
            Cell.setXTurn(true);
            gameMode = GameMode.GAME_NOT_STARTED;
            statusLabel.setText(gameMode.getTextLabel());
        });
    }
}
