package crossplatform;

import java.awt.Image;
import java.awt.PopupMenu;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WindowsPlatform extends Platform{
	
	WindowsPlatform(){
		//package protected
	}

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public OS getOperatingSystem() {
		return OS.WINDOWS;
	}

	@Override
	public boolean setDockIconBadge(String badge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setDockMenu(PopupMenu menu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PopupMenu getDockMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setDockIconImage(Image i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Image getDockIconImage() {
		// TODO Auto-generated method stub
		return null;
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
