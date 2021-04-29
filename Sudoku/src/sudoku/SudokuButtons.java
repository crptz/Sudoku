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
        this.history = new JButton("History");
    }

    // Function to getButton
    public JButton getBtnCheck()
    {
        return this.check;
    }

    public JButton getBtnHistory()
    {
        return this.history;
    }


    private JButton check;
    private JButton history;
}
