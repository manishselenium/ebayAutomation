package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Utils.ExcelUtils1;
import Utils.SwipeActions;
import Utils.WrapperForGenericMethods;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	By SearchBox = By.xpath("//*[@text='Search for anything']");
	By result = By.xpath("//*[@text='65 inch tv\n" + "LED Televisions']");
	By SearchFirstElement = By.id("com.ebay.mobile:id/textview_item_title");
	By SearchSecondElement = By.id("com.ebay.mobile:id/button_bin");
	By ElementWait = By.xpath("//*[@text='SAMSUNG 65 INCHES 65MU6100 4K UHD LED TV 2017 MODEL + 1 YEAR DEALERS WARRANTY']");
	By StartElementList = By.xpath("//*[@text='₹69,990']");
	By EndElementList = By.id("com.ebay.mobile:id/menu_search");
	By StartElementDe = By.id("com.ebay.mobile:id/about_this_item_title");
	By EndElementDe = By.id("com.ebay.mobile:id/button_bin");
	
	String TVDescrStr = "65 inch 4K UHD ANDROID SMART SAMSUNG PANEL 8GB LED TV +REPLACEMENT WARRANTY";
	
	
	

	@SuppressWarnings("rawtypes")
	public void HomeAction(AndroidDriver driver) throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String Serachkey = ExcelUtils1.GetCellData(9, 0);
        WrapperForGenericMethods Action = new WrapperForGenericMethods();
        SwipeActions SwipAction_list = new SwipeActions();
        Action.Sendkeys(driver, SearchBox, Serachkey);
		Action.Click(driver, result);
		Action.NoAction(driver, SearchFirstElement);
		SwipAction_list.SwipingVerticalOnTvList(driver, StartElementList, EndElementList);
		Action.Click(driver, ElementWait);
		Action.NoAction(driver, SearchSecondElement);
		SwipAction_list.SwipingVerticalOnTvDetails(driver, StartElementDe, EndElementDe);
		

	}

}
