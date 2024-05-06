package theScore.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import theScore.utils.AndroidActions;

public class TeamStats extends AndroidActions {

	AndroidDriver driver;

	public TeamStats(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_bar_text_view")
	private WebElement searchbar;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_src_text")
	private WebElement search;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/txt_name")
	private List<WebElement> teamname;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/team_name")
	private WebElement teampagename;

	@AndroidFindBy(accessibility = "Team Stats") //no text in this element
	private WebElement teamstatstab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='TEAM STATS']")
	private WebElement teamstatstabtext;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/header_text")
	private List<WebElement> headertext;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/header_secondary_text")
	private List<WebElement> ranktext;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/text_category_name")
	private List<WebElement> categoryname;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/text_value")
	private List<WebElement> category_value;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/text_formatted_rank")
	private List<WebElement> teamranking;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/view_progress")
	private List<WebElement> progressbar;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/view_inverse")
	private List<WebElement> progressbar_inverse;
	
	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement backarrow;
	
	@AndroidFindBy(accessibility = "All")
	private WebElement alltab;
	
	@AndroidFindBy(accessibility = "Teams")
	private WebElement teamstab;
	
	@AndroidFindBy(accessibility = "Players")
	private WebElement playerstab;
	
	@AndroidFindBy(accessibility = "News")
	private WebElement newstab;

	public void searchTeam(String shortname, String fullname) throws Exception {
		searchbar.click();
		search.sendKeys(shortname);
		// scans for team in search results
		for (WebElement team : teamname) {
			if (team.getText().equals(fullname)) {
				team.click();
				break;
			} else {
				throw new Exception("No team found...");
			}
		}
		Assert.assertEquals(teampagename.getText(), fullname); // checks searched team is correct
	}
	
	public void checkTeamStatsTab(String fullname) {
		teamstatstab.click();
		Assert.assertEquals(teamstatstab.getAttribute("selected"), "true"); // verify tab is selected
		Assert.assertEquals(teamstatstabtext.getText(), "TEAM STATS"); // verify tab text is correct
		Assert.assertEquals(teampagename.getText(), fullname); // checks selected team is correct after tapping on subtab
	}

	public void checkTeamStats() throws Exception {
		// check offense/defense header text
		Assert.assertEquals(headertext.get(0).getText(), "OFFENSE STATS"); // checks selected team is correct
		Assert.assertEquals(ranktext.get(0).getText(), "(RANK)"); // checks selected team is correct
		Assert.assertEquals(headertext.get(1).getText(), "DEFENSE STATS"); // checks selected team is correct
		Assert.assertEquals(ranktext.get(1).getText(), "(RANK)"); // checks selected team is correct
		scrolltoEndAction(); // scroll down to display entire page
		// check stats category text
		for (int i = 0; i < categoryname.size(); i++) {
			if (categoryname.get(i).getText().equals("Total Yards")) {
				System.out.println("Text displayed: " + categoryname.get(i).getText());
			} else if (categoryname.get(i).getText().equals("Passing Yards")) {
				System.out.println("Text displayed: " + categoryname.get(i).getText());
			} else if (categoryname.get(i).getText().equals("Rushing Yards")) {
				System.out.println("Text displayed: " + categoryname.get(i).getText());
			} else if (categoryname.get(i).getText().equals("Points")) {
				System.out.println("Text displayed: " + categoryname.get(i).getText());
			} else if (categoryname.get(i).getText().equals("3rd Down %")) {
				System.out.println("Text displayed: " + categoryname.get(i).getText());
			} else {
				throw new Exception("Missing a stats category");
			}
		}

		// check stats category value
		for (int i = 0; i < category_value.size(); i++) {
			category_value.get(i).isDisplayed();
		}

		// check teamranking text
		for (int i = 0; i < teamranking.size(); i++) {
			teamranking.get(i).isDisplayed();
		}

		// check blue progress
		for (int i = 0; i < progressbar.size(); i++) {
			progressbar.get(i).isDisplayed();
		}

		// check remaining progress bar
		for (int i = 0; i < progressbar_inverse.size(); i++) {
			progressbar_inverse.get(i).isDisplayed();
		}
	}
	
	public void checkPreviousPage() {
		backarrow.click();
		search.isDisplayed();
		alltab.isDisplayed();
		teamstab.isDisplayed();
		playerstab.isDisplayed();
		newstab.isDisplayed();
	}
}