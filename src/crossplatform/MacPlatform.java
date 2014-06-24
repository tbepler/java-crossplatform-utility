package crossplatform;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import jprobe.Constants;

class MacPlatform extends Platform{
	
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
		// TODO Auto-generated method stub
		return null;
	}

}
