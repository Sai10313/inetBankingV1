package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public Properties props;

	public ReadConfig(){
		
		File file=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			props=new Properties();
			try {
				props.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public String getApplicationUrl()
	{
		String url=props.getProperty("baseUrl");
		return url; 
	}
	public String getUsername(){
		String username=props.getProperty("userName");
		return username;
	}
	public String getPassword(){
		String password=props.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String chromePath=props.getProperty("chromepath");
			return chromePath;
	}
	public String getEdgePath() {
		String edgePath=props.getProperty("edgePath");
			return edgePath;
	}


}
