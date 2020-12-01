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
    public static final String PET_TYPE = promptPetType();

    public static void main(String[] args) {
        loop();
    }

    /**
     * Run the program's execution loop. Satisfies line limit requirement in
     * (1)(1). Also meets loop requirement for (1)(1)(4).
     */
    public static void loop() {
        VirtualPet[] pets = generatePets(promptPetAmount());

        while (true) {
            switch (promptAction()) {
                case 1 -> printAllStatuses(pets);
                case 3 -> feedAllPets(pets);
                case 2 -> playAllPets(pets);
                case 4 -> {
                    displaySummary(pets);
                    return;
                }
            }
        }
    }

    /**
     * Prompt user for a pet type. (2)(2)(b).
     *
     * @return The string that is the pet type. Either "pet" or "plant".
     */
    private static String promptPetType() {
        while (true) {
            System.out.print("Enter [1] to create animal pets or [2] to create plant pets: ");
            int petType = scan.nextInt();
            scan.nextLine();
            if (petType == 1) return "pet";
            if (petType == 2) return "plant";
            System.out.println("Invalid type. Must be either [1] or [2].");
            continue;
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
     * Print the statuses of the pets. (1)(1)(3)(1)(b).
     * <p>
     * In addition to the requirement, this method adds the name of the pet at
     * the start of the string to make the output clearer.
     *
     * @param pets The array of pets.
     */
    private static void printAllStatuses(VirtualPet[] pets) {
        for (VirtualPet pet : pets) {
            System.out.printf("[%s] %s%n", pet.getName(), pet.plainStatus());
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
            System.out.printf("[%s] %s", pet.getName(), pet.plainStatus());
            pet.feed();
            System.out.printf("  ->  %s%n", pet.plainStatus());
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
            System.out.printf("[%s] %s", pet.getName(), pet.plainStatus());
            pet.play();
            System.out.printf("  ->  %s%n", pet.plainStatus());
        }
    }

    /**
     * Get the mean stats for all of the pets in the array. (1)(1)(3)(4).
     * <p>
     * Takes the average of all the pets' mean energy and happiness score.
     *
     * @param pets The array of pets.
     * @return Mean value of all the pets' stats.
     */
    private static double getMeanStats(VirtualPet[] pets) {
        double sum = 0;
        for (VirtualPet pet : pets) {
            sum += (pet.getEnergy() + pet.getHappiness()) / 2.0;
        }
        return sum / pets.length;
    }

    /**
     * Display the users' pet summary.
     * <p>
     * Uses the mean pet stats to output messages according to the users'
     * performance.
     *
     * @param pets The array of pets
     */
    private static void displaySummary(VirtualPet[] pets) {
        double baseAvg = (VirtualPet.BASE_ENERGY + VirtualPet.BASE_HAPPINESS) / 2.0;
        double userAvg = getMeanStats(pets);

        System.out.println("Here are your pet's stats.");
        printAllStatuses(pets);

        if (userAvg < baseAvg) {
            System.out.print("Please do not buy a pet...");
            if (pets.length > 1) {
                System.out.printf(" let alone %d of them.", pets.length);
            }
        } else {
            System.out.println("Well done! Your pets seems to be happy on average.");
        }
    }
}
