public enum Suit {
    DIAMONDS("♦"),
    HEARTS("♥"),
    CLUBS("♣"),
    SPADES("♠");

    private final String value;

    Suit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
