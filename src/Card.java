/**
 * This class stores a card value
 * @author Josh
 */
public class Card
{
    // Enum for suit of card
    public enum Suit { CLUB, SPADE, HEART, DIAMOND };
    private Suit thisSuit;
    
    // Integer value of card
    private int value;

    // Array for written value of card (1 = Ace, 11 = Jack, etc.)
    private String[] cardNames = { "", "ACE", "TWO", "THREE", "FOUR", "FIVE",
			           "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
			           "JACK", "QUEEN", "KING" };

    private String writtenValue;
    //------------------------------------------------------------------------
    // Default constructor
    public Card()                             
    {
	thisSuit = Card.Suit.CLUB;
	value = 2;
	setWrittenValue();
    }
    //------------------------------------------------------------------------
    // Parameterized constructor
    public Card(int newValue, Suit newSuit)  
    {
	value = newValue;
	thisSuit = newSuit;
	setWrittenValue();
    }
    //------------------------------------------------------------------------
    // Determines written value of card (Jack, Ace, etc.)
    private void setWrittenValue()           
    {
	writtenValue = cardNames[value];
    }
    //------------------------------------------------------------------------
    // toString method for testing
    public String toString()                
    {
	String info;

	info = writtenValue + " of " + thisSuit + "S";

	return info;
    }
    //------------------------------------------------------------------------
    // Get method for numerical value
    public int getValue()
    {
	return value;
    }

    //------------------------------------------------------------------------
    // Get method for suit
    public Suit getSuit()
    {
	return thisSuit;
    }


}
