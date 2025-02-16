/**
 * Wilson Lin
 * 115091711
 * wilson.lin.2@stonybrook.edu
 * Hw 4
 * CSE214.R04 Summer 2024
 */

import java.util.Scanner;

/**
 * The <code>Tree</code> class is used to create a tree object which holds
 * the TreeNode objects.
 */
public class Tree {
    private TreeNode root;

    /**
     * Default constructor that sets the root of the tree to null.
     */
    public Tree() {
        this.root = null;
        this.root = null;
    }

    /**
     * A method add a TreeNode object to the tree.
     * @param label
     * The label of the tree node.
     * @param prompt
     * The prompt of the tree node.
     * @param message
     * The message of the tree node.
     * @param parentLabel
     * The parent label of the tree node.
     * @return
     * Returns true if the node was added to the tree otherwise it returns false.
     */
    public boolean addNode(String label, String prompt, String message, String parentLabel) {
        TreeNode newNode = new TreeNode(label, message, prompt);
        TreeNode cursor = getNodeReference(parentLabel);
        if (root == null) {
            root = newNode;
            return true;
        }
        if (cursor == null) {
            return false;
        }
        while (true) {
            if (cursor.getLeft() == null) {
                cursor.setLeft(newNode);
                return true;
            }
            else if (cursor.getMiddle() == null) {
                cursor.setMiddle(newNode);
                return true;
            }
            else if (cursor.getRight() == null) {
                cursor.setRight(newNode);
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * A method to get the node reference that has the specific label.
     * @param label
     * The label of the tree node.
     * @return
     * Returns the label of the node.
     */
    public TreeNode getNodeReference(String label) {
        return getNodeReference(root, label);
    }

    /**
     * A helper method to get the node reference of the specific label.
     * @param cursor
     * The root node which is named as a cursor where the search starts.
     * @param label
     * The label of the tree node.
     * @return
     * Returns the label of the tree node if it is found.
     */
    public TreeNode getNodeReference(TreeNode cursor, String label) {
        if (cursor == null) {
            return null;
        }
        if (cursor.getLabel().equals(label)) {
            return cursor;
        }
        TreeNode found;
        found = getNodeReference(cursor.getLeft(), label);
        if (found == null) {
            found = getNodeReference(cursor.getMiddle(), label);
        }
        if (found == null) {
            found = getNodeReference(cursor.getRight(), label);
        }
        return found;
    }

    /**
     * A method to traverse the tree in preorder, and it prints
     * the contents of the tree.
     */
    public void preOrder() {
        preOrderTraversalHelper(root);
    }

    /**
     * A helper method to traverse the tree in preorder, and it prints
     * the label, prompt, and message of the nodes in the tree.
     * @param root
     * The root of the tree.
     */
    public void preOrderTraversalHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("Label: " + root.getLabel());
        System.out.println("Prompt: " + root.getPrompt());
        System.out.println("Message: " + root.getMessage());
        System.out.println();
        preOrderTraversalHelper(root.getLeft());
        preOrderTraversalHelper(root.getMiddle());
        preOrderTraversalHelper(root.getRight());
    }

    /**
     * A method to start the question and answer session.
     */
    public void beginSession() {
        System.out.println("Help Session Starting...");
        TreeNode cursor = root;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(cursor.getMessage());
            if(cursor.isLeaf()) {
                System.out.println("Thank you for using our automated help system!");
                break;
            }
            if (cursor.getLeft() != null) {
                System.out.println("1 " + cursor.getLeft().getPrompt());
            }
            if (cursor.getMiddle() != null) {
                System.out.println("2 " + cursor.getMiddle().getPrompt());
            }
            if (cursor.getRight() != null) {
                System.out.println("3 " + cursor.getRight().getPrompt());
            }
            System.out.println("O Exit Session.");
            System.out.print("Choice> ");
            int choice = input.nextInt();
            if (choice == 1 && cursor.getLeft() != null) {
                cursor = cursor.getLeft();
            }
            if (choice == 2 && cursor.getMiddle() != null) {
                cursor = cursor.getMiddle();
            }
            if (choice == 3 && cursor.getRight() != null) {
                cursor = cursor.getRight();
            }
            if (choice == 0) {
                break;
            }
        }
    }

    /**
     * A method to load the tree from the file.
     * @param input
     * The input from the scanner.
     */
    public void loadTree(Scanner input) {
        if (input.hasNextLine()) {
            String label = input.nextLine().trim();
            lineChecker(label);
            String prompt = input.nextLine().trim();
            lineChecker(prompt);
            String message = input.nextLine().trim();
            lineChecker(message);
            this.addNode(label, prompt, message, null);
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parentInfo = line.split(" ");
                String parentLabel = parentInfo[0];
                int numChildren = Integer.parseInt(parentInfo[1]);
                for (int i = 0; i < numChildren; i++) {
                    String childLabel = input.nextLine().trim();
                    String childPrompt = input.nextLine().trim();
                    String childMessage = input.nextLine().trim();
                    this.addNode(childLabel, childPrompt, childMessage, parentLabel);
                }
            }
        }
    }

    /**
     * Method to check if each line of the file is greater than 60 characters.
     * @param line
     * The length of each line of the file.
     * @throws IllegalArgumentException
     * Indicates that there should be less than 60 characters in a line
     */
    public void lineChecker(String line) {
        if (line.length() > 60) {
            throw new IllegalArgumentException("Line length must be less than 60 characters!");
        }
    }
}
