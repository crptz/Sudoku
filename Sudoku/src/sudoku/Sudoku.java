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
        System.out.println("Hi! I'm Tetrahedron.");
        System.out.println("You know what's interesting? Hm... click here.");
    }
}
