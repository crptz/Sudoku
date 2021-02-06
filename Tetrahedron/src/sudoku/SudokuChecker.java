package sudoku;

import javax.swing.*;

public class SudokuChecker
{
    public void isSudokuValid(JTextField[][] matrix)
    {
        boolean res = true;

        //validate rows
        for (int i = 0; i < 9; i++)
        {
            res &= isRowValid(matrix);
        }

        for (int i = 0; i < 9; i++)
        {
            res &= isColValid(matrix);
        }

        //validate 3x3 matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res &= isMatrixValid(matrix, i, j);
            }
        }

        if (res)
        {
            System.out.println("Sudoku is Valid");
        }
        else
            System.out.println("Sudoku is not valid");
    }

    // CHECK THIS FUNCTION WHEN I WAKE UP TOMORROW
    private boolean isRowValid(JTextField[][] matrix)
    {
        String[] numbs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (numbs[col] != null && numbs[col].equals(matrix[row][col].getText()))
                {
                    numbs[col] = null;
                }
            }
        }

        for (String numb : numbs) {
            if (numb != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isColValid(JTextField[][] matrix)
    {
        String[] numbs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};


        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (numbs[col] != null && numbs[col].equals(matrix[col][row].getText()))
                    numbs[col] = null;  // Delete item from numbs
            }
        }

        //check if numbs is empty
        for (String numb : numbs) {
            if (numb != null) {
                return false;
            }
        }
        return true;

    }

    private boolean isMatrixValid(JTextField[][] matrix, int row_index, int col_index)
    {
        int rowStart = row_index*3;
        int colStart = col_index*3;

        // SudokuType rc = new SudokuType(9, 9);

        String[] numbs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int row = rowStart; row <rowStart+3 ; row++) {
            for (int col = colStart; col <colStart+3 ; col++) {
                for (int numbsIndex = 0; numbsIndex < 9; numbsIndex++)
                {
                    if (numbs[numbsIndex] != null && numbs[numbsIndex].equals(matrix[row][col].getText()))
                        numbs[numbsIndex] = null;  // Delete item from numbs
                }
            }
        }

        for (String numb : numbs) {
            if (numb != null) {
                return false;
            }
        }
        return true;
    }
}
