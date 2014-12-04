import java.awt.Rectangle;
/**
  * This class is the Rooster House.
  * The Rooster house has a ton of hp, but can be attacked by everyone, deals
  * very little damage and only reproduces with Targaryans.
  * @author Madeline (Aiden) Fox
  * @version 1.0
  */
public class Rooster extends House {

    /**
      * makes an instance of the house
      * @param x, y, bounds
      * @return a new instance
      */
    public Rooster(int x, int y, Rectangle bounds) {
        super("rooster.png", bounds);
        xPos = x;
        yPos = y;
        this.age = 0;
        this.health = 400;
    }
    /**
      * moves the instance
      * @param none
      * @return none
      */
    public void move() {
        distance = 10;
        super.move();
        health--;
    }
    /**
      * makes an instance of the house
      * @param x, y
      * @return a new instance
      */
    public Rooster(int x, int y) {
        super("rooster.png");
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
        return new Rooster(xPos, yPos);
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
        if (otherHouse instanceof Targaryan) {
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
        otherHouse.harm(1);
    }
}
