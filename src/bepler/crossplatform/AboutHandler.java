package bepler.crossplatform;

/**
 * This class is used to handle system specific about events, if those events are
 * supported by the current platform.
 * 
 * @author Tristan Bepler
 *
 */
public interface AboutHandler {
	
	/**
	 * This method is called to handle system specific about events, if those events
	 * are supported by the platform.
	 */
	public void about();
	
}
