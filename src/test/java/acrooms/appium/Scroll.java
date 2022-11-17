package acrooms.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Scroll extends BaseTest {

	@Test
	public void ScrollGesture() throws MalformedURLException, InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		// Scrolling when you use Andoid Ui Automator, that you arerelying on Google
		// engine script
		// Create an object for a class UI Scrollable
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		Thread.sleep(2000);
		// No prior data, slower
		/*boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);*/
	}

}
