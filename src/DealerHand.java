/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josh
 */
public class DealerHand extends BlackjackHand
{
    //------------------------------------------------------------------------
    // If count is 16 or below, dealer must hit. Otherwise they stay.
    public boolean checkDraw()
    {
	if (handValue <= 16)
	{
	    return true;
	}
	else
	{
	    return false;
	}
    }
    //------------------------------------------------------------------------
}
