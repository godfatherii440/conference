package techolution;


/**
 * This class is the entry point and the main application class.
 * @author Godfree Dzebu
 * @version 1.0
 */
public class ConferenceApp {

	public static void main(String[] args){
		try {
		String filepath  = "/Users/godfreedzebu/events.txt";
		if (args.length>0) {
			filepath  = args[0].toString();
		}
		 FullEventList fl = new FullEventList(filepath);
		 fl.generateEvents();
		 TrackList listTl = new TrackList();
		 int i = 1;
		 for(Track t:listTl.buildTracks(fl)) {
			System.out.println("Track "+ i++);
			t.printTrack();
			 
		 }
		
		}
		catch(Exception e) {
			System.err.print(e);
		}
		
	}

}
