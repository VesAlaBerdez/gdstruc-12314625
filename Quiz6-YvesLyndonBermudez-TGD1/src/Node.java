public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    // Constructor to initialize the nodes
    public Node(int value) {
        this.data = value;
        leftChild = null;
        rightChild = null;
    }

    // Inserts a new value into the subtree
    public void insert(int value) {
        if (data == value) {
            return;
        }

        if (value > data) {
            if (rightChild == null) {
                rightChild = new Node(value);
            }
            else {
                rightChild.insert(value);
            }
        }
        else {
            if (leftChild == null) {
                leftChild = new Node(value);
            }
            else {
                leftChild.insert(value);
            }
        }
    }

    // Performs In-Order Traversal Ascending Order
    public void inOrderTraverse() {
        // Visit left child first
        if (leftChild != null) {
            leftChild.inOrderTraverse();
        }

        System.out.println("Node: " + data);

        // Visit right child
        if(rightChild != null) {
            rightChild.inOrderTraverse();
        }
    }

    // Performs In-Order Traversal Descending Order
    public void inOrderTraverseDescending() {
        // Visit right child first
        if (rightChild != null) {
            rightChild.inOrderTraverseDescending();
        }

        System.out.println("Node: " + data);

        // Visit left child
        if (leftChild != null) {
            leftChild.inOrderTraverseDescending();
        }
    }

    // Searches for a value in the subtree
    public Node get(int value) {
        if (value == data) {
            return this;
        }

        // Search right if value is greater
        if (value > data) {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        // Search left if value is smaller
        else {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        }

        // Return if value not found
        return null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';

    }
}
