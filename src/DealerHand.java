/**
 *
 * @author Josh
 */

public class DealerHand extends BlackjackHand
{
    //------------------------------------------------------------------------
    // If count is 16 or below, dealer must hit. Otherwise they stay.
    public boolean checkHit()
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
