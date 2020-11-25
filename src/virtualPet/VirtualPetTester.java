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
        VirtualPet[] pets = generatePets(promptPetAmount());
    }

    public static void loop() {
        switch (promptAction()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
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
}
