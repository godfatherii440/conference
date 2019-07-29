package techolution;

import java.time.Duration;

/**
 * Specialised class that represent the model of the event object.
 * @author Godfree Dzebu
 *
 */
public class LunchEvent extends Event {

	
	/**
	 * Default constructor for the specialised Event object.
	 */
	public LunchEvent() {
		super(Duration.ofMinutes(60),"Lunch");
	}
 
	/**
	 * Overrides the default toString method from Object class.
	 * @return String represents object.
	 */
	public String toString() {
	 return "Lunch";
	}
}
