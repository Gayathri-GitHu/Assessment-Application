package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreation {
	WebDriver driver;

	public AccountCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='id_gender' and @value='1']")
	private WebElement submitregistration;
	@FindBy(xpath = "//div[@class='required form-group'][1])")
	private WebElement firstName;
	@FindBy(xpath = "//div[@class='required form-group']//child::label[contains(text(),'Last name ')]")
	private WebElement lastName;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passWord;

	@FindBy(id = "days")
	private WebElement day;
	@FindBy(id = "months")
	private WebElement month;
	@FindBy(id = "years")
	private WebElement year;

	@FindBy(xpath = "//input[@id='company']")
	private WebElement company;
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement address1;
	@FindBy(xpath = "//input[@id='address2']")
	private WebElement address2;
	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;
	@FindBy(xpath = "id_state")
	private WebElement state;
	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement postalcode;

	@FindBy(xpath = "id_country")
	private WebElement country;
	@FindBy(xpath = "//input[@id='other']")
	private WebElement additionalinfo;
	@FindBy(xpath = "//input[@id='phone_mobile']")
	private WebElement mobile;
	@FindBy(xpath = "//button[@id='submitAccount']")
	private WebElement registerSubmit;

	@FindBy(xpath = "//input[@id='alias']")
	private WebElement ref;

	public void enterref(String reference) {
		ref.sendKeys(reference);
	}

	public void register() {
		registerSubmit.click();
	}

	public void entermobile(String mobilephone) {
		mobile.sendKeys(mobilephone);
	}

	public void countrySelect() {
		Select s = new Select(country);
		s.selectByValue("21");
	}

	public void enteradditionalinfo(String additionalinformation) {
		additionalinfo.sendKeys(additionalinformation);
	}

	public void enterPostalCode(String postal) {
		postalcode.sendKeys(postal);
	}

	public void enterCompany(String companyText) {
		company.sendKeys(companyText);
	}

	public void enterAddress1(String address1Text) {
		address1.sendKeys(address1Text);
	}

	public void enterAddress2(String address2Text) {
		address2.sendKeys(address2Text);
	}

	public void enterPassword(String password) {
		passWord.sendKeys(password);
	}

	public void enterCity(String citytext) {
		city.sendKeys(citytext);
	}

	public void selectState(String statetext) {
		Select s = new Select(state);
		s.selectByVisibleText(statetext);
	}

	public void daySelect(String daytext) {
		Select s = new Select(day);
		s.selectByVisibleText(daytext);
	}

	public void yearSelect(String yeartext) {
		Select s = new Select(year);
		s.selectByVisibleText(yeartext);
	}

	public void monthSelect(String monthtext) {
		Select s = new Select(month);
		s.selectByVisibleText(monthtext);
	}

	public void submitForRegistration() {
		submitregistration.click();
	}

	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

}
