package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.ChooseTopicScreen;
import screens.LoginScreen;
import screens.SkipScreen;

public class FlipBoardLoginTest extends TestBase{
	
	LoginScreen login;
	ChooseTopicScreen topicsScreen;
	SkipScreen skp;
	
	@BeforeTest
	public void init() {
		setUp();
		login=new LoginScreen(driver);
		topicsScreen = new ChooseTopicScreen(driver);
		//SkipScreen skp= new SkipScreen(driver);
		 skp = new SkipScreen(driver);
		
		
	}
	@Test(priority=1)
	public void validateGetStartButton() {
		login.getStartedBtn();
		
	}
	@Test(priority=2)
	public void selectTopics() {
		topicsScreen.chooseTopics(3).clickContinue();
	}
	
	@Test(priority=3)
	public void reachToSkipScreen() {
		topicsScreen.reachToSkipScreen();
	}
	
	@Test(priority=4)
	public void reachToHomePage() {
		skp.skipLogin();
	}
	
	
	@AfterTest
	public void quitDriver() {
		tearDown();
	}

}
