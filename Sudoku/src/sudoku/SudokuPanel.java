package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SudokuPanel extends JPanel
{
    public SudokuPanel(int rows, int cols)
    {
        this.cols = cols;
        this.rows = rows;
            initSudokuPanel();
    }

    private void initSudokuPanel()
    {
        Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK);
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        this.setLayout(new GridLayout(this.rows, this.cols));
        this.sudokuField = new JTextField[this.rows][this.cols];

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                this.sudokuField[row][col] = new JTextField();
                this.add(this.sudokuField[row][col]);
                this.sudokuField[row][col].setFont(font1);
                this.sudokuField[row][col].setHorizontalAlignment(JTextField.CENTER);
                this.sudokuField[row][col].setBorder(fieldBorder);
                this.sudokuField[row][col].setForeground(Color.BLACK);
            }
        }

        int N = 9, K = 20;
        SudokuGenerator sudoku = new SudokuGenerator(N, K);
        sudoku.printSudoku();
        sudoku.fillValues();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.sudokuField[row][col].setText(String.valueOf(sudoku.getMat()[row][col]));

                if(this.sudokuField[row][col].getText().equals("0"))
                {
                    this.sudokuField[row][col].setText("");
                }
            }
        }
    }

    public static SudokuPanel getInstance()
    {
        return instance;
    }


    public JTextField[][] getSudokuField()
    {
        return this.sudokuField;
    }

    private static final SudokuPanel instance = new SudokuPanel(9,9);

    private JTextField[][] sudokuField;
    private final int rows;
    private final int cols;
}
