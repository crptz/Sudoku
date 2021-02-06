package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuFrame extends JFrame implements ActionListener
{
    public SudokuFrame()
    {
        initSudokuFrame();
    }

    private void initSudokuFrame()
    {

        // Grid sudoku panel
        JPanel btnPanel = new JPanel(new GridLayout(8,0));

        // SudokuButtons instance
        SudokuButtons buttons = new SudokuButtons();

        // Add Check button on btnPanel
        btnPanel.add(buttons.getBtnCheck());

        // Add action listener to Check button
        buttons.getBtnCheck().addActionListener(this);


        this.setSize(480, 430);
        this.add(btnPanel, BorderLayout.WEST);
        this.getContentPane().add(matrix);
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // Implement action listener for Check button
    @Override
    public void actionPerformed(ActionEvent e) {
        check.isSudokuValid(matrix.getSudokuField());
    }


    SudokuChecker check = new SudokuChecker();
    SudokuPanel matrix = new SudokuPanel(9,9);
}
