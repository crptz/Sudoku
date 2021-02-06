package sudoku;

import javax.swing.*;

public class SudokuButtons
{
    public SudokuButtons()
    {
        // Call initSudokuButtons()
        initSudokuButtons();
    }

    private void initSudokuButtons()
    {
        // Create Check button
        this.check = new JButton("Check");
    }

    // Function to getButton
    public JButton getBtnCheck()
    {
        return this.check;
    }

    private JButton check;
}
