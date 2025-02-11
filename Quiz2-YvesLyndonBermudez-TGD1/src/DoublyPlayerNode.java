class DoublyPlayerNode { // Class that references both the next and previous nodes.
    private Player player;
    private DoublyPlayerNode next;
    private DoublyPlayerNode prev;

    public DoublyPlayerNode(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public DoublyPlayerNode getNext() {
        return next;
    }

    public void setNext(DoublyPlayerNode next) {
        this.next = next;
    }

    public DoublyPlayerNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyPlayerNode prev) {
        this.prev = prev;
    }
}
