package techolution;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Core class that represent the model of the event object.
 * @author Godfree Dzebu
 *
 */
public class Event {
	
	private Duration m_d;
	private LocalTime m_startTime = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("HH:mm"));
	private String m_desc;
	private String m_strDuration;
	private boolean m_bAllocatedToTrack;
	
	
	/**
	 * Constructor that takes Duration object and Description for the event
	 * @param tDuration Duration object that represent 
	 * @param strDesc  Description for the event
	 */
	public Event(Duration tDuration,String strDesc) {
		m_d = tDuration;
		m_desc = strDesc;
	}
	
	/**
	 * Constructor that takes Duration as a string and Description for the event
	 * @param sDuration Duration object that represent 
	 * @param strDesc  Description for the event
	 */
	public Event(String sDuration, String strDesc) {
		
		if(sDuration.equalsIgnoreCase("lightning")==true){
			m_d = Duration.ofMinutes(5);
			m_strDuration=" lightning";
		} else {
			m_d = Duration.ofMinutes(Long.parseLong(sDuration.substring(0, 2)));
			m_strDuration = sDuration;
		}
		m_desc=strDesc;
		
	}
	
	
	/**
	 * Another constructor allows for the creation of a Event object and associating the event to a time stamp 
	 * @param tStartTime this variable indicate local time the event is meant to start at
	 * @param sDuration string variable indicating the duration of the event
	 * @param strDesc string variable indicating the description of the event
	 */
	public Event(LocalTime tStartTime,String sDuration,String strDesc) {
		this(sDuration,strDesc);
		m_startTime = tStartTime;
	}
	
	
	/**
	 * This method determines the local time the next event can commence.
	 * @return LocalTime object indicating the next slot, timewise for an the event to start
	 */
	public LocalTime nextEventSlot() {
		if(m_bAllocatedToTrack==false) {
			return m_startTime.plusMinutes(m_d.toMinutes());
		}
		return m_startTime;
	}
	
	/**
	 * This method allows this Event object to a given Track.
	 * 
	 * @param tUpdateableTrack the Track object to associated with the event object
	 * @param sEventSlotName the string description of the time event
	 * @param iEventSessionType integer flag indicating if event is afternoon or morning
	 * @param lProposedStartTime proposed time for a event in a given track passed a LocalTime object
	 */
	public void allocateToTrack(Track tUpdateableTrack,String sEventSlotName,int iEventSessionType, LocalTime lProposedStartTime) {
		m_bAllocatedToTrack=true;
		m_startTime = lProposedStartTime;
		tUpdateableTrack.appendEvent(sEventSlotName, this, iEventSessionType);
	}
	
	
	/**
	 * Getter for startTime variable
	 * @return LocalTime object for a given Event 
	 */
	public LocalTime getEventStartTime() {
		return m_startTime;
	}
	
	/**
	 * Setter for start time LocalTime object
	 * @param tStartTime LocalTime object to set Event object with a local time.
	 */
	public void setEventStartTime(LocalTime tStartTime) {
		m_startTime = tStartTime;
	}
	
	/**
	 * Overrides the default toString method from Object class.
	 * @return String represents object.
	 */
	public String toString() {
		return m_desc +  m_strDuration;
	}

	
	/**
	 * This method returns the minutes associated with the Event object.
	 * @return long representing minutes the Event is meant to take. 
	 */
	public long getDuration() {
		return m_d.toMinutes();
	}
	
}
