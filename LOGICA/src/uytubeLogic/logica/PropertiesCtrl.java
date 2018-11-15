package uytubeLogic.logica;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesCtrl {
	private static PropertiesCtrl instance = null;
	
	public static PropertiesCtrl getInstance() {
		if (instance == null)
			instance = new PropertiesCtrl();
		return instance;
	}
	
	public String getProperty(String property) throws IOException{
		Properties prop = new Properties();
		FileReader file = new FileReader(System.getProperty("user.home")+"/Desktop/"+"uytube.properties");
		prop.load(file);
		return prop.getProperty(property);
	}
	
	
}
