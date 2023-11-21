package tictactoe;

import javax.swing.*;
import java.awt.*;

public class PlayingField extends JPanel {
    private static final int GAP = 5;

    public PlayingField() {
        setLayout(new GridLayout(3, 3, GAP, GAP));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        addButtons();
    }

    private void addButtons() {
        for (int i = 3; i > 0; i--) {
            for (char cellLetter = 'A'; cellLetter < 'D'; cellLetter++) {
                String buttonLabel = cellLetter + String.valueOf(i);
                this.add(new Cell(buttonLabel));
            }
        }

    }
}
