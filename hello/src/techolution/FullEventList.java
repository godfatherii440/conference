package techolution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Eventstore i.t.o of CQRS pattern. An in-memory data store of all events.
 * @author Godfree Dzebu
 * @version 1.0
 */
public class FullEventList {

	private List<Event> lTrackEvents = new ArrayList<Event>(); 
	private String sInputFile;
	
	public FullEventList(String sFileInputName) {
		sInputFile = sFileInputName;
	}
	
	/*
	 * This method is used to read lines from a file into a List. 
	 * Similar method are available on the internet, therefore I cannot take credit.
	 * @param String fullpath for the file with text to be read into the list.
	 * @return List Each line of the file is returned as a String object.
	 * @throws FileNotFoundException, EOFException, NullPointerException. 
	 */
	
	private List<String> readFile(String filename){
		
		List<String> records = new ArrayList<String>();
		 
		try{
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null){
		      records.add(line);
		    }
		    reader.close();
		    return records;
		  }
		  catch (Exception e){
		     System.err.format("Exception occurred trying to read '%s'.", filename);
		     e.printStackTrace();
		     return null;
		  }
		}
	
	
	/**
	 * This method loads all Event objects into memory.
	 * @
	 */
	public void generateEvents(){
		
		List<String> records = readFile(sInputFile);
		
		try {
			 for(String sLineItemEvent:records) {
				lTrackEvents.add(new EventParser().parse(sLineItemEvent));
			 }
		}
		catch(Exception e) {
			System.err.print(e);
		}
	}
		
	
	/**
	 * This is the getter method that returns the List of all Event obejcts in memory.
	 * @return List of all Event objects loaded in memory.
	 */
	public List<Event> getEventList(){
		return lTrackEvents;
	}
}
