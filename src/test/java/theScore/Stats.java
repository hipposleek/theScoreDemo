package theScore;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import theScore.pageObjects.android.Onboarding;
import theScore.pageObjects.android.TeamStats;

public class Stats extends BaseTest {

	@Test(dataProvider = "getData")
	public void testTeamStats(String shortname, String fullname) throws Exception {
		Onboarding onboarding = new Onboarding(driver);
		TeamStats teamstats = new TeamStats(driver);

		onboarding.onboardingFlow();
		teamstats.searchTeam(shortname, fullname);
		teamstats.checkTeamStatsTab(fullname);
		teamstats.checkTeamStats();
		teamstats.checkPreviousPage();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "49ers", "San Francisco 49ers" } }; // object will accept any data type
	}
}