/**
 * 
 * @author Madeline Fox
 * @version 1.0
 */
public class Person {
    protected String firstName;
    protected String lastName;
    /**
     * 
     * @param firstNam  -a String representation of the first name
     * @param lastName  -a String representation of the last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * 
     * 
     * @return String representation of this object
     */
    public String toString() {
        return (firstName + lastName);
    }
}
