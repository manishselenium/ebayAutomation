package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Utils.ExcelUtils1;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	By SearchBox = By.xpath("//*[@text='Search for anything']");
	By result = By.xpath("//*[@text='65 inch tv\n" + "LED Televisions']");
	By SearchFirstElement = By.id("com.ebay.mobile:id/textview_item_title");
	By SearchSecondElement = By.id("com.ebay.mobile:id/button_bin"); 
	String TVDescrStr = "65 inch 4K UHD ANDROID SMART SAMSUNG PANEL 8GB LED TV +REPLACEMENT WARRANTY";

	@SuppressWarnings("rawtypes")
	public void HomeAction(AndroidDriver driver) throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String Serachkey = ExcelUtils1.GetCellData(9, 0);
		driver.findElement(SearchBox).sendKeys(Serachkey);
		driver.findElement(result).click();
		driver.findElement(SearchFirstElement);
		TouchAction SwipAction_list = new TouchAction((AndroidDriver) driver);
		SwipAction_list.longPress(327, 1158).moveTo(327, 189).release().perform();
		driver.findElement(By.xpath("//*[@text='SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY']")).click();
		driver.findElement(SearchSecondElement);
		TouchAction SwipAction_Buy = new TouchAction((AndroidDriver) driver);
		SwipAction_Buy.longPress(373, 615).moveTo(373, 232).release().perform();

	}

}
