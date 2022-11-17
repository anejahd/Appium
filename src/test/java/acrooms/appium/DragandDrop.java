package acrooms.appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragandDrop extends BaseTest {

	@Test
	public void ScrollGesture() throws MalformedURLException, InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)source).getId(),
			    "endX", 831,
			    "endY", 801
			));
		Thread.sleep(2000);
		String results = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(results, "Dropped!");
	}

}
