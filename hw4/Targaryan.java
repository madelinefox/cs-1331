import java.awt.Rectangle;
/**
  * This class is the Targaryan House.
  * @author Madeline (Aiden) Fox
  * @version 1.0
  */
public class Targaryan extends House {

    /**
      * makes an instance of the house
      * @param x, y, bounds
      * @return a new instance
      */
    public Targaryan(int x, int y, Rectangle bounds) {
        super("dragon.png", bounds);
        xPos = x;
        yPos = y;
        this.age = 0;
        this.health = 20;
    }
    /**
      * moves the instance
      * @param none
      * @return none
      */
    public void move() {
        distance = 10;
        super.move();
        health++;
    }
    /**
      * makes an instance of the house
      * @param x, y
      * @return a new instance
      */
    public Targaryan(int x, int y) {
        super("dragon.png");
        xPos = x;
        yPos = y;
        this.age = 0;
        this.health = 20;
    }
    /**
      * checks reproduction ability
      * @param otherHouse
      * @return boolean if possible
      */
    public boolean canReproduceWithHouse(House otherHouse) {
        int prob = random.nextInt(1000) + 1;
        if (cooldown > 0 && reproduction > 0 && otherHouse instanceof Targaryan
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
        return new Targaryan(xPos, yPos);
    }
    /**
      * getter for oldness
      * @param none
      * @return boolean if old
      */
    public boolean isOld() {
        return false;
    }
    /**
      * checks harm posibility
      * @param otherHouse
      * @return boolean if possible
      */
    public boolean canHarmHouse(House otherHouse) {
        if (otherHouse instanceof Baratheon) {
            return false;
        }
        return true;
    }
    /**
      * harms other house
      * @param otherHouse
      * @return nothing
      */
    public void harmHouse(House otherHouse) {
        otherHouse.harm(4);
    }
}
