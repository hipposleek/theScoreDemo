## Test Environment
- **Java Version**: 11 (11.0.23)
- **Appium Version**: 2 (2.5.4)
- **Android App Version**: 24.8.0

## Test Execution
1. Ensure Maven is installed on local machine
2. Clone this repository from the `develop` branch
3. The IP address and port number is defaulted at: 127.0.0.1:4723 for the Appium server. If needed, please update the IP address and port number of the Appium server on your local machine in the `data.properties` file ( **src/main/java/theScore/resources**). The AndroidDeviceName can be left as is.
4. Launch Terminal and proceed to the `theScoreDemo` folder and type: `mvn test -PAndroidTest`

## Test Requirements
Write an automated test that finds a league, team, or player within theScore app and verify the specified steps. Assume the project you create will be the foundation for an automation suite, so please build appropriate abstractions as necessary.

Automate the following steps
1. Open a league, team, or player page of your choice (bonus points for using a data-driven or parameterized approach).
2. Verify that the expected page opens correctly.
3. Tap on a sub-tab of your choice, e.g., league table / standings / leaders, or stats tab of the league, team, or player.
4. Verify that you are on the correct tab and that the data is displayed correctly and corresponds to the league, team, or player from step 1.
5. Verify that back navigation returns you to the previous page correctly.

## Testing Design and Verification
I'm using Maven and TestNG to help with the project management and testing needs. In addition, I've incorporated Page Objects for reusability and allowing easier maintenance of elements if needed. Currently, the testing is done on Android but I've kept the framework structure so that IOS testing can be incorporated as well.

For the testing requirement, I've chosen the San Francisco 49ers as my team of choice and to test the team stats. For verification of expected results, an example for step 2 is that I made a check on the team name element in the team page that it actually displays the "San Francisco 49ers". In addition, another example for step 4 on verifying that the correct tab is displayed is making a check on the element attribute "selected" and making sure that it is set to "true". Finally, I've also included a sample test report for this test run. The report file can be found in the repository under: **reports/index.html** and also [here](https://drive.google.com/file/d/1fjnjIaPNkVYs1_L96bNF5OTI86noS9Ti/view?usp=sharing) as well.
