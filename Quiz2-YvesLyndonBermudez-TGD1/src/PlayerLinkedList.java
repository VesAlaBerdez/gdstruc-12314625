public class PlayerLinkedList {

    private PlayerNode head;
    private int size; // In-place counter for the size-tracking

    public PlayerLinkedList() {
        this.size = 0;
    }

    public void addToFront(Player player) {
        PlayerNode newNode = new PlayerNode(player);
        newNode.setNextPlayerNode(head);
        head = newNode;
        size++; // Updates the size-counter by adding an element
    }

    public void removeFirst() { // Remove the first element from the linked list
        if (head != null) {
            head = head.getNextPlayerNode();
            size--; // Updates the size-counter by removing an element
        }
    }

    public int size() { // Updates the counter whenever an element is added or removed.
        return size;
    }

    public boolean contains(Player player) { // Checks if the node's Player object matches the input.
        PlayerNode current = head;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return true;
            }
            current = current.getNextPlayerNode();
        }
        return false;
    }

    public int indexOf(Player player) { // Checks through the list while tracking the index.
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index; // Returns the index if a match is found
            }
            current = current.getNextPlayerNode();
            index++;
        }
        return -1; // Returns -1 if player is not found
    }

    public void printLinkedList() {
        System.out.print("(Head) -> ");
        PlayerNode current = head;

        while (current != null) {
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNextPlayerNode();
        }

        System.out.print("NULL");
    }
}
