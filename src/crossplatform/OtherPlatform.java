package crossplatform;

import java.awt.Image;
import java.awt.PopupMenu;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class OtherPlatform extends Platform{

	@Override
	public void usePlatformLookAndFeel() throws UnsupportedLookAndFeelException {
		String className = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(className);
		} catch (ClassNotFoundException e) {
			throw new UnsupportedLookAndFeelException(className);
		} catch (InstantiationException e) {
			throw new UnsupportedLookAndFeelException(className);
		} catch (IllegalAccessException e) {
			throw new UnsupportedLookAndFeelException(className);
		}
	}

	@Override
	public void initPlatformSpecificSettings() {
		//do nothing
	}

	@Override
	public OS getOperatingSystem() {
		return OS.OTHER;
	}

	@Override
	public boolean setDockIconBadge(String badge) {
		return false;
	}

	@Override
	public boolean setDockMenu(PopupMenu menu) {
		return false;
	}

	@Override
	public PopupMenu getDockMenu() {
		return null;
	}

	@Override
	public boolean setDockIconImage(Image i) {
		return false;
	}

	@Override
	public Image getDockIconImage() {
		return null;
	}

	@Override
	public boolean setQuitHandler(QuitHandler h) {
		return false;
	}

	@Override
	public QuitHandler getQuitHandler() {
		return null;
	}

	@Override
	public boolean setPreferencesHandler(PreferencesHandler h) {
		return false;
	}

	@Override
	public PreferencesHandler getPreferencesHandler() {
		return null;
	}

	@Override
	public boolean setAboutHandler(AboutHandler h) {
		return false;
	}

	@Override
	public AboutHandler getAboutHandler() {
		return null;
	}

}
