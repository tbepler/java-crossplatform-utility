package crossplatform;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class MacPlatform extends Platform{
	
	private QuitHandler m_Quit = null;
	private AboutHandler m_About = null;
	private PreferencesHandler m_Pref = null;
	
	@Override
	public void usePlatformLookAndFeel() throws UnsupportedLookAndFeelException {
		System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
		try {
			//first try using the Quaqua look and feel
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			//the Quaqua look and feel didn't work for some reason, so try system look and feel
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e1){
				throw e;
			}
		}
	}

	@Override
	public void initPlatformSpecificSettings() {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.macos.smallTabs", "true");
	}

	@Override
	public OS getOperatingSystem() {
		return OS.MAC;
	}

	@Override
	public boolean setQuitHandler(QuitHandler h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QuitHandler getQuitHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPreferencesHandler(PreferencesHandler h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PreferencesHandler getPreferencesHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setAboutHandler(AboutHandler h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AboutHandler getAboutHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
