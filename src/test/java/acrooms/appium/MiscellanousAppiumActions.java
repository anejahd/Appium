package acrooms.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;
public class MiscellanousAppiumActions extends BaseTest{
	
	@Test
	public void MiscellanousTesting() throws MalformedURLException {
		
		//App Package & App Activity
		//abd shell dumpsys window | grep -E 'mCurrentFocus' - Mac
		//abd shell dumpsys window | find -E 'mCurrentFocus' - Windows
		//package, activity name
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		/*driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();*/
		driver.findElement(By.id("android:id/checkbox")).click();
		//turn the phone
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		//driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.xpath("//hierarchy//android.widget.FrameLayout//android.view.ViewGroup//android.widget.FrameLayout[2]//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.LinearLayout//android.widget.ListView//android.widget.LinearLayout[2]//android.widget.RelativeLayout")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(alertTitle);
		Assert.assertEquals(alertTitle, "WiFi settings");
		//copy paste
		//copy to clipboard - paste it clipboard
		driver.setClipboardText("Benita");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		//driver.findElement(By.id("android:id/edit")).sendKeys("Benita");
		driver.findElement(By.id("android:id/button1")).click();
		//click back
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//click HOME
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		System.out.println("Done");

		//tearDown();
		
		//Actual code
		
	}
	

}
