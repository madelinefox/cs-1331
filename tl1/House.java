public class House {
    private String homeowner;
    private int bedrooms;
    private double bathrooms;
    private boolean garage;
    private static int number;

    public House(String owner, int beds, double baths, boolean presence) {
        if (owner != "" && owner != null) {
            homeowner = owner;
        } else {
            homeowner = "HOMEOWNER";
        }
        bedrooms = beds;
        bathrooms = baths;
        garage = presence;
        number++;
    }
    public String getOwner() {
        return homeowner;
    }
    public void setOwner(String owner) {
        if (owner != "" && owner != null) {
            homeowner = owner;
        } else {
            homeowner = "HOMEOWNER";
        }
    }

    public void buildBedroom() {
        bedrooms++;
    }

    public String toString() {
        return "House owned by " + homeowner + ", " + bedrooms + " bed/"
            + bathrooms + " bath, garage: " + garage + ", total houses: "
            + number;
    }
}