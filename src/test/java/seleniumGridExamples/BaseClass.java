package seleniumGridExamples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;

	@BeforeTest
	@Parameters("browsers")

	public void openBrowserss(String browsers) throws MalformedURLException {
		if (browsers.equalsIgnoreCase("chrome")) {
			String nodeURL = "http://10.1.10.101:7716/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			WebDriverManager.chromedriver().setup();
			driver = new RemoteWebDriver(new URL(nodeURL), cap);
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
		} else if (browsers.equalsIgnoreCase("firefox")) {
			String nodeURL = "http://10.1.10.101:7719/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities().firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			WebDriverManager.chromedriver().setup();
			driver = new RemoteWebDriver(new URL(nodeURL), cap);

//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
	}

}
