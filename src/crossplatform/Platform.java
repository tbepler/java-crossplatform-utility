package crossplatform;

public abstract class Platform {
	
	private static Platform m_Instance = null;
	
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
	
	private Platform(){
		//block instantiation
	}
	
}
