package TestSuit;

import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.SearchPage;
import Pages.SignInPage;
import Utils.ReadPropertieFile;
import Utils.ExcelUtils1;
import io.appium.java_client.android.AndroidDriver;

public class TestCasesTest extends SignInPage {

	@SuppressWarnings("rawtypes")
	AndroidDriver driver;

	static Properties properties = null;

	@SuppressWarnings("rawtypes")
	@BeforeTest
	public void setup() throws Exception {

		ReadPropertieFile readConfigFile = new ReadPropertieFile();

		properties = readConfigFile.LoadPropertiess();

		File appDir = new File(properties.getProperty("FilePath"));
		File app = new File(appDir, properties.getProperty("AppDir"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
		capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
		capabilities.setCapability("app-package", properties.getProperty("app-package"));
		capabilities.setCapability("app-activity", properties.getProperty("app-activity"));
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL(properties.getProperty("URL")), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	// This test case is use to do login in the Application
	@Test(priority = 1)
	public void Login() throws Exception {

		SignInPage dosignIn = new SignInPage();
		dosignIn.LoginAction(driver);

	}

	// This test case is use to do search tv.
	@Test(priority = 2)
	public void SearchTV() throws Exception {

		HomePage searchItem = new HomePage();
		searchItem.HomeAction(driver);
	}

	// This test case is use to validate the Name and description on the search
	// screen.
	@Test(priority = 3)
	public void NameAndDiscriptionComparison_OnSearchScreen() throws Exception {

		String GetDesc = ExcelUtils1.GetCellData(14, 0);

		SearchPage TVdesc = new SearchPage();

		Assert.assertEquals(GetDesc, TVdesc.GetTVDescription(driver));

		System.out.println("Name and Description on Search screen are validated successfully.");
	}

	// This test case is use to validate the price of tv on Search screen.
	@Test(priority = 4)
	public void PriceComparison_OnSearchScreen() throws Exception {

		SearchPage TVdesc = new SearchPage();
		
		String GetDesc = ExcelUtils1.GetCellData(14, 1);

	    Assert.assertEquals(GetDesc, TVdesc.GetPriceDetails(driver));
		
		System.out.println("Price on Search screen is validated successfully.");

	}

	// This test case is use to move product to checkout page.
	@Test(priority = 5)
	public void MoveToCheckout() {

		CheckoutPage checkObj = new CheckoutPage();
		checkObj.ToCheckout(driver);

	}

	// This test case is use to validate Name and description of tv on the checkout screen.
	@Test(priority = 6)
	public void NameAndDiscriptionComparison_CheckOutScreen() throws Exception

	{
		CheckoutPage checkObj = new CheckoutPage();

		String TVdescCO = ExcelUtils1.GetCellData(17, 0);
		Assert.assertEquals(TVdescCO, checkObj.GetTvDescriptionCheckout(driver));
		
		System.out.println("Name and Description on Checkout screen are validated successfully.");
	}

	// This test case is use to validate Price of tv on the checkout screen.
	@Test(priority = 7)
	public void PriceComparison_CheckOutScreen() throws Exception

	{
		CheckoutPage checkObj = new CheckoutPage();

		String GetPriceCO = ExcelUtils1.GetCellData(17, 1);
		Assert.assertEquals(GetPriceCO, checkObj.GetTvPriceCheckout(driver));
		
		System.out.println("Price on Checkout screen is validated successfully.");
	}

	// This test case is use to compare tv Name and description between search screen and checkout screen.
	@Test(priority = 8)
	public void compareTvDescription_to_CheckoutScreen() throws Exception

	{
		String GetDescstr = ExcelUtils1.GetCellData(14, 0);

		CheckoutPage checkObj = new CheckoutPage();

		Assert.assertEquals(GetDescstr, checkObj.GetTvDescriptionCheckout(driver));
		
		System.out.println("Comparision of Description on Search screen and check out screen done successfully.");

	}

}
