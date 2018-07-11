package Pages;

import org.openqa.selenium.By;
import Utils.WrapperForGenericMethods;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutPage {

	By Binbutton = By.id("com.ebay.mobile:id/button_bin");
	By ReviewButton = By.id("com.ebay.mobile:id/take_action");
	By TvNameEle = By.xpath("//android.view.View[@content-desc='SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY']");
	By TvPriceEle = By.xpath("//android.view.View[@content-desc='Rs. 120,000.00']");
	String TVName = "SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY";

	@SuppressWarnings("rawtypes")
	public void ToCheckout(AndroidDriver driver) {

		WrapperForGenericMethods Action = new WrapperForGenericMethods();
		Action.Click(driver, Binbutton);
		Action.Click(driver, ReviewButton);
		Action.ScrollTo(driver, TVName);

	}

	@SuppressWarnings("rawtypes")
	public String GetTvDescriptionCheckout(AndroidDriver driver) throws Exception {

		WrapperForGenericMethods Action = new WrapperForGenericMethods();
		String tvDescritpionCO = Action.NoAction(driver, TvNameEle);

		return tvDescritpionCO;

	}

	@SuppressWarnings("rawtypes")
	public String GetTvPriceCheckout(AndroidDriver driver) throws Exception {
		
		WrapperForGenericMethods Action = new WrapperForGenericMethods();
		String tvPriceCO = Action.NoAction(driver, TvPriceEle);

		return tvPriceCO;

	}

}