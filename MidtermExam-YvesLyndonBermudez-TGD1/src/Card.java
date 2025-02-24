class Card {
    private int id; // Stores id identifier
    private String name; // Stores name of the cards

    public Card(int id, String name) { // Constructor to give the cards an id and name
        this.id = id;
        this.name = name;
    }

    public int getId() { // Getter to access id of the card
        return id;
    }

    public String getName() { // Getter to access name of the card
        return name;
    }

    @Override // Override the String to return the card's name
    public String toString() {
        return name;
    }
}