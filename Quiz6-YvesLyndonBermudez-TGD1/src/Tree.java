public class Tree {
    private Node root;

    // Inserts a new value into the tree
    public void insert(int value) {
        // Tree is empty
        if (root == null) {
            root = new Node(value);
            return;
        }

        root.insert(value);
    }

    // Performs an In-Order Traversal Ascending Order
    public void inOrderTraverse() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        root.inOrderTraverse();
    }

    // Searches node for a specified value
    public Node get(int value) {
        // tree is empty
        if (root == null) {
            return null;
        }

        return root.get(value);
    }

    // Performs an In-Order Traversal Descending Order
    public void traverseInOrderDescending() {
        if (root == null) {
            System.out.println("Tree is Empty.");
            return;
        }

        root.inOrderTraverseDescending();
    }

    // Gets the node with the minimum value in the tree
    public Node getMin() {
        if (root == null) {
            return null;
        }

        // Traverses to the leftmost node
        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    // Gets the node with the maximum value in the tree
    public Node getMax() {
        if (root == null) {
            return null;
        }

        // Traverses to the rightmost node
        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }
}
