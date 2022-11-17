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

public class LongPress extends BaseTest{

	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//appium github gestures
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		/*((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementID",((RemoteWebElement)peopleName).getId(),
				"duration", 2000));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(), "duration", 2000
			));*/
		longPressAction(ele);
		//Thread.sleep(2000);
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		System.out.println(menuText);
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}
}
