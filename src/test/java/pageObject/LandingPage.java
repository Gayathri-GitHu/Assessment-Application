package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement loginEmail;

	@FindBy(xpath = "//a[@class='login'])")
	private WebElement loginButton;
	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement mailidinput;
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	private WebElement submitForRegistration;

	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement loginpassword;
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	private WebElement loginSubmit;

	public void clickonSubmit() {
		loginSubmit.click();
	}

	public void clickonLogin() {
		loginButton.click();
	}

	public void loginEmailClick(String email) {
		loginEmail.sendKeys(email);
	}

	public void loginPasswordClick(String password) {
		loginpassword.sendKeys(password);
	}

	public void submitForRegistration() {
		submitForRegistration.click();
	}

	public void mailIdInput(String mailId) {
		mailidinput.sendKeys(mailId);
	}

}
