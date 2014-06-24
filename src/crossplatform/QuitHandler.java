package crossplatform;

/**
 * This class is used to handle system specific quit events, if those events
 * are supported by the current platform.
 * 
 * @author Tristan Bepler
 *
 */
public interface QuitHandler {
	
	/**
	 * This method is called to handle system specific quit events, if those
	 * events are supported by the current platform. This method returns True
	 * if the application should quit, False if the quit should be cancelled.
	 * @return - True if the application should quit, False if the quit should
	 * be cancelled
	 */
	public boolean quit();
	
}
