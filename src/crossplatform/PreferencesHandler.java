package crossplatform;


/**
 * This class is used to handle system specific preferences events, if those events
 * are supported by the current platform.
 * 
 * @author Tristan Bepler
 *
 */
public interface PreferencesHandler {
	
	/**
	 * This method is called to handle system specific preferences events, if those
	 * events are supported by the current platform.
	 */
	public void preferences();
	
}
