package bepler.crossplatform;

import javax.swing.UnsupportedLookAndFeelException;

public class Test {
	
	public static void main(String[] args){
		MacPlatform plat = new MacPlatform();
		try {
			plat.usePlatformLookAndFeel();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
