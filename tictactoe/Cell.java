package tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Cell extends JButton {

    private static Set<Cell> cells = new HashSet<>();
    private static final Font LABEL_FONT = new Font("Courier", Font.BOLD, 32);
    private static final Color CELL_COLOR = Color.ORANGE;

    public Cell(String label) {
        super(label);
        setName("Button" + label);
        setBackground(CELL_COLOR);
        setFont(LABEL_FONT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setFocusable(false);
        cells.add(this);
    }
}
