public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();
        playerLinkedList.addToFront(new Player(1, "Saitama", 999));
        playerLinkedList.addToFront(new Player(2, "Deku", 100));
        playerLinkedList.addToFront(new Player(3, "Saiki K.", 500));
        playerLinkedList.addToFront(new Player(4, "Naruto", 333));
        playerLinkedList.addToFront(new Player(5, "Tanjiro", 50));
        playerLinkedList.addToFront(new Player(6, "Guts", 666));

        System.out.print("\n");
        playerLinkedList.printLinkedList();
        System.out.print("\n");
    }
}