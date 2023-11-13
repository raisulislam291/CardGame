public class Deck {
    private final Card[] cards;

    private int cardsUsed;

    public Deck() {
        this.cards = new Card[52];
        inititializeDeck();
    }

    private void inititializeDeck() {
        int count = 0;

        // hearts
        for (int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.HEARTS);
        }
        // clubs
        for (int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.CLUBS);
        }
        // diamonds
        for (int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.DIAMONDS);
        }
        // spades
        for (int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.SPADES);
        }
    }

    public void Shuffle() {
        for (int i = 1; i <= cards.length - 1; i++) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
        cardsUsed = 0;
    }
    public Card dealCard(){
        cardsUsed++;
        return cards[cardsUsed -1];
    }
}
