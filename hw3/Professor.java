/**
 * 
 * @author Madeline Fox
 * @version 1.0
 */
public class Professor extends Person {
    private int rateMyProfessorRating;
    private double averageGPA;
    /**
     * 
     * @param firstName             -String representation of the first name
     * @param lastName              -String representation of the last name
     * @param rateMyProfessorRating -int representation of the Professor's rating
     * @param averageGPA            -double representation of the average GPA
     */
    public Professor(String firstName, String lastName,
      int rateMyProfessorRating, double averageGPA) {
        super(lastName, firstName);
        this.rateMyProfessorRating = rateMyProfessorRating;
        this.averageGPA = averageGPA;
    }
    /**
     * 
     * @return String representation of the object.
     */
    public String toString() {
        return ("Hi, my name is " + firstName + " " + lastName + ". My Rate My "
                    + "Professor rating is " + rateMyProfessorRating + "/5 and "
                    + "my average GPA is " + averageGPA + "/4.00. I really wish"
                    + " students would stop emailing me so much.");
    }
}
