/**
 * AccessDeniedException
 *
 * you may ADD to this class header, but do not change the
 * visibility or class name
 */
public class AccessDeniedException extends Exception {
    private SecurityClearance requiredClearance;

    //your code here
    public AccessDeniedException(SecurityClearance requiredClearance) {
        super("This mission requires a clearance of " + requiredClearance);
        this.requiredClearance = requiredClearance;
    }

    //HINT: requiredClearance.toString() gives the enumerated type's name.

    /**
     * this is here so we can test your code; no need to change it
     * @return clearance that was needed to access the mission that threw
     *         the exception.
     */
    public SecurityClearance getRequiredClearance() {
        return requiredClearance;
    }
}
