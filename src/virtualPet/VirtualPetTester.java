/*
 * Assignment 09
 * Description: [Part 1.1 of 2] VirtualPetTester class
 * Name: Kullathon "Mos" Sitthisarnwattanachai
 * Teammate: Amber Hartigan
 * ID: 921425216
 * Class: CSC 210-03
 * Semester: Fall 2020
 */

package virtualPet;

import java.util.Scanner;

public class VirtualPetTester {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        VirtualPet[] pets = generatePets(promptPetAmount());

        switch (promptAction()) {
            case 1:
                printStatus(pets);
                break;
            case 3:
                feedAllPets(pets);
                break;
            case 2:
                playAllPets(pets);
                break;
            case 4:
                //exit
                return;
        }
    }

    /**
     * Prompt user for amount of pets to create. (1)(1)(1)(a)-(b).
     *
     * @return A valid amount of pets to create.
     */
    private static int promptPetAmount() {
        while (true) {
            System.out.print("Enter the amount of virtual pets to create: ");
            int amt = scan.nextInt();
            if (amt <= 0) {
                System.out.println("Invalid amount. Must be at least one.");
                continue;
            }
            scan.nextLine();
            return amt;
        }
    }

    /**
     * Generate an array of pets from the given amount. (1)(1)(1)(c).
     * <p>
     * Prompts user for the name of each pets.
     *
     * @param amt The valid amount of pets to generate.
     * @return The array of pets.
     */
    private static VirtualPet[] generatePets(int amt) {
        VirtualPet[] pets = new VirtualPet[amt];
        for (int i = 0; i < amt; i++) {
            System.out.printf("Enter the name for pet #%d: ", i + 1);
            pets[i] = new VirtualPet(scan.nextLine());
        }
        return pets;
    }

    /**
     * Prompt user for a menu option. (1)(1)(2).
     *
     * @return An integer corresponding to a valid menu option.
     */
    private static int promptAction() {
        int action;
        while (true) {
            System.out.println("\nChoose a number from the following menu:");
            System.out.println("1. Check statuses");
            System.out.println("2. Feed your virtual pet");
            System.out.println("3. Play with your virtual pet");
            System.out.println("4. End program");
            System.out.print(">>> ");
            action = scan.nextInt();
            if (action < 1 || action > 4) {
                System.out.println("\nInvalid selection. Please enter a valid option.");
                continue;
            }
            System.out.println();
            return action;
        }
    }

    /**
     * Return pet's stats as a formatted string. (1)(1)(3)(1)(a).
     *
     * @param pet The pet instance.
     * @return A formatted string that represents a pet's energy and happiness.
     */
    private static String plainStatus(VirtualPet pet) {
        return String.format("Energy: %d. Happiness: %d.", pet.getEnergy(), pet.getHappiness());
    }

    /**
     * Print the statuses of the pets. (1)(1)(3)(1)(b).
     * <p>
     * In addition to the requirement, this method adds the name of the pet at
     * the start of the string to make the output clearer.
     *
     * @param pets The array of pets.
     */
    private static void printStatus(VirtualPet[] pets) {
        for (VirtualPet pet : pets) {
            System.out.printf("[%s] %s%n", pet.getName(), plainStatus(pet));
        }
    }

    /**
     * Attempt to feed all pets in the given array. (1)(1)(3)(2).
     * <p>
     * Pets that cannot be fed will remain unchanged. Prints the stats of each
     * pet before and after feeding.
     *
     * @param pets The array of pets.
     */
    private static void feedAllPets(VirtualPet[] pets) {
        for (VirtualPet pet : pets) {
            System.out.printf("[%s] %s", pet.getName(), plainStatus(pet));
            pet.feed();
            System.out.printf("  ->  %s%n", plainStatus(pet));
        }
    }

    /**
     * Attempt to play with all pets in the given array. (1)(1)(3)(3).
     * <p>
     * Pets that cannot be played with will remain unchanged. Prints the stats
     * of each pet before and after playing.
     *
     * @param pets The array of pets.
     */
    private static void playAllPets(VirtualPet[] pets) {
        for (VirtualPet pet : pets) {
            System.out.printf("[%s] %s", pet.getName(), plainStatus(pet));
            pet.play();
            System.out.printf("  ->  %s%n", plainStatus(pet));
        }
    }
}
