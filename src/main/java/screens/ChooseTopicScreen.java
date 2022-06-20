package screens;

import java.sql.ClientInfoStatus;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.ExtentListeners;

public class ChooseTopicScreen extends ScreenBase{
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_topic_row_topic_tag")
	public List<AndroidElement> topics;
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_continue_button")
	public AndroidElement continueButton;
	
	@AndroidFindBy(id="flipboard.app:id/edu_full_screen_sheet_action_primary")
	public AndroidElement continueButton1;
	
	@AndroidFindBy(id="flipboard.app:id/edu_full_screen_sheet_action_primary")
	public AndroidElement continueButton2;
	
	@AndroidFindBy(id="flipboard.app:id/account_login_buttons_skip")
	public AndroidElement skipLoginButton;

	public ChooseTopicScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	public ChooseTopicScreen chooseTopics(int topicsCount) {
		
		for(int i=0;i<topicsCount;i++) {
			topics.get(i).click();
		}
		return this;
	}
	
	public void clickContinue() {
		continueButton.click();
		ExtentListeners.testReport.get().log(Status.INFO, "Clicking on continue Button");

	}
	
	public SkipScreen reachToSkipScreen() {
		continueButton1.click();
		continueButton2.click();
		return new SkipScreen(driver);
	}
	




}
