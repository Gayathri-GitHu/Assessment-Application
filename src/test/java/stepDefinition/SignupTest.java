package stepDefinition;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import base.BaseClass;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.AccountCreation;
import pageObject.LandingPage;
import pageObject.HomePage;

public class SignupTest extends BaseClass {
	WebDriver driver;
	AccountCreation ac;
	Actions act;
	LandingPage lp;
	HomePage hp;

	public SignupTest() throws IOException {
		super();
		ac = new AccountCreation(driver);
		lp = new LandingPage(driver);
		act = new Actions(driver);
		hp = new HomePage(driver);
	}

	@Given("^User launches the application$")
	public void user_launches_the_application() throws Throwable {
		driver.get(props.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("User navigates to the registration page {string}")
	public void user_navigates_to_the_registration_page(String email) {
		lp.clickonLogin();
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		lp.mailIdInput(email);
		lp.submitForRegistration();
		throw new PendingException();
	}

	@And("User enters the required information in Your Personal Information section {string},{string},{string},{string},{string},{string}")
	public void user_enters_the_required_information_in_your_personal_information_section(String firstname,
			String lastName, String password, String day, String month, String year) {
		ac.submitForRegistration();
		ac.enterFirstName(firstname);
		ac.enterLastName(lastName);
		ac.enterPassword(password);
		ac.daySelect(day);
		ac.monthSelect(month);
		ac.yearSelect(year);

		throw new PendingException();
	}

	@When("User enters the required information in Your Address section {string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_enters_the_required_information_in_your_address_section(String company, String address1,
			String address2, String city, String state, String postalcode, String addinfo, String mobile, String ref) {
		ac.enterCompany(company);
		ac.enterAddress1(address1);
		ac.enterAddress2(address2);
		ac.enterCity(city);
		ac.selectState(state);

		ac.enterPostalCode(postalcode);
		ac.countrySelect();

		ac.enteradditionalinfo(addinfo);
		ac.entermobile(mobile);
		ac.enterref(ref);

		throw new io.cucumber.java.PendingException();
	}

	@When("^User Registers the account$")
	public void user_Registers_the_account() throws Throwable {
		ac.register();
		throw new PendingException();
	}

	@Then("User validates the Account name in the landing page {string},{string}")
	public void user_validates_the_account_name_in_the_landing_page(String firstname, String lastname) {
		Assert.assertEquals(hp.getAccountName(), firstname + " " + lastname);
		throw new io.cucumber.java.PendingException();
	}

	@Then("^User Logout from the application$")
	public void user_Logout_from_the_application() throws Throwable {
		hp.clickLogout();
		throw new PendingException();
	}

	@Given("User Login to the application {string},{string}")
	public void user_login_to_the_application(String email, String password) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Actions act1 = new Actions(driver);
		act1.sendKeys(Keys.PAGE_DOWN).build().perform();
		lp.loginEmailClick(email);
		lp.loginPasswordClick(password);
		lp.clickonSubmit();
		throw new io.cucumber.java.PendingException();
	}

	@Then("User search a product {string}")
	public void user_search_a_product(String searchSendText) {
		hp.searchsendText(searchSendText);
		hp.clicksearchSubmit();
		throw new PendingException();

	}

@When("User adds the product to the cart {string}")
	public void user_adds_the_product_to_the_cart(String product) throws Throwable {
		hp.clickOnSearchedProduct(product);

		throw new PendingException();
	}

	@Then("User proceed to the payments {string}")
	public void user_proceed_to_the_payments(String product) {
		Set<String> set = driver.getWindowHandles();
		// to get the value from set object, we will use iterator
		Iterator<String> it = set.iterator();
		it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		Assert.assertEquals(hp.getproductText(product), product);
		hp.proceedtoCheckoutClick();
		
		hp.proceedtocheckoutActions();
		hp.proceedtocheckoutActions();
		hp.checkoutclick();
	    throw new io.cucumber.java.PendingException();
	}

	@Then("^User validates the detail$")
	public void user_validates_the_detail() throws Throwable {
		Actions act = new Actions(driver);
		Action a = act.moveToElement(driver.findElement(By.xpath("//button[@name='processCarrier']")))
				.keyDown(Keys.ENTER).release().build();
		a.perform();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='product-name']")).getText(),
				"Faded Short Sleeve T-shirts");
		Assert.assertEquals(driver.findElement(By.xpath("//span[starts-with(@id,'total_product_price')]")), "$18.5");

		throw new PendingException();
	}

}
