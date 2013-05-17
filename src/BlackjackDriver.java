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
	//testGame();
	BlackjackGUI test = new BlackjackGUI();
    }

    public static void testGame()
    {
	BlackjackGame test = new BlackjackGame();

	test.dealCards();
	boolean notStay = true;

	while( notStay )
	{
	    int choice = Integer.parseInt( JOptionPane.showInputDialog(test + "\n\nWhat would you like to do?"
							    + "1 = Hit "
							    + "2 = Stay") );
	    if (choice == 1)
	    {
		test.playerHit();
	    }
	    if (choice == 2 || test.player.bustStatus)
	    {
		test.dealerHit();
		JOptionPane.showMessageDialog(null, test);
		notStay = false;
	    }
	}
    }
}

