package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBase{
	
	@AndroidFindBy(id="flipboard.app:id/first_launch_get_started_button")
	public WebElement continueButton;

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public ChooseTopicScreen getStartedBtn() {
		continueButton.click();
		return new ChooseTopicScreen(driver);
	}

}
