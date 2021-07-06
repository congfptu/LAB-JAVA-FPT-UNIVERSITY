
package matrix;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Matrix {

   private final Scanner in = new Scanner(System.in);

    private  int getIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Only 1 to 4!!!");
            }
        }
    }

    private  int getInputElement(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Only nature number!!!");
            }
        }
    }

    private int getSizeOfMatrix() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <=0) {
                    System.err.println("Can't create matrix!!!");
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Only nature number!!!");
            }
        }
    }

    private int[][] inputMatrix(int n) {
        System.out.print("Enter Row Matrix" + n + " : ");
        int row = getSizeOfMatrix();
        System.out.print("Enter Colum Matrix" + n + " : ");
        int col = getSizeOfMatrix();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = getInputElement("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            }
        }
        return matrix;
    }

    private  int[][] inputMatrix(int n, int[][] matrix2, String ope) {
        int row;
        int col;
        if (ope.equals("*")) {
            while (true) {
                System.out.print("Enter Row Matrix" + n + " : ");
                row = getSizeOfMatrix();
                if (row == matrix2[0].length) {
                    break;
                }
            }
            System.out.print("Enter Colum Matrix" + n + " :");
            col = getSizeOfMatrix();
        } else {
            while (true) {
                System.out.print("Enter Row Matrix" + n + " : ");
                row = getSizeOfMatrix();
                if (row == matrix2.length) {
                    break;
                }
            }
            while (true) {
                System.out.print("Enter Colum Matrix" + n + " :");
                col = getSizeOfMatrix();
                if (col == matrix2[0].length) {
                    break;
                }
            }
        }
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = getInputElement("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
            }
        }
        return matrix;
    }

    private static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    private  boolean checkMatrixAddition(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            return true;
        }
        return false;
    }

    private  void CalculatorMatrix(String ope) {
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = null;
        //calculator multiplication
        if (ope.equals("*")) {
            matrix2 = inputMatrix(2, matrix1, "*");
            multiplicationMatrix(matrix1, matrix2);
        } else {
            matrix2 = inputMatrix(2, matrix1, "");
            //calculator addition
            if (ope.equals("+")) {
                additionMatrix(matrix1, matrix2);
            } //calculator subtraction
            else if (ope.equals("-")) {
                subtractionMatrix(matrix1, matrix2);
            }
        }
    }

    private void additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("----------Result----------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        //run from first to last element in row
        for (int i = 0; i < row; i++) {
            //run from first to last element in col
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    private void subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("----------Result----------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        //run from first to last element in row
        for (int i = 0; i < row; i++) {
            //run from first to last element in col
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    private  void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("----------Result----------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] matrixResult = new int[row1][col2];
        //run from fir
        for (int i = 0; i < row1; i++) {
            //run from first to last element in col
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(matrixResult);
    }

    public void main(String[] args) throws IOException {
        while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = getIntLimit(1, 4);
            switch (choice) {
                case 1: {
                    CalculatorMatrix("+");
                    break;
                }
                case 2: {
                    CalculatorMatrix("-");
                    break;
                }
                case 3: {
                    CalculatorMatrix("*");
                    break;
                }
                case 4:
                   return;
            }
        }
    }

    
}
