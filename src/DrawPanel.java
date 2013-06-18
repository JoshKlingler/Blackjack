import javax.swing.*;
import java.awt.*;
import java.net.URL;

// This class handles the card images
public class DrawPanel extends JPanel
{
    //------------------------------------------------------------------------
    private Image cardImage;  // Image containing all 52 cards
    public Graphics g;
    public BlackjackGame game = new BlackjackGame();
    //------------------------------------------------------------------------
    // Default constructor
    public DrawPanel()
    {
	setBackground(Color.GREEN);
	loadImage();
    }
    //------------------------------------------------------------------------
    // Retreives image of all 52 cards from memory. Image must be present in
    // file path. Image is null if not found.
    // Obtained from: http://math.hws.edu/javanotes/c13/s1.html
    private void loadImage()
    {
	ClassLoader cl = DrawPanel.class.getClassLoader();
	URL imageURL = cl.getResource("cards.png");
	if (imageURL != null){
            cardImage = Toolkit.getDefaultToolkit().createImage(imageURL);
	}
    }
    //------------------------------------------------------------------------
    protected void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	if (cardImage == null){
	    g.drawString("CARD IMAGE COULD NOT BE FOUND", 100, 100);}

	displayPlayerHand(g);
	if (game.getHandDealt() && !game.getPlayerStay() ){
		displayDealerHiddenHand(g);}
	else{
	    displayDealerHand(g);}
    }
    //------------------------------------------------------------------------
    /*
     * Given card object, crops corresponding card from image of all 52 cards
     * and displays at given x/y coordinate on the panel.
     * Obtained from: http://math.hws.edu/javanotes/c13/s1.html
    */
    private void displayCardImage(Graphics g, Card card, int x, int y) {
         int cx;    // x-coord of upper left corner of the card inside cardsImage
         int cy;    // y-coord of upper left corner of the card inside cardsImage
         if (card == null) {
            cy = 4*123;   // coords for a face-down card.
            cx = 2*79;
         }
         else {
            cx = (card.getValue()-1)*79;
            switch (card.getSuit())
	    {
		case CLUB:
		   cy = 0;
		   break;
		case DIAMOND:
		   cy = 123;
		   break;
		case HEART:
		   cy = 2*123;
		   break;
		default:  // spades
		   cy = 3*123;
		   break;
            }
         }
         g.drawImage(cardImage,x,y,x+79,y+123,cx,cy,cx+79,cy+123,this);
      }
    //------------------------------------------------------------------------
    // Receives player's hand as paramter and displays card images on the bottom
    // portion of the panel.
    public void displayPlayerHand(Graphics g)
    {
	for (int i = 0; i < game.player.getNumCards(); i++)
	{
	    displayCardImage(g, game.player.hand[i], (80*i) + 450, 450);
	}
    }
    //------------------------------------------------------------------------
    public void displayDealerHand(Graphics g)
    {
	for (int i = 0; i < game.dealer.getNumCards(); i++)
	{
	    displayCardImage(g, game.dealer.hand[i], (80*i) + 450, 50);
	}
    }
    //------------------------------------------------------------------------
    // For initial hand. Player can only see one the first card in the dealer's
    // hand. The other card is flipped over.
    public void displayDealerHiddenHand(Graphics g)
    {
	displayCardImage(g, game.dealer.hand[1], 450, 50);
	displayCardImage(g, null, 530, 50);
    }
    //------------------------------------------------------------------------
    // Draws the value of the player's hand to the screen.
    public void displayMessage()
    {
	
    }

}
