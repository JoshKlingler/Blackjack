/**
 * This class runs a game of Blackjack.
 * @author Josh
 */
public class BlackjackGame
{
    //------------------------------------------------------------------------
    // Data members:
    DealerHand dealer;
    Hand player;
    Deck deck;

    //------------------------------------------------------------------------
    // Default constructor
    BlackjackGame()
    {
	dealer = new DealerHand();
	player = new Hand();
	deck   = new Deck();
    }
    //------------------------------------------------------------------------
    // Deals two cards to the dealer and the player.
    public void dealCards()
    {
	deck.GenerateDeck();  // Reshuffles deck for every hand

	player.drawHand( deck.drawCard(), deck.drawCard() );
	dealer.drawHand( deck.drawCard(), deck.drawCard() );

	
    }

}
