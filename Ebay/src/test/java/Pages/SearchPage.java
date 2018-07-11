package Pages;

import org.openqa.selenium.By;

import Utils.WrapperForGenericMethods;

import io.appium.java_client.android.AndroidDriver;

public class SearchPage {
	By itemDisc = By.id("com.ebay.mobile:id/textview_item_name");
	By itemPriceEle = By.id("com.ebay.mobile:id/textview_item_price");

	@SuppressWarnings("rawtypes")
	public String GetTVDescription(AndroidDriver driver) throws Exception {

		WrapperForGenericMethods Action = new WrapperForGenericMethods();
		String tvDesc = Action.GetText(driver, itemDisc);

		return tvDesc;

	}

	@SuppressWarnings("rawtypes")
	public String GetPriceDetails(AndroidDriver driver) {

		WrapperForGenericMethods Action = new WrapperForGenericMethods();
		String tvPrice = Action.GetText(driver, itemPriceEle);

		return tvPrice;

	}

}
