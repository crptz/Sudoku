package sudoku;

import javax.swing.*;

public class Sudoku
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            SudokuFrame gui = new SudokuFrame();
            gui.setVisible(true);
        });
    }
}
