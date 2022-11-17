package acrooms.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;
public class AppiumBasic extends BaseTest{
	
	@Test
	public void AppiumTesting() throws MalformedURLException {
		
		//xpath, id, accessibility, classname, androidAutomator
		
		
		//tagName[@attribute='value'] -> //tagName
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		//driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.xpath("//hierarchy//android.widget.FrameLayout//android.view.ViewGroup//android.widget.FrameLayout[2]//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.ListView//android.widget.LinearLayout[2]//android.widget.RelativeLayout")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Benita");
		driver.findElement(By.id("android:id/button1")).click();

		//tearDown();
		
		//Actual code
		
	}
	

}
