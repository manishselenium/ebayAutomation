package Pages;

import org.openqa.selenium.By;
import Utils.ExcelUtils1;
import io.appium.java_client.android.AndroidDriver;

public class SignInPage {

	By user = By.id("com.ebay.mobile:id/button_sign_in");
	By Email = By.xpath("//*[@text='Email or username']");
	By password = By.xpath("//*[@text='Password']");
	By signInButton = By.xpath("//*[@text='SIGN IN']");
	By linkAccount = By.xpath("//*[@text='NO THANKS']");

	ExcelUtils1 hello12 = new ExcelUtils1();


	public void LoginAction(AndroidDriver driver) throws Exception {

		String Username = ExcelUtils1.GetCellData(3, 0);
		String Password = ExcelUtils1.GetCellData(3, 1);
		driver.findElement(user).click();
		driver.findElement(Email).sendKeys(Username);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(signInButton).click();
		driver.findElement(linkAccount).click();

	}
}