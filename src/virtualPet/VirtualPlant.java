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


}
