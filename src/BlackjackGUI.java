import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class handles the graphical interface for the blackjack game
 * @author Josh
 */
public class BlackjackGUI extends JFrame
{
    //------------------------------------------------------------------------
    // Buttons
    private JButton dealButton = new JButton("Deal");
    private JButton hitButton  = new JButton("Hit");
    private JButton stayButton = new JButton("Stay");
    private JButton splitButton= new JButton("Split");

    // Listener for buttons
    private buttonListener listener = new buttonListener();

    // Handles all behind-the-scenes work for game
    BlackjackGame game = new BlackjackGame();

    // Panels for card graphics
    DrawPanel cardArea   = new DrawPanel();
    JPanel    buttonArea = new JPanel();

    // Window to diplay rest of components
    JFrame window = new JFrame();
    //------------------------------------------------------------------------
    // Default constructor
    public BlackjackGUI()
    {
	setWindowSettings();
	setButtonSettings();
	addComponentsToWindow();
    }
    //------------------------------------------------------------------------
    private void setWindowSettings()
    {
	window.setSize(1000, 700);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setTitle("Blackjack");
	window.setLayout( new BorderLayout() );
    }
    //------------------------------------------------------------------------
    private void setButtonSettings()
    {
	hitButton.setEnabled(false);
	stayButton.setEnabled(false);
	splitButton.setEnabled(false);

	dealButton.addActionListener(listener);
	hitButton.addActionListener(listener);
	stayButton.addActionListener(listener);
	splitButton.addActionListener(listener);

	buttonArea.add(dealButton);
	buttonArea.add(hitButton);
	buttonArea.add(stayButton);
	buttonArea.add(splitButton);
    }
    //------------------------------------------------------------------------
    private void addComponentsToWindow()
    {
	window.add(buttonArea, BorderLayout.SOUTH);
	window.add(cardArea, BorderLayout.CENTER);
	window.setVisible(true);
    }
    //------------------------------------------------------------------------
    // Nested class for button handling
    private class buttonListener implements ActionListener
    {
	public void actionPerformed(ActionEvent buttonClick)
	{
	    if (buttonClick.getSource() == dealButton)
	    {
		//game.dealCards();
		cardArea.displayPlayerHand(game.player);
	    }
	}
    }
}
