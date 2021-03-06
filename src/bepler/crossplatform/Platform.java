package bepler.crossplatform;

import java.awt.Image;
import java.awt.PopupMenu;

import javax.swing.UnsupportedLookAndFeelException;

public abstract class Platform {
	
	private static final String OS_PROPERTY = "os.name";
	private static final String MAC_OS = "mac os";
	private static final String WINDOWS_OS = "windows";
	private static final String LINUX_OS = "linux";
	
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
		String os = System.getProperty(OS_PROPERTY).toLowerCase();
		if(os.startsWith(MAC_OS)){
			return new MacPlatform();
		}
		if(os.startsWith(WINDOWS_OS)){
			return new WindowsPlatform();
		}
		if(os.startsWith(LINUX_OS)){
			return new LinuxPlatform();
		}
		return new OtherPlatform();
	}
	
	protected Platform(){
		//block instantiation except by subclasses
	}
	
	/**
	 * Sets the look and feel to the look and feel most appropriate to this platform.
	 * @throws UnsupportedLookAndFeelException
	 */
	abstract public void usePlatformLookAndFeel() throws UnsupportedLookAndFeelException;
	
	/**
	 * Initializes any platform specific settings necessary to make Java run more like a native
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
	 * Sets the badge used by the dock for this application, if supported by this platform.
	 * @param badge - value to set this application's badge to
	 * @return - True if dock badges are supported by this platform, False otherwise
	 */
	abstract public boolean setDockIconBadge(String badge);
	
	/**
	 * Sets the pop-up menu used by the dock for this application, if supported by this platform.
	 * @param menu - pop-up menu to be shown on the dock
	 * @return - True if dock pop-up menus are supported by this platform, False otherwise
	 */
	abstract public boolean setDockMenu(PopupMenu menu);
	
	/**
	 * Returns the pop-up menu used on the dock for this application, if supported by this platform.
	 * If not supported or no dock menu has been set, then null is returned instead.
	 * @return
	 */
	abstract public PopupMenu getDockMenu();
	
	/**
	 * Sets the image displayed for this application on the dock. Returns true if dock images
	 * are supported by this Platform, false otherwise.
	 * @param i - image that should be displayed on the dock for this application
	 * @return - True if dock icons are supported by this platform, False otherwise
	 */
	abstract public boolean setDockIconImage(Image i);
	
	/**
	 * Returns the image currently being displayed for this application on the dock, or null
	 * if dock icons are not supported by this platform.
	 * @return
	 */
	abstract public Image getDockIconImage();	
	
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
