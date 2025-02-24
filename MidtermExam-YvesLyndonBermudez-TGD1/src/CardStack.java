import java.util.LinkedList;

class CardStack {
    private LinkedList<Card> cardList; // Declares cardList as a LinkedList

    public CardStack() {
        cardList = new LinkedList<>(); // Turns the cardList into an empty LinkedList
    }

    public void push(Card card) {
        cardList.addFirst(card); // // Pushes or Adds to the top of the stack
    }

    public Card pop() {
        return cardList.isEmpty() ? null : cardList.removeFirst(); // Pops or Removes from the top
    }

    public boolean isEmpty() {
        return cardList.isEmpty(); // Returns true if the stack is empty, otherwise returns false
    }

    public int size() {
        return cardList.size(); // Returns the size or number of cards in the stack.
    }

    public void display() {
        System.out.println(cardList); // print 'empty' if the stack is empty. Otherwise, print the card names
    }
}
