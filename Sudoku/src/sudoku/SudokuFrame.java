package sudoku;

import javax.swing.*;
import java.awt.*;

public class SudokuFrame extends JFrame
{
    public SudokuFrame()
    {
        initSudokuFrame();
    }

    private void initSudokuFrame()
    {
        // Grid sudoku panel
        JPanel btnPanel = new JPanel(new GridLayout(8,0));

        // SudokuButtons buttons = new SudokuButtons(); sudokuButtons instance
        SudokuButtons buttons = new SudokuButtons();

        // Add Check button on btnPanel
        btnPanel.add(buttons.getBtnCheck());
        btnPanel.add(buttons.getBtnHistory());

        // Add action listener to Check button
        buttons.getBtnCheck().addActionListener(
                e -> check.isSudokuValid(matrix.getSudokuField())
        );

        final JTextField history = new JTextField();
        final JFrame historyFrame = new JFrame("Last game");

        buttons.getBtnHistory().addActionListener(
                e -> {
                    historyFrame.add(history);
                    history.setText(f.getSqlQueryResult());
                    historyFrame.setSize(180,80);
                    historyFrame.setVisible(true);
                }
        );



        this.setSize(500, 430);
        this.add(btnPanel, BorderLayout.WEST);
        this.getContentPane().add(matrix);
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /* Implement action listener for Check button
    @Override
    public void actionPerformed(ActionEvent e) {
        check.isSudokuValid(matrix.getSudokuField());
    }*/


    SudokuChecker check = new SudokuChecker();
    SudokuPanel matrix = SudokuPanel.getInstance();
    SudokuDatabase f = new SudokuDatabase();
}
