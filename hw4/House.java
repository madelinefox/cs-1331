/**
 * The abstract House for the Game of Thrones Simulation
 *
 */
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;
/**
  * This class is the House.
  * @author Madeline (Aiden) Fox
  * @version 1.0
  */
public abstract class House {

    protected ImageIcon image;
    protected String imageFilename;
    protected int health;
    protected int age;
    protected int xPos;
    protected int yPos;
    protected Random random;
    protected int lastDirection;
    protected int distance;
    protected int reproduction;
    protected int cooldown;

    /**
      * makes an instance of the house
      * @param fileName
      * @return a new instance
      */
    public House(String fileName) {
        this.imageFilename = fileName;
        image = new ImageIcon(imageFilename);
        random = new Random();
        reproduction = 5;
        cooldown = 10;

    }
    /**
      * makes an instance of the house
      * @param fileName, bounds
      * @return a new instance
      */
    public House(String fileName, Rectangle bounds) {
        this.imageFilename = fileName;
        image = new ImageIcon(imageFilename);
        random = new Random();
        reproduction = 5;
        cooldown = 10;

    }
    /**
     * Should draw the House at its location.
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, xPos, yPos);
    }
    /**
      * Getter for x
      * @param none
      * @return xPos
      */
    public int getX() {
        return xPos;
    }
    /**
      * Getter for y
      * @param none
      * @return yPos
      */
    public int getY() {
        return yPos;
    }
    /**
      * moves object
      * @param none
      * @return none
      */
    public void move() {
        age++;
        health--;
        int direction = random.nextInt(11);
        if (direction > 7) {
            if (direction == 8) {
                if (direction != 7) {
                    direction = lastDirection + 1;
                } else {
                    direction = 0;
                }
            } else if (direction == 9) {
                direction = lastDirection;
            } else if (direction == 10) {
                if (direction != 0) {
                    direction = lastDirection - 1;
                } else {
                    direction = 7;
                }
            }
        }
        switch (direction) {
        case 0:
            xPos = xPos - distance;
            yPos = yPos + distance;
            break;
        case 1:
            xPos = xPos - distance;
            break;
        case 2:
            xPos = xPos - distance;
            yPos = yPos - distance;
            break;
        case 3:
            yPos = yPos - distance;
            break;
        case 4:
            xPos = xPos + distance;
            yPos = yPos - distance;
            break;
        case 5:
            xPos = xPos + distance;
            break;
        case 6:
            xPos = xPos + distance;
            yPos = yPos + distance;
            break;
        case 7:
            yPos = yPos + distance;
            break;
        default:
            System.out.println("System error has occured");
            break;
        }
        if (xPos + image.getIconWidth() > 600) {
            xPos = 600 - image.getIconWidth();
        }
        if (yPos + image.getIconHeight() > 600) {
            yPos = 600 - image.getIconHeight();
        }
        if (xPos < 0) {
            xPos = 0;
        }
        if (yPos < 0) {
            yPos = 0;
        }
        lastDirection = direction;

    }
    /**
      * checks collision with another specific house
      * @param otherHouse
      * @return boolean collided
      */
    public boolean collidesWithHouse(House otherHouse) {
        if (xPos + image.getIconWidth() >= otherHouse.getX() && xPos
                + image.getIconWidth() <= otherHouse.getX()
                + image.getIconWidth() && yPos
                + image.getIconHeight() >= otherHouse.getY() && yPos
                + image.getIconHeight() <= otherHouse.getY()
                + image.getIconHeight()) {
            return true;
        }
        if (xPos >= otherHouse.getX() && xPos <= otherHouse.getX()
                + image.getIconWidth() && yPos
                + image.getIconHeight() >= otherHouse.getY() && yPos
                + image.getIconHeight() <= otherHouse.getY()
                + image.getIconHeight()) {
            return true;
        }
        if (xPos + image.getIconWidth() >= otherHouse.getX() && xPos
                + image.getIconWidth() <= otherHouse.getX()
                + image.getIconWidth() && yPos
                >= otherHouse.getY() && yPos <= otherHouse.getY()
                + image.getIconHeight()) {
            return true;
        }
        if (xPos >= otherHouse.getX() && xPos <= otherHouse.getX()
                + image.getIconWidth() && yPos >= otherHouse.getY() && yPos
                <= otherHouse.getY() + image.getIconHeight()) {
            return true;
        }
        return false;
    }
    public abstract boolean canReproduceWithHouse(House otherHouse);
    public abstract House reproduceWithHouse(House otherHouse);
    public abstract boolean isOld();
    public abstract boolean canHarmHouse(House otherHouse);
    public abstract void harmHouse(House otherHouse);
    /**
      * harms the objects health
      * @param amount
      * @return nothing
      */
    public void harm(int amount) {
        health = health - amount;
    }
    /**
      * kills
      * @param none
      * @return none
      */
    public void die() {
        health = 0;
    }
    /**
      * Getter for deadness
      * @param none
      * @return if dead
      */
    public boolean isDead() {
        return (health <= 0);
    }
}
