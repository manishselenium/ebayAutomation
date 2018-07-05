package Pages;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchPage {
	By itemDisc = By.id("com.ebay.mobile:id/textview_item_name");
	By itemPriceEle = By.id("com.ebay.mobile:id/textview_item_price");

	@SuppressWarnings("rawtypes")
	public String GetTVDescription(AndroidDriver driver) throws Exception {

		MobileElement itemName = (MobileElement) driver.findElement(itemDisc);
		String tvDesc = itemName.getText();

		return tvDesc;

	}

	@SuppressWarnings("rawtypes")
	public String GetPriceDetails(AndroidDriver driver) {

		MobileElement itemPrice = (MobileElement) driver.findElement(itemPriceEle);
		String tvPrice = itemPrice.getText();

		return tvPrice;

	}

}
