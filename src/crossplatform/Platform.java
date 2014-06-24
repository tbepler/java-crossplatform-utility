package crossplatform;

import javax.swing.UnsupportedLookAndFeelException;

public abstract class Platform {
	
	private static Platform m_Instance = null;
	
	/**
	 * Returns the appropriate Platform instance for the operating system in which Java
	 * is running.
	 * @return
	 */
	public static Platform getInstance(){
		if(m_Instance == null){
			m_Instance = initPlatform(); 
		}
		return m_Instance;
	}
	
	private static Platform initPlatform(){
		//TODO
		return null;
	}
	
	Platform(){
		//block instantiation
	}
	
	/**
	 * Sets the look and feel to the look and feel most appropriate to this platform.
	 * @throws UnsupportedLookAndFeelException
	 */
	abstract public void usePlatformLookAndFeel() throws UnsupportedLookAndFeelException;
	
	/**
	 * Initializes any platform specific settings to make Java run more like a native
	 * application.
	 */
	abstract public void initPlatformSpecificSettings();
	
	/**
	 * Returns an enumerated type representing the operating system in which the JRE
	 * is running.
	 * @return operating system enumerated type
	 */
	abstract public OS getOperatingSystem();
	
	/**
	 * Sets the {@link QuitHandler} object to be used in the event of a system specific
	 * quit event. Returns true if this platform supports system specific quit events,
	 * false otherwise.
	 * @param h - QuitHandler for dealing with system specific quit events
	 * @return - True if this platform supports system specific quit events, False otherwise
	 */
	abstract public boolean setQuitHandler(QuitHandler h);
	
	/**
	 * Returns the {@link QuitHandler} object currently being used to handle system
	 * specific quit events, if they are supported by this platform.
	 * @return
	 */
	abstract public QuitHandler getQuitHandler();
	
	/**
	 * Sets the {@link PreferencesHandler} object to be used in the event of a system
	 * specific preferences event. Returns true if this platform supports system specific
	 * preferences events, false otherwise.
	 * @param h - PreferencesHandler for dealing with system specific preferences events
	 * @return - True if this platform supports system specific preferences events, False otherwise
	 */
	abstract public boolean setPreferencesHandler(PreferencesHandler h);
	
	/**
	 * Returns the {@link PreferncesHandler} object currently being used to handle system
	 * specific preferences events, if they are supported by this platform.
	 * @return
	 */
	abstract public PreferencesHandler getPreferencesHandler();
	
	/**
	 * Sets the {@link AboutHandler} object to be used in the event of a system specific
	 * about event. Returns true if this platform supports system specific about events,
	 * false otherwise.
	 * @param h - AboutHandler for dealing with system specific about events
	 * @return - True if this platform supports system specific about events, False otherwise
	 */
	abstract public boolean setAboutHandler(AboutHandler h);
	
	/**
	 * Returns the {@link AboutHandler} object currently being used to handle system
	 * specific about events, if they are supported by this platform.
	 * @return
	 */
	abstract public AboutHandler getAboutHandler();
	
	
	
	
	
	
	
}
