package com.guru99.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	File src=new File("./Configuration//config.properties");
	FileInputStream fis;
	Properties pro=new Properties();
	
	public ReadConfig() {
		
		try {
			fis = new FileInputStream(src);
			try {
				pro.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
  
	public String getApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUsername() {
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	public String getChromepath() {
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
	}
	public String getFirefoxpath() {
		String firefoxPath=pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	public String getIEpath() {
		String iePath=pro.getProperty("iepath");
		return iePath;
	}
	
	
}
