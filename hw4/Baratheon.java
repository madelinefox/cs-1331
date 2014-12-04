import java.util.Random;
import java.awt.Rectangle;
/**
  * This class is the Baratheon House.
  * @author Madeline (Aiden) Fox
  * @version 1.0
  */
public class Baratheon extends House {
    private Random random = new Random();

    /**
      * makes an instance of the house
      * @param x, y
      * @return a new instance
      */
    public Baratheon(int x, int y) {
        super("stag.png");
        xPos = x;
        yPos = y;
        this.age = random.nextInt(10);
        this.health = 100;
    }
    /**
      * makes an instance of the house
      * @param x, y, bounds
      * @return a new instance
      */
    public Baratheon(int x, int y, Rectangle bounds) {
        super("stag.png", bounds);
        xPos = x;
        yPos = y;
        this.age = random.nextInt(10);
        this.health = 100;
    }
    /**
      * moves the instance
      * @param none
      * @return none
      */
    public void move() {
        if (yPos < 300) {
            distance = 20;
        } else {
            distance = 10;
        }
        super.move();
    }
    /**
      * checks reproduction ability
      * @param otherHouse
      * @return boolean if possible
      */
    public boolean canReproduceWithHouse(House otherHouse) {
        int prob = random.nextInt(1000) + 1;
        if (reproduction > 0 && otherHouse instanceof Lannister
                && prob > 47 && prob < 53) {
            System.out.println("Baratheon contracted death during "
                                + "reproduction.");
            age = 100;
        }
        if (cooldown > 0 && reproduction > 0 && otherHouse instanceof Lannister
                && prob < 50) {
            cooldown--;
            return true;
        }
        return false;
    }
    /**
      * reproduces with other house
      * @param otherHouse
      * @return House new house of same type
      */
    public House reproduceWithHouse(House otherHouse) {
        reproduction--;
        return (new Baratheon(xPos, yPos));
    }
    /**
      * getter for oldness
      * @param none
      * @return boolean if old
      */
    public boolean isOld() {
        if (age == 60) {
            return true;
        }
        return false;
    }
    /**
      * checks harm posibility
      * @param otherHouse
      * @return boolean if possible
      */
    public boolean canHarmHouse(House otherHouse) {
        if (otherHouse instanceof Targaryan || otherHouse instanceof Rooster) {
            return true;
        }
        return false;
    }
    /**
      * harms other house
      * @param otherHouse
      * @return nothing
      */
    public void harmHouse(House otherHouse) {
        otherHouse.harm(2);
    }
}
