/**
  * @author Aiden Fox
  * @version 1.0
  */
public class LinearAlgebra {
    /**
      *
      *@param
      *@return
      *@throws IllegalOperandException
      */
    public static Vector matrixVectorMultiply(Matrix m, Vector v) throws IllegalOperandException {
        //TODO return m * v
    }
    /**
      *
      *@param
      *@return
      *@throws IllegalOperandException
      */
    public static Matrix matrixAdd(Matrix m1, Matrix m2) throws IllegalOperandException {
        //TODO return m1 + m2
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            throw new IllegalOperandException("The matricies are not of equival"
                                            + "ent dimensions.");
        }
        for ()
    }
    /**
      *
      *@param
      *@return
      *@throws IllegalOperandException
      */
    public static double dotProduct(Vector v1, Vector v2) throws IllegalOperandException {
        double holding;
        if (v1.length != v2.length) {
            throw new IllegalOperandException("The vectors are not equal in len"
                                                + "gth.");
        }
        for (int i = 0; i < v1.length; i++) {
            holding = holding + (v1[i] * v2[i]);
        }
        return (holding);
    }
    /**
      *
      *@param
      *@return
      *@throws IllegalOperandException
      */
    public static Vector vectorAdd(Vector v1, Vector v2) throws IllegalOperandException {
        //TODO return v1 + v2
    }

}
