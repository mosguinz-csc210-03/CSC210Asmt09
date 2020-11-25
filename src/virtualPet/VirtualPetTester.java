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
        promptPetAmount();
    }

    /**
     * Prompt user for amount of pets to create. (1)(1)(a)-(b).
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
}
