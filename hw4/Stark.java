import java.util.Random;
import java.awt.Rectangle;
/**
  * This class is the Stark House.
  * @author Madeline (Aiden) Fox
  * @version 1.0
  */
public class Stark extends House {
    private Random random = new Random();

    /**
      * makes an instance of the house
      * @param x, y
      * @return a new instance
      */
    public Stark(int x, int y) {
        super("direwolf.png");
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
    public Stark(int x, int y, Rectangle bounds) {
        super("direwolf.png", bounds);
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
        distance = 10;
        if (yPos > 300) {
            health = health + 3;
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
        if (reproduction > 0 && otherHouse instanceof Tully && prob > 57
                && prob < 63) {
            System.out.println("Stark contracted death during reproduction.");
            age = 100;
        }
        if (cooldown > 0 && reproduction > 0 && otherHouse instanceof Tully
                && prob < 60) {
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
        return (new Stark(xPos, yPos));
    }
    /**
      * getter for oldness
      * @param none
      * @return boolean if old
      */
    public boolean isOld() {
        if (age == 70) {
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
        int prob = random.nextInt(10) + 1;
        if ((otherHouse instanceof Lannister && prob < 5)
                || otherHouse instanceof Rooster) {
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
        otherHouse.harm(5);
    }
}
