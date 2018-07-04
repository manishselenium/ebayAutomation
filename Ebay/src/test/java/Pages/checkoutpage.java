package Pages;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class checkoutpage {

	By Binbutton = By.id("com.ebay.mobile:id/button_bin");
	By ReviewButton = By.id("com.ebay.mobile:id/take_action");
	By TvNameEle = By.xpath(
			"//android.view.View[@content-desc='SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY']");
	By TvPriceEle = By.xpath("//android.view.View[@content-desc='Rs. 120,000.00']");

	String TVName = "SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY";

	@SuppressWarnings("rawtypes")
	public void toCheckout(AndroidDriver driver) {

		driver.findElement(Binbutton).click();
		driver.findElement(ReviewButton).click();
		driver.scrollToExact(TVName);

	}

	@SuppressWarnings("rawtypes")
	public String getTvDescriptionCheckout(AndroidDriver driver) throws Exception {

		MobileElement TvNameVar = (MobileElement) driver.findElement(TvNameEle);
		String tvDescritpionCO = TvNameVar.getAttribute("name");

		return tvDescritpionCO;

	}

	@SuppressWarnings("rawtypes")
	public String getTvPriceCheckout(AndroidDriver driver) throws Exception {

		MobileElement TvPriceVar = (MobileElement) driver.findElement(TvPriceEle);
		String tvPriceCO = TvPriceVar.getAttribute("name");

		return tvPriceCO;

	}

}