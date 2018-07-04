package testSuit;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.checkoutpage;
import Pages.homePage;
import Pages.searchPage;
import Pages.signInPage;
import Utils.excelUtils1;
import io.appium.java_client.android.AndroidDriver;

public class testCasesTest extends signInPage {

	@SuppressWarnings("rawtypes")
	AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	@BeforeTest
	public void setup() throws Exception {
		File appDir = new File("/home/owner/Downloads");
		File app = new File(appDir, "eBay.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "192.168.56.101:5555");
		capabilities.setCapability(CapabilityType.VERSION, "7.1");
		capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		capabilities.setCapability("platformVersion", "7.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app-package", "com.ebay.mobile");
		capabilities.setCapability("app-activity", "com.ebay.mobile.activities.MainActivity");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	// This test case is use to do login in the Application
	@Test(priority = 1)
	public void Login() throws Exception {

		signInPage dosignIn = new signInPage();
		dosignIn.loginAction(driver);

	}

	// This test case is use to do search tv.
	@Test(priority = 2)
	public void SearchTV() throws Exception {

		homePage searchItem = new homePage();
		searchItem.HomeAction(driver);
	}

	// This test case is use to validate the Name and description on the search screen.
	@Test(priority = 3)
	public void NameAndDiscriptionComparison_OnSearchScreen() throws Exception {

		String GetDesc = excelUtils1.getCellData(14, 0);

		searchPage TVdesc = new searchPage();

		Assert.assertEquals(GetDesc, TVdesc.getTVDescription(driver));

	}

	// This test case is use to validate the price of tv on Search screen.
	@Test(priority = 4)
	public void PriceComparison_OnSearchScreen() throws Exception {

		searchPage TVdesc = new searchPage();

		Assert.assertEquals("₹120,000", TVdesc.getPriceDetails(driver));

	}

	// This test case is use to move product to checkout page.
	@Test(priority = 5)
	public void MoveToCheckout() {

		checkoutpage checkObj = new checkoutpage();
		checkObj.toCheckout(driver);

	}

	// This test case is use to validate Name and description of tv on the checkout screen.
	@Test(priority = 6)
	public void NameAndDiscriptionComparison_CheckOutScreen() throws Exception

	{
		checkoutpage checkObj = new checkoutpage();

		String TVdescCO = excelUtils1.getCellData(17, 0);
		Assert.assertEquals(TVdescCO, checkObj.getTvDescriptionCheckout(driver));
	}

	// This test case is use to validate Price of tv on the checkout screen.
	@Test(priority = 7)
	public void PriceComparison_CheckOutScreen() throws Exception

	{
		checkoutpage checkObj = new checkoutpage();

		String GetPriceCO = excelUtils1.getCellData(17, 1);
		Assert.assertEquals(GetPriceCO, checkObj.getTvPriceCheckout(driver));
	}

	// This test case is use to compare tv Name and description between search screen and checkout screen.
	@Test(priority = 8)
	public void compareTvDescription_to_CheckoutScreen() throws Exception

	{
		String GetDescstr = excelUtils1.getCellData(14, 0);

		checkoutpage checkObj = new checkoutpage();

		Assert.assertEquals(GetDescstr, checkObj.getTvDescriptionCheckout(driver));

	}

}
