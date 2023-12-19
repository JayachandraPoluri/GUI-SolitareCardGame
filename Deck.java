import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        fillDeck();
    }

    //Using Builder Design Pttern
    private void fillDeck() {
        for (int i = 2; i <= 14; i++) {
            deck.add(new Card(Suit.SPADES, i));
            deck.add(new Card(Suit.HEARTS, i));
            deck.add(new Card(Suit.DIAMONDS, i));
            deck.add(new Card(Suit.CLUBS, i));
        }
    }

    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public int size() {
        return deck.size();
    }

    public Card dealCard() {
        Card card = deck.remove(deck.size() - 1);
        return card;
    }

    public void clearDeck() {
        deck.clear();
    }

    //Using Decorator Design Pattern
    public abstract class DeckPrinter {
        protected DeckPrinter printer;

        public DeckPrinter(DeckPrinter printer) {
            this.printer = printer;
        }

        public abstract void printDeck(List<Card> deck);
    }
    public class FullDeckPrinter extends DeckPrinter {
        public FullDeckPrinter(DeckPrinter printer) {
            super(printer);
        }

        @Override
        public void printDeck(List<Card> deck) {
            for (Card card : deck) {
                System.out.println(card.full_name);
            }

            if (printer != null) {
                printer.printDeck(deck);
            }
        }
    }

}