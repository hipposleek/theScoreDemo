package theScore.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Onboarding {

	AndroidDriver driver;

	public Onboarding(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.fivemobile.thescore:id/btn_primary")
	private WebElement getstarted_continuebutton;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/accept_button")
	private WebElement ccpa_continuebutton;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/action_button_text")
	private WebElement favoriteleague_continuebutton;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/btn_disallow")
	private WebElement location_maybelater;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/img_logo")
	private List<WebElement> favoriteteams;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/btn_secondary")
	private WebElement messaging_maybelater;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement notification_allow;

	@AndroidFindBy(accessibility = "Ok, Got It")
	private WebElement profile_okaybutton;

	public void onboardingFlow() {
		getstarted_continuebutton.click();
		ccpa_continuebutton.click();
		getstarted_continuebutton.click();
		favoriteleague_continuebutton.click();
		location_maybelater.click();
		favoriteteams.get(0).click(); // choose 1st team based on location
		getstarted_continuebutton.click(); // continue from favorite team
		getstarted_continuebutton.click(); // continue from Notif selection page
		messaging_maybelater.click();
		notification_allow.click();
		// added try/catch since this popup doesn't always appear
		try {
			profile_okaybutton.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}