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

    public BlackjackGUI()
    {
	JFrame window = new JFrame();
	window.setSize(800, 600);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setTitle("Blackjack");
	window.setLayout( new BorderLayout() );

	JPanel tableArea = new JPanel();
	tableArea.setBackground(Color.GREEN);

	JPanel buttonArea = new JPanel();
	buttonArea.add(dealButton);
	buttonArea.add(hitButton);
	buttonArea.add(stayButton);

	window.add(tableArea, BorderLayout.CENTER);
	window.add(buttonArea, BorderLayout.SOUTH);
	window.setVisible(true);
    }
}
