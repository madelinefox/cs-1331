/**
 * A file to be graded by Aaron Fireson-sensei for the other TA's sanity. Thank
 * you.
 *
 * @author Aiden Fox
 * @version 1.0
 */
public class LinearAlgebra {
    /**
     * @param m, v                     a matrix and a vector to multiply
     * @return Vector                  the vector result of the multiplication
     * @throws IllegalOperandException
     */
    public static Vector matrixVectorMultiply(Matrix m,
                                              Vector v) throws
            IllegalOperandException {
        if (m.getWidth() != v.getLength()) {
            throw new IllegalOperandException("Vector doesn't meet size "
                    + "requirement. The vector is of " + v.getLength() + " "
                    + "while the width of the array is " + m.getWidth() + ".");
        }
        double[] vector = new double[m.getHeight()];
        for (int x = 0; x < m.getHeight(); x++) {
            double runningSum = 0;
            for (int y = 0; y < m.getWidth(); y++) {
                runningSum = m.get(x, y) * v.get(y);
            }
            vector[x] = runningSum;
        }
        return (new Vector(vector));
    }

    /**
     * @param m1, m2                   two matricies to add together
     * @return Matrix                  sum
     * @throws IllegalOperandException if it don't work none (show to Aaron
     *                                 Fireson-sensei if disagreeable)
     */
    public static Matrix matrixAdd(Matrix m1,
                                   Matrix m2) throws IllegalOperandException {
        if (m1.getHeight() != m2.getHeight()) {
            throw new IllegalOperandException("The matricies are not of "
                    + "equivalent dimensions. The matrix heights do not line up"
                    + ". The first is of " + m1.getHeight() + " and the second "
                    + "is of " + m2.getHeight() + ".");
        }
        if (m1.getWidth() != m2.getWidth()) {
            throw new IllegalOperandException("The matricies are not of "
                    + "equivalent dimensions. The matrix widths do not line up."
                    + " The first is of " + m1.getWidth() + " and the second is"
                    + " of " + m2.getWidth() + ".");
        }
        double[][] matrix = new double[m1.getHeight()][m1.getWidth()];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                matrix[x][y] = m1.get(x, y) + m2.get(x, y);
            }
        }

        return (new Matrix(matrix));
    }

    /**
     * @param v1, v2
     * @return double
     * @throws IllegalOperandException
     */
    public static double dotProduct(Vector v1,
                                    Vector v2) throws IllegalOperandException {
        double holding = 0;
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("The vectors are not equal in "
                    + "length. One is of " + v1.getLength() + " the other is of"
                    + " " + v2.getLength() + ".");
        }
        for (int i = 0; i < v1.getLength(); i++) {
            holding = holding + (v1.get(i) * v2.get(i));
        }
        return (holding);
    }

    /**
     * @param v1, v2
     * @return Vector
     * @throws IllegalOperandException
     */
    public static Vector vectorAdd(Vector v1,
                                   Vector v2) throws IllegalOperandException {
        if (v1.getLength() != v2.getLength()) {
            throw new IllegalOperandException("The vectors are not equal in "
                    + "length. One is of " + v1.getLength() + " the other is of"
                    + " " + v2.getLength() + ".");
        }
        double[] vector = new double[v1.getLength()];
        for (int x = 0; x < vector.length; x++) {
            vector[x] = v1.get(x) + v2.get(x);
        }
        return (new Vector(vector));
    }

}
