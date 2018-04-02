import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PacktFreeBookClaimer {
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.packtpub.com/");
		WebElement accountBar = driver.findElement(By.id("account-bar-login-register"));
		WebElement anchor = accountBar.findElement(By.className("login-popup"));
		WebElement login = anchor.findElement(By.className("float-left"));
		login.click();
		
		WebElement loginForm = driver.findElement(By.id("packt-user-login-form"));
		WebElement email = loginForm.findElement(By.id("email"));
		WebElement password = loginForm.findElement(By.id("password"));
		WebElement submit = loginForm.findElement(By.id("edit-submit-1"));
		email.sendKeys(args[0]);
		password.sendKeys(args[1]);
		
		
		
		// Now submit the form. WebDriver will find the form for us from the element
		submit.submit();
		
		ExpectedCondition< Boolean > pageLoad = driver1 ->
						((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
		
		
		Wait< WebDriver > wait = new WebDriverWait(driver, 60);
		try {
			wait.until(pageLoad);
		} catch (Throwable pageLoadWaitError) {
			throw new RuntimeException("Timeout during page load", pageLoadWaitError);
		}
		WebElement element = driver.findElement(By.id("menu-packt"));
		new Actions(driver).moveToElement(element).perform();
		WebElement freeLearningLink = driver.findElement(By.xpath("//a[@href=\"" + "/packt/offers/free-learning" + "\"]"));
		WebElement parentP = freeLearningLink.findElement(By.xpath(".."));
		parentP.click();
		
		WebElement freeClaim = driver.findElement(By.id("free-learning-claim"));
		freeClaim.click();
	
	}
	
	
	
}
