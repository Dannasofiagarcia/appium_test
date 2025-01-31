package mobile_testing;

import org.testng.ITestResult;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.ScreenshotUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

	protected static AndroidDriver driver;
	@BeforeClass
	public void setup() throws MalformedURLException {
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 9 Pro API 35");
		options.setApp("//Users//dannagarcia.//eclipse-workspace//Appium//src//test//java//resources//Android-MyDemoAppRN.1.3.0.build-244.apk");
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
	
	@AfterClass
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}


}
