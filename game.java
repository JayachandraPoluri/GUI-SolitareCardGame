import java.util.ArrayList;
import java.util.List;

public class game {

    static private Deck deck = new Deck();
    static private Hand hand = new Hand();
    public static void Start() {

        deck.shuffle();
        // Draw initial hand
        for (int i = 0; i < 4; i++) {
            hand.addCard(deck.dealCard());
        }
        hand.printShortDeck();
    }
    public static List<String> getHandCards(){
        ArrayList<String> sample = new ArrayList<String>();

        for(Card card:hand.getHand()){
            sample.add(card.short_name);
        }
        return sample;
    }

    public static void removePair() {
        hand.setRemovalStrategy(new RemovePairStrategy());
        if (!hand.hasPair()) {
            System.out.println("No pairs found.");
        } else {
            hand.getRemovalStrategy().removeCards(hand.getHand());
            System.out.println("Pair removed.");
            hand.printShortDeck();
        }
    }

    public static void removeHouseRule( int super_count) {
        if (!hand.hasHouseRule()) {
            System.out.println("No house rule found.");
        } else {
            if (super_count == 1) {
                return;
            }
            hand.removeHouseRule();
            System.out.println("House rule removed.");
            hand.printShortDeck();
        }
    }

    public static void removeTwoPair() {
        hand.setRemovalStrategy(new RemoveTwoStrategy());
        if (!hand.hasTwoPair()) {
            System.out.println("Has no pair found.");
            hand.printShortDeck();
        } else {
            hand.getRemovalStrategy().removeCards(hand.getHand());
            System.out.println("Has a pair found.");
            hand.printShortDeck();
        }
    }

    public static void removeFourPair() {
        hand.setRemovalStrategy(new RemoveFourStrategy());
        if (!hand.hasFourPair()) {
            System.out.println("Has all four pair not found.");
            hand.printShortDeck();
        } else {
            hand.getRemovalStrategy().removeCards(hand.getHand());
            System.out.println("Has all four pair found.");
            hand.printShortDeck();
        }
    }

    public static int addCard() {
        int size = 1;
        if(deck.size() > 0) {
            hand.addCard(deck.dealCard());
            System.out.println("Card added");
            hand.printShortDeck();
        }else{
            System.out.println("Game Over");
            size=0;
            return size;
        }

        return size;
    }
}





