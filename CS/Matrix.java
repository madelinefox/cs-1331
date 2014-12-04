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
    private final double[][] matrix;

    /**
     * Initialize instance variables
     *
     * @param matrix 2D array representation of Matrix
     */
    public Matrix(double[][] matrixa) {
        this.matrix = matrixa;
    }

    /**
     * Gets value located at specified row and column
     *
     * @param i row
     * @param j column
     * @return double located at row i and column j in matrix
     */
    public double get(int i, int j) {
        return (matrix[i][j]);
    }

    /**
     * Gets the height of the matrix.
     *
     * @return number of rows in matrix
     */
    public int getHeight() {
        return (matrix.length);
    }

    /**
     * Gets the width of the matrix.
     *
     * @return number of columns in matrix
     */
    public int getWidth() {
        return (matrix[0].length);
    }

    /**
     * Gets String representation of matrix.
     * Columns separated by tabs, rows by new lines.
     *
     * @return String representation of matrix.
     */
    public String toString() {
        String text = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                text = text + matrix[i][j] + " \t";
            }
            text = text.substring(0, text.length() - 1) + "\n";
        }
        return (text);
    }
}
