/*
 * Assignment 09
 * Description: [Part 2 of 2] VirtualPlant class
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

package virtualPet;

public class VirtualPlant extends VirtualPet {

    /* (2)(1)(a) */
    private final String plantType;

    /* (2)(1)(b) */
    public VirtualPlant(String name, String plantType) {
        super(name);
        this.plantType = plantType;
    }

    /* (2)(1)(c) */
    public String getPlantType() {
        return plantType;
    }

    /**
     * Return plant's stats as a formatted string. (1)(1)(3)(1).
     * <p>
     * Clarified in lecture that overriding either {@link
     * VirtualPet#plainStatus()} or {@link VirtualPet#printStatus()} is
     * acceptable. Here, we are choosing to override the method returning the
     * string as it makes more sense to leave the print method as-is.
     *
     * @return A formatted string that represents a pet's energy and happiness.
     */
    @Override
    public String plainStatus() {
        return String.format("%s Plant Type: %s.", super.plainStatus(), plantType);
    }
}
