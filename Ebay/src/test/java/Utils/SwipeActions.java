package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class SwipeActions {

	//AndroidDriver driver;
	Dimension size;

	public void SwipingVerticalOnTvList(AndroidDriver driver, By by1,By by2) {

	    MobileElement start = (MobileElement) driver.findElement(by1);
		MobileElement stop = (MobileElement) driver.findElement(by2);
		TouchAction action = new TouchAction(driver);
		action.longPress(start).moveTo(stop).release().perform();
		
	}
	
	public void SwipingVerticalOnTvDetails(AndroidDriver driver, By by1,By by2) {

	    MobileElement start = (MobileElement) driver.findElement(by1);
		MobileElement stop = (MobileElement) driver.findElement(by2);
		TouchAction action = new TouchAction(driver);
		action.longPress(start).moveTo(stop).release().perform();
		
	}

}
