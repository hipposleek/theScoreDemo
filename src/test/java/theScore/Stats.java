package theScore;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import theScore.TestUtils.AndroidBaseTest;
import theScore.pageObjects.android.TeamStats;

public class Stats extends AndroidBaseTest {

	@Test(dataProvider = "getData")
	public void testTeamStats(String shortname, String fullname) throws Exception {
		onboarding.onboardingFlow();
		TeamStats teamstats = new TeamStats(driver);
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