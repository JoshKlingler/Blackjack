//***************************** BlackjackGame **********************************
//* This class runs the behind the scenes portion of a game of blackjack.      *
//******************************************************************************

public class BlackjackGame
{
    //------------------------------------------------------------------------
    // Data members:
    private DealerHand dealer;  // Dealer's hand
    private Hand player;        // Player's hand
    private Deck deck;          // Deck of cards
    private boolean handDealtStatus;  // If true, hand is in progress
    private boolean playerStay; // If true, player has chosen to stay

    //------------------------------------------------------------------------
    // Default constructor
    BlackjackGame()
    {
	dealer = new DealerHand();
	player = new Hand();
	deck   = new Deck();
	handDealtStatus = false;
	playerStay = false;
    }
    //------------------------------------------------------------------------
    // Deals two cards to the dealer and the player.
    public void dealCards()
    {
	if (!handDealtStatus)
	{
	    deck.GenerateDeck();  // Reshuffles deck for every hand

	    player.drawHand( deck.drawCard(), deck.drawCard() );
	    dealer.drawHand( deck.drawCard(), deck.drawCard() );

	    handDealtStatus = true;
	    playerStay = false;
	}

    }
    //------------------------------------------------------------------------
    // Returns status of handDealtStatus
    public boolean getHandDealtStatus()
    {
	return handDealtStatus;
    }
    //------------------------------------------------------------------------
    // Returns player hand
    public Hand getPlayerHand()
    {
	return player;
    }
    //------------------------------------------------------------------------
    // Returns dealer hand
    public Hand getDealerHand()
    {
	return dealer;
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
	handDealtStatus = false;
    }

    //------------------------------------------------------------------------
    // Player adds a card to their hand
    public void playerHit()
    {
	player.hit( deck.drawCard() );
	if(player.getBustStatus()){
	    dealerHit();
	}
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
