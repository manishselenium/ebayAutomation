package Pages;

import org.openqa.selenium.By;
import Utils.ExcelUtils1;
import Utils.WrapperForGenericMethods;
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
		WrapperForGenericMethods Action = new WrapperForGenericMethods();
		Action.Click(driver, user);
		Action.Sendkeys(driver, Email, Username);
		Action.Sendkeys(driver, password, Password);
		Action.Click(driver, signInButton);
		Action.Click(driver, linkAccount);
		

	}
}