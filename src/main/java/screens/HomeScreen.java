package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase{
	
	@AndroidFindBys({
			
		@AndroidBy(id="flipboard.app:id/sliding_title_strip_container"), // parent
		@AndroidBy(id="flipboard.app:id/sliding_title_text_view")// child
			
	})
	public List<AndroidElement> title;
	
	
	@AndroidFindBy(id="flipboard.app:id/bottom_nav_view_icon")
	public List<AndroidElement> bottomnavigation;

	
	
	

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	
	public void goToTitleSection(int sectionCount) {
		//System.out.println("Akshay here is ur text***");
		System.out.println("Akshay here is ur text***"+title.get(sectionCount-1).getText());
		//System.out.println("Akshay here is ur text***");
		title.get(sectionCount-1).click();
	}
	
	public void selectBottomPannel(int screenNO) {
		bottomnavigation.get(screenNO-1).click();
	}
	

}
