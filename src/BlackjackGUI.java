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

    // Dimensions of screen
    private int screenWidth;
    private int screenHeight;

    // Listener for buttons
    private buttonListener listener = new buttonListener();

    // Handles all behind-the-scenes work for game
    BlackjackGame game = new BlackjackGame();

    // Panels for card graphics
    DrawPanel cardArea;   //= new DrawPanel(screenWidth,screenHeight);
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
    // Adjusts size, title, close operation, and layout type of GUI.
    private void setWindowSettings()
    {
	getWindowSize();
	window.setSize(screenWidth,screenHeight);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setTitle("Blackjack");
	window.setLayout( new BorderLayout() );
	cardArea = new DrawPanel(screenWidth,screenHeight);
    }
    //------------------------------------------------------------------------
    // Gets current screen size and stores as integer values.
    private void getWindowSize()
    {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	screenHeight = screenSize.height - 37; // Subtracts 37 for Windows taskbar
	screenWidth  = screenSize.width;
    }
    //------------------------------------------------------------------------
    private void setButtonSettings()
    {
	disableButtons();

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
    // Disables all buttons of GUI
    private void disableButtons()
    {
	hitButton.setEnabled(false);
	stayButton.setEnabled(false);
	splitButton.setEnabled(false);
    }

    //------------------------------------------------------------------------
    private void addComponentsToWindow()
    {
	window.add(buttonArea, BorderLayout.SOUTH);
	window.add(cardArea, BorderLayout.CENTER);
	window.setVisible(true);
    }
    //------------------------------------------------------------------------
    // Toggles whether buttons on GUI can be clicked or not. If a hand has
    // already been dealt, the deal button is not clickable and the hit and stay
    // buttons can be clicked. If the player stays, the deal button is clickable
    // and the others are not.
    private void checkButtonStatus()
    {
	if ( !cardArea.game.getHandDealt() || game.getPlayerHand().getBustStatus() )
	{
	    dealButton.setEnabled(true);
	    hitButton.setEnabled(false);
	    stayButton.setEnabled(false);
	}
	else // If hand is not dealt
	{
	    dealButton.setEnabled(false);
	    hitButton.setEnabled(true);
	    stayButton.setEnabled(true);
	}
    }
    //------------------------------------------------------------------------
    // Nested class for button handling
    private class buttonListener implements ActionListener
    {
	public void actionPerformed(ActionEvent buttonClick)
	{
	    if (buttonClick.getSource() == dealButton)
	    {
		cardArea.game.dealCards();
	    }
	    if (buttonClick.getSource() == hitButton)
	    {
		cardArea.game.playerHit();
	    }
	    if (buttonClick.getSource() == stayButton)
	    {
		cardArea.game.setPlayerStay(true);
		cardArea.game.dealerHit();
	    }
	    checkButtonStatus();
	    cardArea.repaint();
	}
    }
}
