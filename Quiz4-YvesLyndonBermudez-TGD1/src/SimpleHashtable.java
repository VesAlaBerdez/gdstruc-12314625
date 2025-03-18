public class SimpleHashtable {
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void put(String key, Player player) {
        int index = hashKey(key);

        if (isOccupied(index)) {
            // Perform Linear Probing
            int stoppingIndex = index;
            int startIndex = index; // Adds a check for full table

            if (index == hashtable.length - 1) {
                index = 0;
            }
            else {
                index++;
            }

            while (index != stoppingIndex && isOccupied(index)) {
                index = (index + 1) % hashtable.length;
                if (index == startIndex) { // Prevent infinite loop if table is full
                    System.out.println("Hashtable is full, cannot insert key: " + key);
                    return;
                }
            }
        }

        hashtable[index] = new SavedPlayer(key, player);
    }

    public int findIndex(String key) {
        int index = hashKey(key);
        SavedPlayer savedPlayer = hashtable[index];

        if (savedPlayer == null) {
            return -1;
        }

        if (!key.equals(savedPlayer.getKey())) {
            // perform linear probing
            int  stoppingIndex = index;
            boolean found = false;

            //index = (index + 1) % hashtable.length;
            if (index == hashtable.length - 1) {
                index = 0;
            }
            else {
                index++;
            }

            while (index != stoppingIndex && !found) {
                if(isOccupied(index)) {
                    savedPlayer = hashtable[index];

                    if (key.equals(savedPlayer.getKey())) {
                        found = true;
                        break;
                    }
                }

                index = (index + 1) % hashtable.length; // Ensure it increments
            }

            if (!found) {
                index = -1;
            }
        }

        return index;
    }

    public Player get(String key) {
        int index = findIndex(key);

        if (index == -1) {
            return null;
        }

        return hashtable[index].getValue();
    }

    // Removes a player from the hash table while using linear probing
    public void remove(String key) {
        int index = findIndex(key); // Locates the index of the key

        if (index == -1) {
            // Print the message if key not found
            System.out.println("Key " + key + " not found.");
            return;
        }

        // Print removed player
        System.out.println("\nRemoving player: " + hashtable[index].getValue());
        hashtable[index] = null;

        // Rehashing process for linear probing where the elements shift to maintain the proper indexing
        int nextIndex = (index + 1) % hashtable.length;

        while (isOccupied(nextIndex)) {
            SavedPlayer temp = hashtable[nextIndex]; // Stores the displaced player
            hashtable[nextIndex] = null; // Remove the player from current position

            // Reinserts the player to a new position
            put(temp.getKey(), temp.getValue());

            nextIndex = (nextIndex + 1) % hashtable.length;
        }
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (isOccupied(i)) {
                System.out.println(i + " - " + hashtable[i]);
            }
            else {
                System.out.println(i + " - NULL");
            }
        }
    }
}
