package techolution;

import java.time.LocalTime;


/**
 * This interface provides specialization to Event objects. Loosely implementing a Decorator pattern
 * @author Godfree Dzebu
 * @version 1.0
 */
public interface EventRestriction  {

	/**
	 * This method allows the Network Event to be added to Track at the appropriate time slot, else an TimelineRestrictionException is thrown
	 * @param tMainTrack Track object where the NetworkingEvent is to be added.
	 * @param tProposedStart proposed LocalTime object for the NetworkingEvent to start.
	 * @param oNetEvent relevant NetworkingEvent, hence its a static method.
	 * @throws TimelineRestrictionException, NullPointerException is object is not null and inline with set start time for NetworkingEvent object 
	 */
	public static void assignEventToTrack(Track tMainTrack, LocalTime tProposedStart, NetworkingEvent oNetEvent) throws TimelineRestrictionException {
		
		if(tProposedStart.isBefore(oNetEvent.getEarlyStart())==true){
		
			tMainTrack.appendEvent(Track.NETWORKING_EVENT_KEY,oNetEvent,Track.MORNING_SESSION);
		
		}else {
			
			throw new TimelineRestrictionException("Event cannot start before: " + oNetEvent.getEarlyStart().toString());

		}
		
	}
	
}
