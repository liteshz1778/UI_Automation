package Utililies;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.pages.BaseTest;

public class screenShotProgram extends BaseTest {

	public void takeSS(String imageName) {
		try {
			TakesScreenshot tsc = (TakesScreenshot) driver;

			File source = tsc.getScreenshotAs(OutputType.FILE);

			File f = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + imageName + ".png");

			FileHandler.copy(source, f);
			System.out.println("ScreenShot Taken");
		} catch (Exception e) {
			System.out.println("ScreenShot Exceptions are\n" + e);
		}
	}
}