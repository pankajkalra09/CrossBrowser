package BrowserStack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrossBrowserClass {

	public WebDriver driver;
	//official documentation at "github.com/browserstack/testng-browserstack/sdk"
		//Since we want to run our test on cloud so instead of creating an reference variable of chromeWebDriver class we make use of RemoteWebDriver.
		//remoteWebDriver takes 2 arguments (1st is where we are sending our test case request. 2nd is capabilities means which browser/version/OS etc).
		//as 1st argument, we need to give URL of the BrowserStack and for 2nd we can define all the capabilities in a yml file at project level.
		//copy the yml details from the browserstack documentation "https://automate.browserstack.com/dashboard/v2/quick-start/get-started".
		//Only we create the .yml file now we must include all these details in capability object.
		
	@Test
	public void browserStack() throws MalformedURLException {
		MutableCapabilities caps = new MutableCapabilities();
		//we have to make a way so that our caps object knows what is written in .yml file.
		//browserstack team has created a jar for us and that jar/dependency automatically reads the data from our .yml file, creates hashmaps from it and then push all the content to caps object.
		//include that dependency in pom.xml and we are done.
		//integrate testng with maven by including in pom.xml everything is in documentation.
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
		driver.get("https://www.google.com");
		Assert.assertTrue(driver.getTitle().matches("Google"));
		
		
	}
}
