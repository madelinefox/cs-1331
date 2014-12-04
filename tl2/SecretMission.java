/**
 * Secret Mission
 *
 * you may ADD to this class header, but do not change the
 * visibility or class name
 */
public class SecretMission extends Mission {

    public static final String CLASSIFIED_STRING = "This information "
        + "is Classified.";
    private boolean lock;
    private SecurityClearance clearanceLevel;
    //your code here
    public SecretMission(String title, String description) {
        super(title, description);
        this.lock = true;
    }
    public SecretMission(String title, String des, SecurityClearance cl) {
        super(title, des);
        this.lock = true;
        this.clearanceLevel = cl;
    }
    public void setDescription(String description,
                                SecurityClearance clearanceLevel) {
        if (clearanceLevel.ordinal() < this.clearanceLevel.ordinal()) {
        } else if (clearanceLevel.ordinal() >= this.clearanceLevel.ordinal()) {
            super.setDescription(description);
        }
    }
    public String toString() {
        if(lock) {
            return (CLASSIFIED_STRING);
        } else {
            return (super.toString());
        }
    }
    /**
     * unlocks the mission's info, given some security clearance
     * should check the given clearance against the mission's clearance and
     * throw an AccessDeniedException if it is insufficient clearance.
     *
     * You may (must) ADD to this method header, but do not change the
     * visibility, return type, or method name.
     *@param clearance
     *
     */
    public void unlockInfo(SecurityClearance clearanceLevel)
                            throws AccessDeniedException {
        if (clearanceLevel.ordinal() < this.clearanceLevel.ordinal()) {
            throw (new AccessDeniedException(this.clearanceLevel));
        } else if (clearanceLevel.ordinal() >= this.clearanceLevel.ordinal()) {
            this.lock = false;
        }

    }


    /*
        HINT
        the .ordinal() method on an enum value gives you its position relative
        to the other values.
        For example, you can compare like so:
        someClearance.ordinal() < anotherClearance.ordinal()
        someClearance.ordinal() >= anotherClearance.ordinal()
        someClearance.ordinal() == anotherClearance.ordinal()

        e.g, SecurityClearance.CONFIDENTIAL.ordinal() > SecurityClearance.
            SECRET.ordinal() would return true
    */
}
