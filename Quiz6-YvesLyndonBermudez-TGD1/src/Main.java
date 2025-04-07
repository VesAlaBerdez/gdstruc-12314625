public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);

        // Searches node for a specific value
        int searchValue = 20;
        System.out.println("\nNode for value " + searchValue + " = " + tree.get(searchValue));

        // Display the tree using In-Order Traversal in Ascending Order
        System.out.println("\nIn-order Traversal (Ascending):");
        tree.inOrderTraverse();

        // Display the tree using In-Order Traversal in Descending Order
        System.out.println("\nIn-order Traversal (Descending):");
        tree.traverseInOrderDescending();

        // Get and Print the node with the Minimum value in the tree
        System.out.println("\nMinimum value in the tree: " + tree.getMin().getData());

        // Get and Print the node with the Maximum value in the tree
        System.out.println("\nMaximum value in the tree: " + tree.getMax().getData());
    }
}