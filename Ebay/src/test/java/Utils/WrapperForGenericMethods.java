package Utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;

public class WrapperForGenericMethods {

	public void Click(AndroidDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(by).click();
	}

	public void Sendkeys(AndroidDriver driver, By by, String key) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(by).sendKeys(key);
	}

	public String NoAction(AndroidDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String Obj = driver.findElement(by).getAttribute("name");

		return Obj;

	}

	public String GetText(AndroidDriver driver, By by) {

		String Text = driver.findElement(by).getText();

		return Text;
	}

	public void ScrollTo(AndroidDriver driver, String str) {

		driver.scrollToExact(str);
	}

}
