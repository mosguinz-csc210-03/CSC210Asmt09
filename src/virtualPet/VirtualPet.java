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

    /* Starting stats */
    public static final int BASE_HAPPINESS = 25;
    public static final int BASE_ENERGY = 25;

    /* Restrictions */
    private static final int MAX_NAME_LENGTH = 30;
    private static final int MAX_FEED_ENERGY = 80;
    private static final int MAX_PLAY_ENERGY = 30;

    /* Action deltas */
    private static final int FEED_HAPPINESS_DELTA = +5;
    private static final int FEED_ENERGY_DELTA = +30;
    private static final int PLAY_HAPPINESS_DELTA = +20;
    private static final int PLAY_ENERGY_DELTA = -15;

    /* Part (1)(2)(i) */
    private String name;
    private int happiness = BASE_HAPPINESS;
    private int energy = BASE_ENERGY;

    public VirtualPet() {
        this.name = "DEFAULT";
    }

    public VirtualPet(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        /* Note that (1)(2)(ii) specifies a limit that is exclusive of 30. */
        if (name.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("Name must less than %d characters in length", MAX_NAME_LENGTH));
        }
        this.name = name;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Feed the pet. Increases happiness and energy.
     * <p>
     * Pet's {@link #energy} must be strictly less than {@link #MAX_FEED_ENERGY}
     * for the action to be effective.
     */
    public void feed() {
        if (energy < MAX_FEED_ENERGY) {
            happiness += FEED_HAPPINESS_DELTA;
            energy += FEED_ENERGY_DELTA;
        }
    }

    /**
     * Play with the pet. Increases happiness and decreases energy.
     * <p>
     * Pet's {@link #energy} must be strictly less than {@link #MAX_PLAY_ENERGY}
     * for the action to be effective.
     */
    public void play() {
        if (energy < MAX_PLAY_ENERGY) {
            happiness += PLAY_HAPPINESS_DELTA;
            energy += PLAY_ENERGY_DELTA;
        }
    }


    /**
     * Return pet's stats as a formatted string. (1)(1)(3)(1)(a).
     *
     * @return A formatted string that represents a pet's energy and happiness.
     */
    public String plainStatus() {
        return String.format("Energy: %d. Happiness: %d.", energy, happiness);
    }

    /**
     * Print the status of the pet. (1)(1)(3)(1)(b).
     */
    public void printStatus() {
        System.out.println(plainStatus());
    }

}
