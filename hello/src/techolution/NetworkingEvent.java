package techolution;


import java.time.LocalTime;
/**
 * Specialised class that represent the model of the event object.
 * @author Godfree Dzebu
 *
 */
public final class NetworkingEvent extends Event implements EventRestriction {
	
	private final LocalTime m_earlyStartTime =  LocalTime.parse("16:00:00");
	private final LocalTime m_lateStartTime =  LocalTime.parse("17:01:00");
	
	/**
	 * Default constructor for the specialised Event object.
	 */
	public NetworkingEvent() {
		super(LocalTime.parse("16:00:00"),"60min","Networking");
	}
	
	
	/**
	 * Getter method for earliest the NetworkingEvent object can start.
	 * @return LocalTime object for an early start.
	 */
	public LocalTime getEarlyStart() {
		return m_earlyStartTime;
	}
	
	/**
	 * Getter method for latest the NetworkingEvent object can start.
	 * @return LocalTime object for a late start.
	 */
	public LocalTime getLateStart() {
		return m_lateStartTime;
	}
	

	
	/**
	 * Setter method to set a start time for the NetworkingEvent object.
	 * @param tStartTime LocalTime object for a proposed start time for the NetworkingEvent
	 */
	public void setEventStartTime(LocalTime tStartTime) {
		super.setEventStartTime(tStartTime);
		
	}
	
	/**
	 * Overrides the default toString method from Object class.
	 * @return String represents object.
	 */
	public String toString() {
		 return  "Networking";
	 }
}
