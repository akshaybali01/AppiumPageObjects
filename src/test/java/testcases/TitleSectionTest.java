package testcases;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.ChooseTopicScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SkipScreen;
import util.ExtentManager;
import utilities.ScrollUtil;

public class TitleSectionTest extends TestBase{
	
	HomeScreen home;
	
	LoginScreen login;
	ChooseTopicScreen topicsScreen;
	SkipScreen skp;
	
	
	@BeforeTest
	public void init() {
		setUp();
		login=new LoginScreen(driver);
		home = new HomeScreen(driver);
		topicsScreen = new ChooseTopicScreen(driver);
		skp = new SkipScreen(driver);
		
	}
	
	@Test
	public void validateTitle() {
		login.getStartedBtn().chooseTopics(3).clickContinue();
		topicsScreen.reachToSkipScreen();
		skp.skipLogin();
		home.goToTitleSection(2);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//takeScreenShot();
		ExtentManager.captureScreenshot();
		ScrollUtil.scrollUp(2, driver);
	}
	
	@AfterTest
	public void quitDriver() {
		tearDown();
	}
	

}
