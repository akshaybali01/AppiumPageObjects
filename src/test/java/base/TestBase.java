package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.AppiumServer;
import utilities.CommonUtils;


public class TestBase {
	
	
	private static final String CommonUtil = null;
	public AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile="Android_FlipBoard.properties";
	public static Logger log=Logger.getLogger(TestBase.class);
	
	
	public void takeScreenShot() {
		Date d = new Date();
		String screenShotFileName= d.toString().replace(":", "_").replace(" ", "_")+".png";
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtil.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\src\\reports\\"+screenShotFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void setUp() {
		
		if(driver==null) {
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
			
			if(loadPropertyFile.startsWith("Android_")) {
				CommonUtils.loadAndroidConfigprop(loadPropertyFile);
				AppiumServer.start();
				log.info("appium server started");
				log.info(loadPropertyFile+"Properties file loaded!!!");
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
				
			}else if(loadPropertyFile.startsWith("iOS_")) {
				
			}
		}
		
	}
	
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		log.info("Test Case execution completed");
		AppiumServer.stop();
		log.info("Appium Server Stooped");
	}
	
	


}
