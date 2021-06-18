package com.NetBanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File scr=new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(scr);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Excepted is:"+e.getMessage());
		}


	}
	public String getApplication()
	{
		String url= pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String username=pro.getProperty("Username");
		return username;
	}
	public String getpassword()
	{
		String password=pro.getProperty("Password");
		return password;
	}

	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	 	
	public String getIEpath()
	{
		String IEpath=pro.getProperty("IEpath");
		return IEpath;
	}
}
