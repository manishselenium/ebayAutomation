package Pages;

import org.openqa.selenium.By;

import Utils.excelUtils1;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class homePage {

	By SearchBox = By.xpath("//*[@text='Search for anything']");
	By result = By.xpath("//*[@text='65 inch tv\n" + "LED Televisions']");
	String TVDescrStr = "SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY";

	@SuppressWarnings("rawtypes")
	public void HomeAction(AndroidDriver driver) throws Exception {

		String Serachkey = excelUtils1.getCellData(9, 0);

		driver.findElement(SearchBox).sendKeys(Serachkey);
		Thread.sleep(2000);
		driver.findElement(result).click();
		Thread.sleep(5000);
		TouchAction SwipAction_list = new TouchAction((AndroidDriver) driver);
		SwipAction_list.longPress(327, 1158).moveTo(327, 189).release().perform();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@text='SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY']"))
				.click();
		Thread.sleep(3000);
		TouchAction SwipAction_Buy = new TouchAction((AndroidDriver) driver);
		SwipAction_Buy.longPress(373, 615).moveTo(373, 232).release().perform();

	}

}
