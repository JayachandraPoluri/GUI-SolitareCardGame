import java.awt.image.ImageObserver;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game.");
        System.out.println("To start the game, enter 'start'.");
        Scanner input = new Scanner(System.in);
        String start = input.nextLine();
        Deck deck = new Deck();
        Hand hand = new Hand();
        deck.shuffle();
        // Draw initial hand
        for (int i = 0; i < 4; i++) {
            hand.addCard(deck.dealCard());
        }
        hand.printShortDeck();
        String command;
        int super_count = 0;
        while (deck.size() > 0) {
            System.out.print("Enter a command to remove cards (type 'help' for a list of commands): ");
            command = input.nextLine();

            if (command.equals("help")) {
                System.out.println("use following commands [quit, pair, house, two, four, add_card]");
            } else if (command.equals("quit")) {
                System.out.println("Thanks for playing!");
                return;
            } else if (command.equals("pair")) {
              hand.setRemovalStrategy(new RemovePairStrategy());
                if (!hand.hasPair()) {
                    System.out.println("No pairs found.");
                } else {
                    hand.getRemovalStrategy().removeCards(hand.getHand());
                    System.out.println("Pair removed.");
                    hand.printShortDeck();
                }
            } else if (command.equals("house")) {
                if (!hand.hasHouseRule()) {
                    System.out.println("No house rule found.");
                } else {
                    super_count++;
                    if (super_count == 2) {
                        break;
                    }
                    hand.removeHouseRule();
                    System.out.println("house rule removed.");
                    hand.printShortDeck();
                }
            } else if (command.equals("two")) {
                hand.setRemovalStrategy(new RemoveTwoStrategy());
                if (!hand.hasTwoPair()) {
                    System.out.println("Has no pair  found.");
                    hand.printShortDeck();
                } else {
                   // hand.removeTwo();
                    System.out.println("Has  pair  found.");
                    hand.getRemovalStrategy().removeCards(hand.getHand());
                    hand.printShortDeck();
                }
            } else if (command.equals("four")) {
                hand.setRemovalStrategy(new RemoveFourStrategy());
                if (!hand.hasFourPair()) {
                    System.out.println("Has all four pair not found.");
                    hand.printShortDeck();
                } else {
                    //hand.removeFour();
                    System.out.println("Has all four pair  found.");
                    hand.getRemovalStrategy().removeCards(hand.getHand());
                    hand.printShortDeck();
                }
            } else if (command.equals("add_card")) {
                hand.addCard(deck.dealCard());
                hand.printShortDeck();
            } else {
                System.out.println("Invalid command. Type 'help' for a list of commands.");
            }
        }
        if (hand.size() == 0 || super_count == 2) {
            System.out.println("You score is 0 and it is SUPER WIN");
        } else if (hand.size() < 5) {
            System.out.println("You score is " + hand.size() + " you WIN");
        } else {
            System.out.println("You score is " + hand.size() + " you Lost");
        }
        input.close();
    }


}