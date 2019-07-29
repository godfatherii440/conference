package techolution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The Helper class identifies an event based on duration and description from a string
 * @author Godfree Dzebu
 * @version 1.0
 */
public class EventParser {

	
	
	/**
	 * Default constructor.
	 */
	public EventParser() {
	
	}
	/* This method creates an Event object 
	 * @param sInput this is the string literal that hold event information
	 * @return the method returns an event object
	 * @throws InvalidEventDefinitionException
	 */
	public Event parse(String sInput) throws InvalidEventDefinitionException {
		
		//Pattern to match the duration of events
		Pattern pEventPattern = Pattern.compile("[0-9](min)|(lightning)");
		
		//Input string that contains event line item.
		Matcher mEventPatternMatcher = pEventPattern.matcher(sInput);
		
		//throw an exception if the string violates the definition.
		if(mEventPatternMatcher.find()==false) {
			throw new InvalidEventDefinitionException("Invalid Event Pattern from input string");
		}
		
		//extract the duration of the event.
		String sEventDuration = sInput.substring(mEventPatternMatcher.start()-1, mEventPatternMatcher.end()).trim();
		
		//extract the description of the event.
		String sEventDescription = sInput.substring(0, mEventPatternMatcher.start()-1);
		
		return new Event(sEventDuration,sEventDescription);
	}
}
