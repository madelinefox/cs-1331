public class Card2 {
    private String rank;
    private String suit;

    public String toString()  {
        return rank + " of " + suit;
    }

    public static void main (String [] args) {
        Card2 c = new Card2();

        c.suit = "base";
        c.rank = "ace";


}
}
