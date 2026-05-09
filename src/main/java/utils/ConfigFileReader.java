package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader 
{
	private static Properties properties;
	static String basePath = System.getProperty("user.dir");
		
	static 
	{
    		String env = System.getProperty("env");
        try 
        {
        		FileInputStream fis = null;
        		properties = new Properties();
        		
        		fis= new FileInputStream(basePath +"\\src\\test\\resources\\Properties\\credentials.properties");
        		properties.load(fis);
        		
         	if(env.equalsIgnoreCase("QA")) 
         	{
         		fis= new FileInputStream(basePath +"\\src\\test\\resources\\Properties\\qa.properties");
         		properties.load(fis);
         	}
            else if (env.equalsIgnoreCase("UAT")) 
            {
            		fis = new FileInputStream(basePath +"\\src\\test\\resources\\Properties\\uat.properties");
            		properties.load(fis);
            }
            fis.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            throw new RuntimeException("Could not load properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
