package acrooms.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		//code to start the server
		
				//Andriod Driver IOSDriver
				//appium code - appium server - mobile
				//open the driver
		service =  new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("10.0.0.196").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Phone1");
		options.setApp("//Users//anejahcrooms//node_modules//android-apidemos//apks//ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URL("http://10.0.0.196:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
	}	
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(), "duration", 2000
			));
	}
	
	public void ScrollView() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
	}
	
	public void SwipeAction(WebElement ele, String directon) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)ele).getId(), "duration", 2000,
			    "direction", "left",
			    "percent", 0.75
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	

}
