import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Josh
 */
public class BlackjackDriver
{
    public static void main(String[] args)
    {
	Deck test = new Deck();
	BlackjackHand handTest = new BlackjackHand();
	handTest.drawHand(new Card(1, Card.Suit.SPADE), new Card(1, Card.Suit.DIAMOND));
	handTest.hit( new Card(1, Card.Suit.CLUB) );
	System.out.println(handTest);

    }
}

