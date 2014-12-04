import java.util.Random;
import java.awt.Rectangle;
/**
  * This class is the Lannister House.
  * @author Madeline (Aiden) Fox
  * @version 1.0
  */
public class Lannister extends House {
    private Random random = new Random();

    /**
      * makes an instance of the house
      * @param x, y
      * @return a new instance
      */
    public Lannister(int x, int y) {
        super("lion.png");
        xPos = x;
        yPos = y;
        this.age = random.nextInt(20);
        this.health = 100;
    }
    /**
      * makes an instance of the house
      * @param x, y, bounds
      * @return a new instance
      */
    public Lannister(int x, int y, Rectangle bounds) {
        super("lion.png", bounds);
        xPos = x;
        yPos = y;
        this.age = random.nextInt(20);
        this.health = 100;
    }

    public Lannister() {
        super("lion.png");
        this.age = random.nextInt(20);
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
        if (prob < 100 && cooldown > 0 && reproduction > 0
            && (otherHouse instanceof Lannister
            || otherHouse instanceof Baratheon)) {
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
        return (new Lannister(xPos, yPos));
    }
    /**
      * getter for oldness
      * @param none
      * @return boolean if old
      */
    public boolean isOld() {
        if (age == 50) {
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
        if ((otherHouse instanceof Stark && prob < 7)
                || otherHouse instanceof Rooster
                || (otherHouse instanceof Tully && prob < 9)) {
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
