/**
 * Immutable abstraction of Matrix.
 *
 * @author Michael Maurer
 * @version 1.2
 */
public class Matrix {

    /*
    Create final instance variables
    */
    private final double[][] MATRIX;
    /**
     * Initialize instance variables
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(double[][] matrix) {
        this.MATRIX = new double[matrix.length][matrix[0].length];
        this.MATRIX = matrix;
    }

    /**
     * Gets value located at specified row and column
     * @param i row
     * @param j column
     * @return double located at row i and column j in matrix
     */
    public double get(int i, int j) {
        return (MATRIX[i][j]);
    }

    /**
     * Get's the height of the matrix.
     * @return number of rows in matrix
     */
    public int getHeight() {
        return (MATRIX.length);
    }

    /**
     * Get's the width of the matrix.
     * @return number of columns in matrix
     */
    public int getWidth() {
        return (MATRIX[0].length);
    }

    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     * @return String representation of matrix.
     */
    public String toString() {
        String text;
        for (int i = 0; i < MATRIX.length; i++) {
            for (int j = 0; j < MATRIX[i].length; j++) {
                text = text + MATRIX[i][j] + "\t";
            }
            text = text.substring(0, text.length() - 1) + "n";
        }
        return (text);
    }
}
