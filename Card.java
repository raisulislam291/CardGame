

public class Card {
    private final int value;
    private final Suit suit;

    public Card(int theValue, Suit theSuit) {
        this.value = theValue;
        this.suit = theSuit;
    }

    public int getValues() {
        return value;
    }

    public Suit geSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit + "" + getValuesAsString();
    }

    public String getValuesAsString() {
        return switch (value) {
            case 1 -> "Ace";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> throw new IllegalArgumentException("Unexpected value: " + value);
        };
    }
}
