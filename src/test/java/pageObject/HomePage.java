package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String s;
	Actions act = new Actions(driver);
	@FindBy(xpath = "//a[@class='account']")
	private WebElement accountname;
	@FindBy(xpath = "+s+")
	private WebElement searchedProduct;
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckout;
	@FindBy(xpath ="//input[@id='cgv']")
	private WebElement checkout;
	
	public void checkoutclick() {
		checkout.click();
	}
	public void clickOnSearchedProduct(String product) {

		s = "//ul[@class='product_list grid row']//li//child::a[contains(text()," + product + ")]";
		act.moveToElement(searchedProduct).build().perform();
	}
	public void proceedtoCheckoutClick() {
		proceedToCheckout.click();
	}

	public void proceedtocheckoutActions()
	{
	Action a = act.moveToElement(driver.findElement(By.xpath("//a[@title='Proceed to checkout']")))
			.keyDown(Keys.ENTER).release().build();
	a.perform();
}
	String prod;
	
	@FindBy(xpath = "+prod+")
	private WebElement childprod ;
	
	public String getproductText(String product)
	{
		prod="//span[contains(text(),'"+product+"')]";
		return childprod.getText();
	}
	@FindBy(xpath = "//a[@class='logout']")
	private WebElement logout;
	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement searchSubmit;

	@FindBy(xpath = "//a[@title='Add to cart']")
	private WebElement addToCart;

	public void searchsendText(String searchText) {
		searchTextBox.sendKeys(searchText);
	}

	public void addTOCart() {
		addToCart.click();
	}

	public void clicksearchSubmit() {
		searchSubmit.click();
	}

	public void clickLogout() {
		logout.click();
	}

	public String getAccountName() {
		return accountname.getText();
	}

}
