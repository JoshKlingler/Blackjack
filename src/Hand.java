/**
 * This class contains general methods and data members that will be inherited
 * by the DealerHand and PlayerHand classes.
 * @author Josh
 */
public class Hand
{
    //------------------------------------------------------------------------
    // Data members:
    protected Card[] hand;  // Player cards
    protected int handValue;       // Numeric value of hand
    protected int numCards;        // Number of cards in hand
    protected boolean bustStatus;  // If true, hand is over 21 and is a bust
    protected boolean splittable;   // If two cards have same value, hand is splittable.

    //------------------------------------------------------------------------
    // Default constructor
    Hand()
    {
	hand       = new Card[20]; // Set size of hand array
	hand[0]    = new Card();   // Initialize first two cards
	hand[1]    = new Card();
	numCards   = 2;            // Set number of cards to two cards initially
	handValue  = 0;            // Set total value of hand to zero
	bustStatus = false;
	splittable = false;
    }

    //------------------------------------------------------------------------
    // Receives two cards from deck and resets hand
    public void drawHand(Card c1, Card c2)
    {
	hand[0] = c1;       // Draw card 1
	hand[1] = c2;       // Draw card 2
	handValue = 0;      // Reset value of hand
	numCards = 2;       // Reset number of cards
	findHandValue();    // Determine value of cards
	bustStatus = false; // Reset bust checker
	checkSplittable();  // See if new hand can be split

    }
    //------------------------------------------------------------------------
    // Checks if hand can be split. If the first two cards dealt to the player
    // are of the same value, the hand can be split.
    private void checkSplittable()
    {
	if (hand[0].getValue() == hand[1].getValue()){
	    splittable = true;
	}
	else{
	    splittable = false;
	}
    }

    //------------------------------------------------------------------------
    public boolean getSplitStatus()
    {
	return splittable;
    }
    //------------------------------------------------------------------------
    public boolean getBustStatus()
    {
	return bustStatus;
    }

    //------------------------------------------------------------------------
    // Draws a card from the deck and puts in hand
    public void hit(Card c)
    {
	hand[numCards] = c; // Place cards in hand
	numCards++;         // Increment number of cards
	findHandValue();    // Determine value of cards
    }

    //------------------------------------------------------------------------
    // Determines numeric value of hand
    private void findHandValue()
    {
	// Reset hand value
	handValue = 0;

	// Traverse cards
	for (int i = 0; i < numCards; i++)
	{
	    // If card is between 2 and 9, add value to total
	    if ( hand[i].getValue() >= 2 && hand[i].getValue() < 10 )
	    {
		handValue += hand[i].getValue();
	    }
	    // If card is 10, Jack, Queen, or King, add 10 to total
	    else if ( hand[i].getValue() >= 10 )
	    {
		handValue += 10;
	    }
	    // If ace, add 11
	    else
	    {
		handValue += 11;
	    }
	}

	// Checks for aces if hand is higher than 21. If an ace is found, it will
	// be worth 1 instead of 11.
	if (handValue > 21)
	{
	    for (int i = 0; i < numCards; i++) // Traverse hand
	    {
		if (hand[i].getValue() == 1 && handValue > 21)   // Check if ace
		{
		    handValue -= 10;           // Set ace to 1 instead of 11
		}
	    }

	    if (handValue > 21) // If hand is still over 21 after checking for aces, it is a bust
	    {
		bustStatus = true;
	    }
	}

    }// End findHandValue method

    //------------------------------------------------------------------------
    // Writes suit/value of cards and total hand value
    public String toString()
    {
	String message = "";

	for (int i = 0; i < numCards; i++)
	{
	    message += hand[i].toString() + ", ";
	}

	message += String.valueOf(handValue);

	return message;
    }
    //------------------------------------------------------------------------
    // Returns number of cards in hand
    public int getNumCards()
    {
	return numCards;
    }
    //------------------------------------------------------------------------
    public int getHandValue()
    {
	return handValue;
    }

}// End BlackjackHand class
