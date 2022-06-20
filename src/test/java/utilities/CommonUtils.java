package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;	
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {
	
	private static AppiumDriver<MobileElement> driver;
	
	private static URL serverUrl;
	private static DesiredCapabilities caps = new DesiredCapabilities();
	private static String APPIUM_PORT;
	private static int IMPLICIT_WAIT_TIME;
	private static int EXPLICIT_WAIT_TIME;
	private static String BASE_PKG;
	private static String APP_ACTIVITY;
	private static String APP_PATH;
	private static String BROWSER_NAME;
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String DEVICE_NAME;
	private static String UDID;
	private static String BUNDLE_ID;
	private static String APP;
	
	private static Properties prop = new Properties();
	
	private static FileInputStream ip;
	
	public static void loadAndroidConfigprop(String loadPropertyFile) {
		//FileInputStream ip;
		try {
			ip = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Android_FlipBoard.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("application.activity");
		APP_PATH = prop.getProperty("application.path");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		
	}
	
	// setting Android capabilities
	public static void setAndroidCapabilities() {
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, BROWSER_NAME);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);

		
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		
	
		
	}
	
	// Android Stuff
	
	public static AppiumDriver<MobileElement> getAndroidDriver(){
		try {
			serverUrl=new URL("http://localhost:"+APPIUM_PORT+"/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new AndroidDriver<MobileElement>(serverUrl,caps);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		return driver;
	}
	
	
	// iOS stuff
	public static AppiumDriver<MobileElement> getiOSDriver(){
		
		return driver;
	}
	
	
	public static void loadiOSConfigprop(String loadPropertyFile) {
		
		
	}
	
	public void setiOSCapabilities() {
		
	}
	
	
	


}
