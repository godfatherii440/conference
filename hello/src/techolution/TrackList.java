package techolution;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a the class to build a view of events for a given day.
 * @author Godfree Dzebu
 * @version 1.0
 */
public class TrackList {
	
	private FullEventList oFullEventList;
	
	private String sFileWithEvents;

	
	/**
	 * Default constructor
	 */
	public TrackList() {
		
	}
	
	
	/**
	 * Getter method to retrieve the list of tracks.
	 * @return FullEventList the full list used to build the tracks.
	 */
	public FullEventList getFullEventList() {
		return oFullEventList;
	}

	/**
	 * Setter method for the FullEventList object contains the full database of events 
	 * @param oFullEventList FullEventList object contains the full database of events
	 */
	public void setFullEventList(FullEventList oFullEventList) {
		this.oFullEventList = oFullEventList;
	}

	
	

	/**
	 * 
	 * Helper method to generate a view of Track objects filled with Event objects.
	 * @param lAllEvents FullEventList full database of events,
	 * @return List<Track> view of events organised as Tracks.
	 */
	public List<Track> buildTracks(FullEventList lAllEvents) {
	
		lAllEvents.generateEvents();
		List <Event> lListAllEvents = lAllEvents.getEventList();
		//int iNumberOfTracks = 1; 
		List<Track> buildTracks = new ArrayList<Track>();
		Track oTrack = new Track();
		LocalTime tTrackingTime = oTrack.getStartTime();
		LocalTime lLunchTime = oTrack.getLunchTime();
		LocalTime lNetworkingTime = oTrack.getNetworkingTime();		
		//int iIndex=0;
		for(Event oEvent:lListAllEvents){
	
			oEvent.setEventStartTime(tTrackingTime);
				
			if(tTrackingTime.isBefore(lLunchTime)) {
				oTrack.appendEvent(tTrackingTime.toString(), oEvent, Track.MORNING_SESSION);
				//System.out.println("Track -"+ iNumberOfTracks + "- Morning Slot at : "+ tTrackingTime.toString() + " - Next Event at  "+ oEvent.nextEventSlot());
				if(oEvent.nextEventSlot().isAfter(lLunchTime)) {
					tTrackingTime = tTrackingTime.plusMinutes(Track.LUNCH_DURATION_MINUTES);
					LunchEvent lEvent = new LunchEvent();
					lEvent.setEventStartTime(tTrackingTime);
					oTrack.appendEvent(tTrackingTime.toString(), lEvent, Track.MORNING_SESSION);
					//System.out.println(new LunchEvent());
					
				}
				
			}
			
			if(tTrackingTime.isAfter(lLunchTime)&&tTrackingTime.isBefore(lNetworkingTime)) {
				oTrack.appendEvent(tTrackingTime.toString(), oEvent, Track.AFTERNOON_SESSION);
				//System.out.println("Track -"+ iNumberOfTracks + "-Afternoon Slot at : "+ tTrackingTime.toString() + " -  "+ oEvent.toString());
				if(oEvent.nextEventSlot().isAfter(lNetworkingTime)) {
					NetworkingEvent oNetworkingEvent = new NetworkingEvent();
					oNetworkingEvent.setEventStartTime(tTrackingTime);
					oTrack.appendEvent(tTrackingTime.toString(), oNetworkingEvent, Track.AFTERNOON_SESSION);
					//System.out.println(new NetworkingEvent() + " starts at " + tTrackingTime);
					tTrackingTime = tTrackingTime.plusMinutes(60);
				}
			}
			tTrackingTime = tTrackingTime.plusMinutes(oEvent.getDuration());
			//iIndex++;
			if(tTrackingTime.isAfter(lNetworkingTime)){
				//reset Start Time
				buildTracks.add(oTrack);
				oTrack = new Track();
				tTrackingTime = oTrack.getStartTime();
				//iNumberOfTracks++;
			}
		}
		
		//buildTracks.add(oTrack);
		return buildTracks;
	}
	
	/**
	 * This helper method creates an returns a Track object with a specified start time.
	 * @param tStartTime LocalTime set the start time for the instantiated Track object.
	 * @return Track instantiates and returns a Track object.
	 */
	public Track buildTrack(LocalTime tStartTime) {
		return new Track(tStartTime);
	}

	
	/**
	 * Getter method for the file events database.
	 * @return String filename of the events database.
	 */
	public String getFileWithEvents() {
		return sFileWithEvents;
	}

	
	/**
	 * Setter method for the file containing events database.
	 * @param sFileWithEvents String to be set with filename, full path containing the events database. 
	 */
	public void setFileWithEvents(String sFileWithEvents) {
		this.sFileWithEvents = sFileWithEvents;
	}
}
