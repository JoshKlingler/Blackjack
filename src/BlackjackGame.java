/**
 * This class runs a game of Blackjack.
 * @author Josh
 */
public class BlackjackGame
{
    //------------------------------------------------------------------------
    // Data members:
    public DealerHand dealer;   // Dealer's hand
    public Hand player;         // Player's hand
    private Deck deck;          // Deck of cards
    private boolean handDealt;  // If true, hand is in progress
    private boolean playerStay; // If true, player has chosen to stay

    //------------------------------------------------------------------------
    // Default constructor
    BlackjackGame()
    {
	dealer = new DealerHand();
	player = new Hand();
	deck   = new Deck();
	handDealt = false;
	playerStay = false;
    }
    //------------------------------------------------------------------------
    // Deals two cards to the dealer and the player.
    public void dealCards()
    {
	if (!handDealt)
	{
	    deck.GenerateDeck();  // Reshuffles deck for every hand

	    player.drawHand( deck.drawCard(), deck.drawCard() );
	    dealer.drawHand( deck.drawCard(), deck.drawCard() );

	    handDealt = true;
	    playerStay = false;
	}

    }
    //------------------------------------------------------------------------
    // Returns status of handDealt
    public boolean getHandDealt()
    {
	return handDealt;
    }
    //------------------------------------------------------------------------
    public boolean getPlayerStay()
    {
	return playerStay;
    }
    //------------------------------------------------------------------------
    public void setPlayerStay(boolean stay)
    {
	playerStay = stay;
    }

    //------------------------------------------------------------------------
    // Dealer draws cards until they either bust or are greater than 16
    public void dealerHit()
    {
	while ( dealer.needsHit() )
	{
	    dealer.hit( deck.drawCard() );
	}
	handDealt = false;
    }

    //------------------------------------------------------------------------
    // Player adds a card to their hand
    public void playerHit()
    {
	player.hit( deck.drawCard() );
    }

    //------------------------------------------------------------------------
    // toString method for testing
    public String toString()
    {
	String message = "";
	message +="Dealer: " + dealer + "\n"
		+ "Player: " + player;

	return message;
    }
    //------------------------------------------------------------------------
}
