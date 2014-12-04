/**
 * 
 * @author Madeline Fox
 * @version 1.0
 */
public class GraduateStudent extends Student {
    /**
     * 
     * @param firstName     -a String representation of first name
     * @param lastName      -a String representation of last name
     * @param intelligence  -an integer representation of intellegence
     * @param motivation    -an integer representation of motivation
     */
    public GraduateStudent(String firstName, String lastName, int intelligence,
      int motivation) {
        super(firstName, lastName, intelligence, motivation);
    }
    /**
      *
      * @return String representation of the object.
      */
    public String toString() {
        return ("Hi, my name is " + firstName + " " + lastName
                   + ". My intelligence is " + intelligence + "/10 and my motiv"
                   + "ation is " + motivation + "/10. I’m stressed out AND brok"
                   + "e.");
    }
}
