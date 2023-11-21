package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    protected static final int FIELD_WIDTH = 300;
    protected static final int FIELD_HEIGHT = 300;
    private PlayingField playingField = new PlayingField();
    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        setLayout(new BorderLayout(5, 5));

        add(playingField, BorderLayout.CENTER);
        setVisible(true);
    }
}
