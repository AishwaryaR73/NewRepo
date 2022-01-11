package seleniumGridExamples;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMSeleniumGridChrome  {
	WebDriver driver;
	

	@BeforeTest
	public void openBrowser() throws IOException {
		String nodeURL = "http://10.1.10.101:7716/wd/hub";
		//Remote machine
		DesiredCapabilities cap = new DesiredCapabilities().chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		WebDriverManager.chromedriver().setup();
		driver = new RemoteWebDriver(new URL(nodeURL), cap);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void openTest() throws InterruptedException {
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(4000);
		driver.findElement(By.id("btnLogin")).click();

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
