/**
 * @author Aiden Fox
 * @version 1.0
 */
public class IllegalOperandException extends Exception {
    private String message;

    /**
     * Constructs
     *
     * @param a
     */
    public IllegalOperandException(String a) {
        super(a);
        message = a;
    }

    /**
     * Constructer
     */
    public IllegalOperandException() {
        super();
    }

    public void printMessage() {
        System.out.println(message);
    }

}
