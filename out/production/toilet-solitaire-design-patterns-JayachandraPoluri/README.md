# SolitaireDesignPatterns
Version: March 16, 2023

**To start command line Version of the game run Main.java

To start GUI Version of the game run SpriteDriverGUI.java**
# Objectives:  
1.	Convert your C++ Toilet Solitaire application to Java. I suggest you use Astah to read the C++ code and spit out the Java code skeleton, then manually translate the program logic for each function.
2.	Update your Java Code to use (at least) five Design Patterns. (Again, Astah might be useful.)
3.	Create a Command-line version and a GUI version. (kinda screams Façade.)
4.	I have provided Java code for reading a “sprite sheet”.
5.  For whatever it is worth, my classes for a Blackjack program were: PlayerCharacter (derived Player and Dealer), Hand, Card, Deck. Dealer was a special version of PlayerCharacter in Blackjack, because they also have a "hand". Yours might not need one. The Dealer also tracked the "rules".
# Instructions
1.	You MUST create any 5 design patterns for the toilet solitaire application (each worth 8 points).
2.	You MUST use Java! Take the reference of your C++ code and convert it to a java application. Note that the code in java should be taken from your C++ code of the previous assignment only!
3.	The assignment should be done following the agile methodology and should be uploaded on GitHub. It should have micro-commits with the proper commit message.
4.	We will grade you based on the code that you have written.
5.	Create a pdf/document file and add a description about which design patterns you implemented and where it is implemented (this is important and will be graded!).
6.	Submit the pdf file and the zip file for the code that is written. Also, provide the link to the GitHub repository.
# Introducing Design Patterns
In this homework, we implement any five of the design patterns in the toilet solitaire assignment. The different types of design patterns are Singleton, Façade, Factory Method, Iterator, Observer, Decorator, Command pattern, Template pattern, etc. The following sections describe a few of them briefly:

**Singleton**: Requiring exactly one instance of an object. This might be useful to insure that the Deck is exactly one instance. It might also be useful for guaranteeing exactly one instance of Player. (Maybe not this second one.)

**Façade**: The façade pattern can make the task of accessing many modules much simpler by providing an additional interface layer. The façade object provides a single interface to the more general facilities of other subsystems. The benefits offered by the façade are as follows:

1.	It shields the subsystem components of the system. In our project, we will provide a GUI to the player to shield different subsystem components or functions.

2.	The façade object eliminates the dependencies between objects.

**Factory Method**: The Factory Method pattern enables the subclasses to decide which class to instantiate. In our game, it can be used to create different types of cards based on their suit and rank. Factory can help create cards without exposing the logic to the client code. The benefit of the Factory Method is to eliminate the need to bind application-specific classes into the code.

**Iterator**: This is built into Java, so you do not get credit for using. The iterator pattern is used when we need to access the elements of an aggregate object sequentially without exposing its internal code. In our project, this pattern can be used to traverse the cards in the deck or in the player’s hand. Iterator can abstract away the details of card traversal and provide a consistent interface to traverse cards. The benefit of the iterator pattern is that it supports variations in collection traversals and simplifies the collection interface.

**Observer**: The observer pattern focuses on defining one-to-one dependency so that if one object state changes, all the dependents are notified and updated automatically. This pattern can be used to notify the player regarding changes in the game. For example, when no moves can be made or when the game is won or lost.
The benefit of this pattern is that it helps understand the coupling between objects and the observer.

**Decorator**: The decorator pattern helps extend the functionality using composition. In the project, this pattern can be used to provide additional functionality to the cards, such as displaying the short and long forms of the card game and keeping track of the card’s score.
This pattern is useful to enhance the extensibility of an object and provide greater flexibility than static inheritance.

**Command Pattern**: The command pattern separates the object invoking the function from the object that performs the function. In other words, it encapsulates a request under an object as a command and passes it to the invoker object. This pattern can be used to represent different commands like dealing cards, removing cards, and shuffling the deck. By encapsulating these commands as objects, it would be easy to track the game and undo player actions. Command pattern makes it easy to add new features as it doesn’t affect the existing classes.

**Template Pattern**: The template pattern defines the skeleton of a function or operation making the generic structure reusable. For example, the game can define a template method for dealing with cards and allow subclasses to implement their own dealing logic.

# Submission
A zip file assignDP.[asurite].zip (asurite should be replaced by your asurite, for me it would be assignDP.mjfindle.zip) and a document describing your patterns about which patterns you used and where they are used. Also provide the GitHub repository link for the assignment. Make sure you commented on your code well and marked where you see your design Patterns.

# References/Useful Resources
[1]	https://www.javatpoint.com/design-patterns-in-java

[2]	https://www.tutorialspoint.com/design_pattern/index.htm

[3]	https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial
