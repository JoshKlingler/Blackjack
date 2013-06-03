import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class handles the graphical interface for the blackjack game
 * @author Josh
 */
public class BlackjackGUI extends JFrame
{
    // Buttons
    private JButton dealButton = new JButton("Deal");
    private JButton hitButton  = new JButton("Hit");
    private JButton stayButton = new JButton("Stay");
    private JButton splitButton= new JButton("Split");

    // Panel for card graphics
    DrawPanel cardArea = new DrawPanel();


    public BlackjackGUI() // Default constructor
    {
	JFrame window = new JFrame();
	window.setSize(800, 600);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setTitle("Blackjack");
	window.setLayout( new BorderLayout() );

	JPanel buttonArea = new JPanel();

	hitButton.setEnabled(false);
	stayButton.setEnabled(false);
	splitButton.setEnabled(false);
	
	buttonArea.add(dealButton);
	buttonArea.add(hitButton);
	buttonArea.add(stayButton);
	buttonArea.add(splitButton);

	window.add(buttonArea, BorderLayout.SOUTH);
	window.add(cardArea, BorderLayout.CENTER);
	window.setVisible(true);
    }
}
