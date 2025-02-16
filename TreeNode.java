
/**
 * The <code>TreeNode</code> class is used for the creation of a tree node object
 * and it stores data in each node.
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode middle;
    private TreeNode right;
    private String label;
    private String message;
    private String prompt;

    /**
     * Parameterized constructor to create a tree node with specific
     * label, message, and prompt. It also sets the left, middle, and right
     * tree nodes to null.
     * @param label
     * The name of the tree node.
     * @param message
     * The message of the tree node that will be displayed.
     * @param prompt
     * THe prompt of the tree node that will be displayed.
     */
    public TreeNode(String label, String message, String prompt) {
        this.left = null;
        this.middle = null;
        this.right = null;
        this.label = label;
        this.message = message;
        this.prompt = prompt;
    }

    /**
     * Gets the left tree node.
     * @return
     * Returns the left tree node.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Sets the left tree node.
     * @param left
     * The left tree node to set.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Gets the middle tree node.
     * @return
     * Returns the middle tree node.
     */
    public TreeNode getMiddle() {
        return middle;
    }

    /**
     * Sets the middle tree node.
     * @param middle
     * The middle tree node to set.
     */
    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }

    /**
     * Gets the right tree node.
     * @return
     * Returns the right tree node.
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Sets the right tree node.
     * @param right
     * The right tree node to set.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Gets the label of the tree node.
     * @return
     * Returns the label of the tree node.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label of the tree node.
     * @param label
     * The label to set for the tree node.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets the message of the tree node.
     * @return
     * Returns the message of the tree node.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message of the tree node.
     * @param message
     * The message to set for the tree node.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the prompt of the tree node.
     * @return
     * Returns the prompt of the tree node.
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Sets the prompt of the tree node.
     * @param prompt
     * The prompt to set for the tree node.
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * A method to check if the tree node is a leaf.
     * @return
     * Returns true if the tree node is a leaf otherwise it will return false.
     */
    public boolean isLeaf() {
        return this.left == null && this.middle == null && this.right == null;
    }
}
