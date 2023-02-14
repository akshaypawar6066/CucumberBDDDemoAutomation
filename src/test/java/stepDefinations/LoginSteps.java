package stepDefinations;

import org.junit.Assert;
import org.junit.runner.RunWith;
import io.cucumber.*;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

@RunWith(Cucumber.class)
public class LoginSteps {
	WebDriver driver;

	@Given("^user is on login page$")
	public void user_is_on_login_page() {

		// System.out.println("User is on login page");
		String projecrPth = System.getProperty("user.dir");
		System.out.println("Project base path is:" + projecrPth);
		System.setProperty("webdriver.chrome.driver", projecrPth + "//src//test//resources//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_something_and_something(String strArg1, String strArg2) throws Throwable {
		Thread.sleep(6000);
		driver.findElement(By.name("username")).sendKeys(strArg1);
		driver.findElement(By.name("password")).sendKeys(strArg2);

	}

	@And("^clicks on login button$")
	public void clicks_on_login_button() {
		// System.out.println("Hits login button");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^verify user is landed on home page")
	public void verify_user_is_landed_on_home_page() {
		// System.out.println("user navigated to home page");
		boolean b = driver.getPageSource().contains("PIM");
		Assert.assertTrue(b);
		driver.close();
	}

}
