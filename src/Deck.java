import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This class simulates a deck of cards and can shuffle, draw, etc.
 * @author Josh
 */
public class Deck
{
    // Constant for number of cards in deck
    public static final int NUM_CARDS_IN_DECK = 52;

    // Array of card objects for deck
    private Card[] thisDeck;

    // Index of top card in deck
    private int topIndex;

    //------------------------------------------------------------------------
    public Deck()
    {
	thisDeck = new Card[52];
	topIndex = 0;
	GenerateDeck();
    }

    //------------------------------------------------------------------------
    /**
     * GenerateDeck creates a deck of 52 card objects, one of each value and
     * suit.
     */
    public void GenerateDeck()
    {
	// Reset top index
	topIndex = 0;

	// Counter for array index
	int deckIndex = 0;

	// Loop to generate cards
	for ( int cardValue = 1; cardValue <= 13; cardValue++ )
	{
	    thisDeck[deckIndex] = new Card(cardValue, Card.Suit.CLUB);
	    deckIndex++;

	    thisDeck[deckIndex] = new Card(cardValue, Card.Suit.DIAMOND);
	    deckIndex++;

	    thisDeck[deckIndex] = new Card(cardValue, Card.Suit.HEART);
	    deckIndex++;

	    thisDeck[deckIndex] = new Card(cardValue, Card.Suit.SPADE);
	    deckIndex++;
	}

	// Shuffles deck
	ShuffleDeck();
    }


    //---------------------------ShuffleDeck------------------------------------
    private void ShuffleDeck()
    {
	// Performs shuffle operation five times to ensure randomized deck
	for(int i = 0; i <= 5; i++)
	{
	    thisDeck = SplitDeck();
	}
    }

    //----------------------------SplitDeck----------------------------------
    // Splits deck in two using a random number between 22 and 27. Returns
    // split array when completed
    private Card[] SplitDeck()
    {
	// Random number generator
	Random splitIndexGenerator = new Random();

	// Index of split
	int splitIndex;

	// Generates a number between 22 and 27 to simulate splitting a deck
	// in half to shuffle
	splitIndex = splitIndexGenerator.nextInt(5) + 22;

	// Creates two arrays simulating the two split decks
	Card[] firstHalfDeck  = new Card[30];
	Card[] secondHalfDeck = new Card[30];

	// Put first half of deck in array
	for (int i = 0; i < splitIndex; i++)
	{
	    firstHalfDeck[i] = thisDeck[i];
	}

	// Put second half of deck in array
	for (int i = splitIndex; i < NUM_CARDS_IN_DECK; i++)
	{
	    secondHalfDeck[i - splitIndex] = thisDeck[i];
	}

	// Combines two arrays back together and returns one array of cards
	return CombineDecks(firstHalfDeck, secondHalfDeck, splitIndex);
    }

    //----------------------------CombineDecks---------------------------------
    // Combines decks back together, alternating between the top card
    // of each of the two decks.
    private Card[] CombineDecks(Card[] firstHalfDeck, Card[] secondHalfDeck, int splitIndex)
    {
	// Counters to keep track of current index of smaller decks
	int firstDeckCounter  = 0,
	    secondDeckCounter = 0,
	    cardIndex         = 0;
	
	Card[] shuffledDeck = new Card[NUM_CARDS_IN_DECK]; // Shuffled deck that is being created

	// Combine deck back together. Loop goes until small deck is out of
	// cards. Remaining cards from larger deck are placed on bottom of deck.
	for ( cardIndex = 0; cardIndex < splitIndex * 2; cardIndex++ )
	{
	    // If even, put card from top of first half in deck
	    if (cardIndex % 2 == 0)
	    {
		shuffledDeck[cardIndex] = secondHalfDeck[secondDeckCounter];
		secondDeckCounter++;
	    }
	    
	    else if (cardIndex % 2 > 0) // If odd, do same for second deck
	    {
		shuffledDeck[cardIndex] = firstHalfDeck[firstDeckCounter];
		firstDeckCounter++;
	    }
	}

	for (int i = cardIndex; i < NUM_CARDS_IN_DECK; i++) // Places remaining cards at end of deck
	{
	    shuffledDeck[i] = secondHalfDeck[secondDeckCounter];
	    secondDeckCounter++;
	}

	return shuffledDeck;
    }

    //----------------------------toString-----------------------------------
    // toString method for testing
    public String toString()
    {
	String line = "";
	for (int i = 0; i < NUM_CARDS_IN_DECK; i++)
	{
	    line += thisDeck[i] + "\n";
	}

	return line;
    }

    //----------------------------drawCard-----------------------------------
    /** Returns card that has the pointer and increments the pointer to keep
        track of the top of deck */
    public Card drawCard()
    {

	Card returnCard = thisDeck[topIndex]; // Makes a copy of card to return
	topIndex++;                           // Increment top of deck
	return returnCard;                    // Draw card
    }


}//End of class
