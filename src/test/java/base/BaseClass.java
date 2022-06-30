package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
	public static WebDriver driver;
	public static Properties props;
	public static FileInputStream fis;

	public BaseClass() throws IOException {
		try {
			props = new Properties();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/base/prop.properties");

		props.load(fis);
		if (props.getProperty("Browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Users/Karthi/eclipse-workspace/chromedriver.exe");
		}
	}{
		driver = new ChromeDriver();
	
}
}
