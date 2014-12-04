/**
 * 
 * @author Madeline Fox
 * @version 1.0
 */
public class PersonList {
    private Person[] people;
    private int count;
    /**
     * 
     * @param maxSize - an integer to show what the max size of the backing array will be.
     */
    public PersonList(int maxSize) {
        people = new Person[maxSize];
    }
    /**
     * Prints all people in the list backing array.
     */
    public void listPeople() {
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                System.out.println(people[i]);
            }
        }
    }
    /**
     * Adds a Person to the backing array.
     * @param p -a Person object to add to the list backing array
     */
    public void add(Person p) {
        for (int i = 0; i < people.length; i++) {
            if (people[i] == null) {
                people[i] = p;
                return;
            }
        }
    }
}
