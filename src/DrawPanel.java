import javax.swing.*;
import java.awt.*;
import java.net.URL;

// This class handles the card images
public class DrawPanel extends JPanel
{
    //------------------------------------------------------------------------
    Image cardImage;  // Image containing all 52 cards
    //------------------------------------------------------------------------

    // Constructor
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
            cardImage = Toolkit.getDefaultToolkit().createImage(imageURL);}
    }
    //------------------------------------------------------------------------
    public void paintComponent(Graphics g)
    {
	super.paintComponent(g);
	if (cardImage == null)
	    g.drawString("CARD IMAGE COULD NOT BE FOUND", 100, 100);
	drawCardImage(g, new Card(), 600, 50);
    }
    //------------------------------------------------------------------------
    // Given card object, crops corresponding card from image of all 52 cards
    // Obtained from: http://math.hws.edu/javanotes/c13/s1.html
    public void drawCardImage(Graphics g, Card card, int x, int y) {
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
}