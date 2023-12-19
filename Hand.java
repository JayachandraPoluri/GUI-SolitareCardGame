import java.util.ArrayList;

interface CardRemovalStrategy {
    void removeCards(ArrayList<Card> hand);
}

class RemovePairStrategy implements CardRemovalStrategy {
    @Override
    public void removeCards(ArrayList<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).value == hand.get(i + 1).value) {
                hand.remove(i);
                hand.remove(i);
                break; // remove only one pair
            }
        }
    }
}

class RemoveTwoStrategy implements CardRemovalStrategy {
    @Override
    public void removeCards(ArrayList<Card> hand) {
        if (hand.size() >= 4 && hand.get(0).suit == hand.get(3).suit) {
            hand.subList(1, 3).clear();
            System.out.println("Removed middle two cards in hand.");
        } else {
            System.out.println("Cannot remove middle two cards in hand.");
        }
    }
}

class RemoveFourStrategy implements CardRemovalStrategy {
    @Override
    public void removeCards(ArrayList<Card> hand) {
        if (hand.size() >= 4 && hand.get(0).value == hand.get(3).value) {
            hand.subList(0, 4).clear();
            System.out.println("Removed first four cards in hand.");
        } else {
            System.out.println("Cannot remove four cards in hand.");
        }
    }
}

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private CardRemovalStrategy removalStrategy;

    public void setRemovalStrategy(CardRemovalStrategy strategy) {
        this.removalStrategy = strategy;
    }

    public CardRemovalStrategy getRemovalStrategy(){
        return this.removalStrategy;
    }
    public void addCard(Card card) {
        hand.add(0, card);
    }

    public void removeCard(int index) {
        hand.remove(index);
    }

    public void removeAllCards() {
        hand.clear();
    }

    public boolean hasPair() {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).value == hand.get(i + 1).value) {
                return true;
            }
        }
        return false;
    }

    public boolean hasHouseRule() {
        if (hand.size() < 4) {
            return false;
        }
        return hand.get(0).suit == hand.get(3).suit && hand.get(2).value == hand.get(3).value;
    }

    public boolean removeHouseRule() {
        if (hasHouseRule()) {
            hand.subList(0, 3).clear();
            return true;
        }
        return false;
    }

    public void printFullDeck() {
        for (Card card : hand) {
            System.out.println(card.full_name);
        }
    }

    public void printShortDeck() {
        for (Card card : hand) {
            System.out.println(card.short_name);
        }
    }

    public int size() {
        return hand.size();
    }

    public void removeCards() {
        if (removalStrategy != null) {
            removalStrategy.removeCards(hand);
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public boolean hasTwoPair() {
        if (hand.size() >= 4 && hand.get(0).suit == hand.get(3).suit) {
            return true;
        }
        return false;
    }

    public boolean hasFourPair() {
        if (hand.size() >= 4 && hand.get(0).value == hand.get(3).value) {
            return true;
        }
        return false;
    }
}
