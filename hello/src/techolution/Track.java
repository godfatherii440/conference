package techolution;


import java.util.HashMap;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



/**
 * This is a the class to build a view of events for a given day.
 * @author Godfree Dzebu
 * @version 1.0
 */

/**
 * @author godfreedzebu
 *
 */
public class Track {
	
	//constant used as key to identify lunch slot
	public static final String LUNCH_EVENT_KEY = "Lunch";
	
	//constant used as key to identify networking slot
	public static final String NETWORKING_EVENT_KEY = "Networking";
	
	//constant to set for lunch duration
	public static final long LUNCH_DURATION_MINUTES = 60;
	
	//flag for morning session
	public static final int MORNING_SESSION=1;
	//flag for afternoon session
	public static final int AFTERNOON_SESSION=2;
	
	//set start Track for all Track object
	public static String sStartTime="09:00";
	
	//constant to guide for lunch
	public static final String LUNCH_TIME="11:01";
	// constant set for networking
	public static final String NETWORKING_TIME="17:01";
	
	//flag to manage morning slots
	private boolean bMorningSessionFilled=false;
	
	//flag to manage afternoon slots
	private boolean bAfternoonSessionFilled=false;
	
	//List to hold morning session events
	private HashMap<String,Event> lMorningSession = new HashMap<String,Event>(); 
	
	//List to hold afternoon session events
	private HashMap<String,Event> lAfternoonSession = new HashMap<String,Event>(); 
	
	//Initialise start time
	private LocalTime tStartTime = LocalTime.parse(sStartTime, DateTimeFormatter.ofPattern("HH:mm"));
	
	//Initialise lunch time
	private LocalTime tLunchTime = LocalTime.parse(Track.LUNCH_TIME, DateTimeFormatter.ofPattern("HH:mm"));
	
	//Initialise networking time
	private LocalTime tNetworkingTime = LocalTime.parse(Track.NETWORKING_TIME, DateTimeFormatter.ofPattern("HH:mm"));
	

	/**
	 * Default constructor for the Track object. 
	 */
	public Track() {
		
	}
	
	/**
	 * Constructs a Track object with a start time.
	 * @param tProposedStartTime LocalTime object to sent the start for the given Track object
	 */
	public Track(LocalTime tProposedStartTime) {
		tStartTime = tProposedStartTime;
	}
	
	
	/**
	 * Appends Event objects to the afternoon section of the Track object.
	 * @param events List of Events that form part of the afternoon session
	 */
	public void appendingAfternoonEvents(HashMap<String,Event> events) {
		
		lAfternoonSession = events;
		
	}
	
	/**
	 * Appends Event objects to the morning section of the Track object.
	 * @param events List of Events that form part of the morning session
	 */
	public void appendingMorningEvents(HashMap<String,Event> events) {
		
		lMorningSession = events;
		
	}
	
	
	/**
	 * Getter method for LunchEvent for the Track object
	 * @return LuchEvent for a given Track object
	 */
	public LunchEvent getoLunchTime() {
		return (LunchEvent)lMorningSession.get(Track.LUNCH_EVENT_KEY);
	}

	/**
	 * Getter method for NetworkingEvent for the Track object
	 * @return LuchEvent for a given Track object
	 */
	public NetworkingEvent getoNetworkingTime() {
		return (NetworkingEvent)lAfternoonSession.get(Track.NETWORKING_EVENT_KEY);
	}
	
	/**
	 * Method returns a flag to check of morning session slots are filled.
	 * @return boolean flag to indicated if Morning session slots are filled up.
	 */
	public boolean isbMorningSessionFilled() {
		return bMorningSessionFilled;
	}
	
	
		
	/**
	 * Setter method to set if morning slots are filled.
	 * @param bMorningSessionFilled boolean, true if slots are full.
	 */
	public void setbMorningSessionFilled(boolean bMorningSessionFilled) {
		this.bMorningSessionFilled = bMorningSessionFilled;
	}

	/**
	 * Method returns a flag to check of afternoon session slots are filled.
	 * @return boolean flag to indicated if afternoon session slots are filled up.
	 */
	public boolean isbAfternoonSessionFilled() {
		return bAfternoonSessionFilled;
	}

	/**
	 * Setter method to set if afternoon slots are filled.
	 * @param bAfternoonSessionFilled boolean, true if slots are full.
	 */
	public void setbAfternoonSessionFilled(boolean bAfternoonSessionFilled) {
		this.bAfternoonSessionFilled = bAfternoonSessionFilled;
	}

	
	/**
	 * Prints a Track with all events.
	 */
	public void printTrack() {
		for(Event e:lMorningSession.values()) {	
			System.out.println(e.getEventStartTime().format(DateTimeFormatter.ofPattern("hh:mma ")) + e);
		}
		for(Event e:lAfternoonSession.values()) {	
			System.out.println(e.getEventStartTime().format(DateTimeFormatter.ofPattern("hh:mma ")) + e);
		}
	}

	
	

	/**
	 * This method append Event objects to a Track instance. 
	 * @param sEventKey String indicating key for the event. This is the actual time that the event is meant to start. 
	 * @param oEvent Event object to be added to the track.
	 * @param iEventSessionType integer flag to indicated if session is morning or afternoon.
	 */
	public void appendEvent(String sEventKey, Event oEvent, int iEventSessionType) {
		
		if(iEventSessionType==Track.MORNING_SESSION) {
			lMorningSession.put(sEventKey, oEvent);
		}
		if(iEventSessionType==Track.AFTERNOON_SESSION) {
			lAfternoonSession.put(sEventKey, oEvent);
		}
		
	}
	
	/**
	 * Getter method for latest the LocalTime object for when the Track can start.
	 * @return LocalTime object for a start time.
	 */
	public LocalTime getStartTime() {
		return tStartTime;
	}

	/**
	 * Getter method for latest the LocalTime object for when can lunch can start.
	 * @return LocalTime object for a lunch time.
	 */
	public LocalTime getLunchTime() {
		return tLunchTime;
	}

	/**
	 * Setter method to set a start time for the Track object.
	 * @param tLunchTime LocalTime object for a proposed lunch time for the a given Track
	 */
	public void setLunchTime(LocalTime tLunchTime) {
		this.tLunchTime = tLunchTime;
	}

	/**
	 * Getter method for latest the LocalTime object for when can networking can start.
	 * @return LocalTime object for a networking time.
	 */
	public LocalTime getNetworkingTime() {
		return tNetworkingTime;
	}
	
	/**
	 * Setter method to set a networking time for the Track object.
	 * @param tNetworkingTime LocalTime object for a proposed networking time for the a given Track.
	 */
	public void setNetworkingTime(LocalTime tNetworkingTime) {
		this.tNetworkingTime = tNetworkingTime;
	}
	
}
