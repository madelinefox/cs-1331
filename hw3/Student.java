/**
 * 
 * @author Madeline Fox
 * @version 1.0
 */
public class Student extends Person {
    protected int intelligence;
    protected int motivation;
    /**
     * 
     * @param firstName     -a String representation of first name
     * @param lastName      -a String representation of last name
     * @param intelligence  -a int representation of intelligence
     * @param motivation    -a int representation of motivation
     */
    public Student(String firstName, String lastName, int intelligence,
      int motivation) {
        super(firstName, lastName);
        this.intelligence = intelligence;
        this.motivation = motivation;
    }
    /**
     * 
     * @return String representation of the object
     */
    public String toString() {
        return ("Hi, my name is " + firstName + " " + lastName + ". My intellig"
                    + "ence is " + intelligence + "/10 and my motivation is "
                    + motivation + "/10. I’m stressed out.");
    }
}
