package techolution;

import java.time.LocalTime;

/**
 * This is a child class for the Event object that is not specialised as LunchEvent or NetworkingEvent.
 * @author Godfree Dzebu
 * @version 1.0
 */
public class ArbitaryEvent extends Event {

	
	/**
	 * Default constructor for the object. 
	 * @param tStartTime LocalTime object for a proposed start for an Event object.
	 * @param strDuration String object indicating the duration for the event.
	 * @param strDesc String object indicating the description for the event.
	 */
	public ArbitaryEvent(LocalTime tStartTime,String strDuration,String strDesc)  {
		super (tStartTime,strDuration,strDesc);
	}
}
