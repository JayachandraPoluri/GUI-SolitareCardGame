public class Card {
    //Used Singleton Design Pattern
    private static Card instance = null;
    public Suit suit;
    public int value;
    public String named_value;
    public String full_name;
    public String short_name;

    Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
        this.named_value = namedValue(value);
        this.full_name = named_value + " of " + suitToString(suit);
        this.short_name = valueToShortString(value) + suitToString(suit).charAt(0);
    }

    public static Card getInstance(Suit suit, int value) {
        if (instance == null) {
            instance = new Card(suit, value);
        }
        return instance;
    }

    public static String suitToString(Suit suit) {
        final String[] names = {"Spades", "Hearts", "Diamonds", "Clubs"};
        return names[suit.ordinal()];
    }

    public static String namedValue(int value) {
        final String[] names = {"", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        return names[value];
    }

    public static String valueToShortString(int value) {
        final String[] names = {"", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        return names[value];
    }
}
