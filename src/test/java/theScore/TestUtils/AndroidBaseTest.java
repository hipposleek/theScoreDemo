package theScore.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import theScore.utils.AppiumUtils;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//theScore//resources//data.properties");
		prop.load(file);
		
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		System.out.println(ipAddress);
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setApp(System.getProperty("user.dir") + "//src//test//java//theScore//apps//theScore_24.8.0.apk");		

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}