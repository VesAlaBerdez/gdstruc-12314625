import java.util.NoSuchElementException;

public class PlayerQueue {
    private Player[] queue; // Declare Array to store players
    private int front = 0; // Declare the index of the front of the queue
    private int size; // Declares the number of players currently in the queue

    // Constructor to initialize the queue
    public PlayerQueue(int capacity) {
        queue = new Player[capacity]; // Initialized queue with the given capacity
        front = 0; // Declares the Front to start at index 0
        size = 0; // Declares size to be initially empty
    }

    // Enqueue method to add a player to the queue
    public void enqueue(Player player) {

        // Expands the capacity if the queue is full, e
        if (size == queue.length) {
            Player[] largerQueue = new Player[queue.length * 2];
            System.arraycopy(queue, 0, largerQueue, 0, queue.length);
            queue = largerQueue;
        }
        queue[size] = player; // Adds a player at the correct position
        size++; // Increases the queue size
    }

    // Dequeue method to remove a player from the front of the queue
    public Player dequeue() {

        // Throw an exception if the queue is empty
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Player removedPlayer = queue[front];
        queue[front] = null; // Clear the reference to the removed player
        front++; // Move the front pointer forward
        size--;

        // Shift elements forward to maintain order
        if (size > 0) {
            System.arraycopy(queue, front, queue, 0, size);
        }
        front = 0;  // Reset the front index to 0

        return removedPlayer; // Returns dequeued player
    }

    // Peek method to view the player at the front of the queue without removing them
    public Player peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];  // Returns the player at the front of the queue
    }

    // Get the total number of players currently in the queue
    public int getSize() {
        return size;
    }

    // Print and display the players in the queue
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.print(queue[front + i]);
            if (i < size - 1) {
                System.out.print("\n");
            }
        }
    }
}
