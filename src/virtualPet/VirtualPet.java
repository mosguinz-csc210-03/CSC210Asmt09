/*
 * Assignment 09
 * Description: [Part 1.2 of 2] VirtualPet class
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

package virtualPet;

public class VirtualPet {

    private static final int MAX_NAME_LENGTH = 30;
    /* Part (1)(2)(i) */
    private String name;
    private int happiness;
    private int energy;

    public VirtualPet() {
        this.name = "DEFAULT";
        setStartingValues();
    }

    public VirtualPet(String name) {
        setName(name);
        setStartingValues();
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setName(String name) {
        /* Note that (1)(2)(ii) specifies a limit that is exclusive of 30. */
        if (name.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("Name must less than %d characters in length", MAX_NAME_LENGTH));
        }
        this.name = name;
    }

    /**
     * Set the starting values for the instance. Supplemental to (1)(2)(ii).
     */
    private void setStartingValues() {
        happiness = energy = 25;
    }
}
