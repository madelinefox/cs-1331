public class UndergraduateStudent extends Student {
    public UndergraduateStudent(String firstName, String lastName,
                                    int intelligence, int motivation) {
        super(firstName, lastName, intelligence, motivation);
    }
    public String toString() {
        return ("Hi, my name is " + firstName + " " + lastName
                    + ". My intelligence is " + intelligence + "/10 and my moti"
                    + "vation is " + motivation + "/10. I’m going home this wee"
                    + "kend to get laundry done; talk about clutch.");
    }
}
