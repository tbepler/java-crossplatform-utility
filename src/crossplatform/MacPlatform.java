package crossplatform;

import java.awt.Image;
import java.awt.PopupMenu;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.apple.eawt.AppEvent.AboutEvent;
import com.apple.eawt.AppEvent.PreferencesEvent;
import com.apple.eawt.AppEvent.QuitEvent;
import com.apple.eawt.QuitResponse;

class MacPlatform extends Platform{
	
	private QuitHandler m_Quit = null;
	private AboutHandler m_About = null;
	private PreferencesHandler m_Pref = null;
	
	MacPlatform(){
		//package protected
	}
	
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
		
		//set the apple menu About item handler to call back on the crossplatform AboutHandler
		com.apple.eawt.Application.getApplication().setAboutHandler(new com.apple.eawt.AboutHandler(){

			@Override
			public void handleAbout(AboutEvent e) {
				if(m_About != null){
					m_About.about();
				}
			}
			
		});
		
		//set the apple menu Quit item handler to call back on the crossplatform QuitHandler
		com.apple.eawt.Application.getApplication().setQuitHandler(new com.apple.eawt.QuitHandler(){

			@Override
			public void handleQuitRequestWith(QuitEvent e, QuitResponse r) {
				if(m_Quit != null && !m_Quit.quit()){
					r.cancelQuit();
				}else{
					r.performQuit();
				}
			}
			
		});
		
		//set the apple menu Preferences item handler to call back on the crossplatform PreferencesHandler
		com.apple.eawt.Application.getApplication().setPreferencesHandler(new com.apple.eawt.PreferencesHandler(){

			@Override
			public void handlePreferences(PreferencesEvent e) {
				if(m_Pref != null){
					m_Pref.preferences();
				}
			}
			
		});
	}

	@Override
	public OS getOperatingSystem() {
		return OS.MAC;
	}

	@Override
	public boolean setQuitHandler(QuitHandler h) {
		m_Quit = h;
		return true;
	}

	@Override
	public QuitHandler getQuitHandler() {
		return m_Quit;
	}

	@Override
	public boolean setPreferencesHandler(PreferencesHandler h) {
		m_Pref = h;
		return true;
	}

	@Override
	public PreferencesHandler getPreferencesHandler() {
		return m_Pref;
	}

	@Override
	public boolean setAboutHandler(AboutHandler h) {
		m_About = h;
		return true;
	}

	@Override
	public AboutHandler getAboutHandler() {
		return m_About;
	}

	@Override
	public boolean setDockIconBadge(String badge) {
		com.apple.eawt.Application.getApplication().setDockIconBadge(badge);
		return true;
	}

	@Override
	public boolean setDockMenu(PopupMenu menu) {
		com.apple.eawt.Application.getApplication().setDockMenu(menu);
		return true;
	}

	@Override
	public PopupMenu getDockMenu() {
		return com.apple.eawt.Application.getApplication().getDockMenu();
	}

	@Override
	public boolean setDockIconImage(Image i) {
		com.apple.eawt.Application.getApplication().setDockIconImage(i);
		return true;
	}

	@Override
	public Image getDockIconImage() {
		return com.apple.eawt.Application.getApplication().getDockIconImage();
	}

}
