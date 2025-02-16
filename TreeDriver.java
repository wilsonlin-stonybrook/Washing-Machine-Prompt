/**
 * Wilson Lin
 * 115091711
 * wilson.lin.2@stonybrook.edu
 * Hw 4
 * CSE214.R04 Summer 2024
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The <code>TreeDriver</code> class is used to take user inputs and a file.
 * It will be used to simulate the tree.
 */
public class TreeDriver {
    public static void main(String[] args) {
        String option;
        Tree tree = new Tree();
        Scanner input = new Scanner(System.in);
        while (true) {
            printOptions();
            option = input.next().toUpperCase();
            input.nextLine();
            try {
                switch (option) {
                    case "L":
                        System.out.print("Enter the file name> ");
                        String filename = input.nextLine();
                        Scanner file = null;
                        if (filename.length() > 20) {
                            throw new IllegalArgumentException("Filename can not be longer than 20 characters.");
                        }
                        file = new Scanner(new File(filename));
                        tree.loadTree(file);
                        System.out.println("Tree created successfully!");
                        break;
                    case "H":
                        tree.beginSession();
                        break;
                    case "T":
                        tree.preOrder();
                        break;
                    case "Q":
                        System.out.println("Thank you for using our automated help services!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Input!");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                System.out.println();
            }
        }
    }

    /**
     * A method to print out the options of the menu.
     */
    private static void printOptions() {
        System.out.println("Menu: ");
        System.out.println("L - Load a Tree");
        System.out.println("H - Begin a Help Session");
        System.out.println("T - Traverse the Tree in preorder.");
        System.out.println("Q - Quit");
        System.out.print("Choice> ");
    }
}
