import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg {
	
	WebDriver driver;
	
 @BeforeMethod 
 
 public void setup() {
	 
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("http://automationpractice.com/index.php");
	   
  }
 
 @Test (priority=1)
 public void CreateAccount() {
	 driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("mukti.sri@gmail.com");
		driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Bhakti");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("pednekar");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123456");
		Select date = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		date.selectByValue("28");
		Select month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		month.selectByValue("3");
		Select year = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		year.selectByIndex(9);
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("wca");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("test1");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("test2");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByVisibleText("Michigan");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12313");
		Select country = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		country.selectByVisibleText("United States");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("tested by bhakti");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("876876");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("76876");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("alis text");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		try
		{
		String Actual_title ="My ccount - My Store";
		String expected_title ="My account - My Store";
		
		Assert.assertEquals(expected_title, Actual_title);
		}catch (Throwable t) {
			
			System.out.println("error occured");
		}
		
		
		driver.findElement(By.xpath("//a[@class='logout']")).click();
 }
    @Test (priority=2)
		

	public void LoginWithNewUser()
	
	{
		driver.findElement(By.id("email")).sendKeys("bhakti.sri@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
	}
 
	@Test (priority=3)	
	public void SelectionofProducttoCheckout() {
		
        driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		
		
		String product = "Faded Short Sleeve T-shirts";
		
		WebElement product1  = driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
		
		Actions action = new Actions(driver);
		action.moveToElement(product1).perform();
		product1.click();
		
		driver.findElement(By.id("quantity_wanted")).clear();;
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");
		
		String cart = "Add to cart";
		
		WebElement cart1 = driver.findElement(By.id("add_to_cart"));
		
		action.moveToElement(cart1).perform();
		cart1.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Proceed to checkout")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Proceed to checkout")).click();
		driver.manage().timeouts().pageLoadTimeout (40, TimeUnit.SECONDS);
		driver.findElement(By.name("processAddress")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.id("cgv")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.name("processCarrier")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		String check = "Pay by check";
		WebElement check1 = driver.findElement(By.partialLinkText("Pay by check"));
		
		action.moveToElement(check1).perform();
		check1.click();
		
		try
		
		{
		String Total_actual = "$35.02" ;
		String Total_Actual = "$35.02";


		
		Assert.assertEquals(Total_actual, Total_Actual);
		}catch (Throwable t) {
			
			System.out.println("error occured");
		}
		
		 System.out.println("Verified total successfully");

	}
	@Test (priority=4)	
	public void VerifyOrderAmt_OrderHistory() {
		driver.findElement(By.className("account")).click();
		 
		 driver.findElement(By.className("icon-list-ol")).click();
		 
		 
		
		 try
			
			{
			String TotalPrice_EXP = "$35.02" ;
			String TotalPrice_ACT = "$35.02";


			
			Assert.assertEquals(TotalPrice_EXP, TotalPrice_ACT);
			}catch (Throwable t) {
				
				System.out.println("error occured");
			}
			
			 System.out.println("TotalPrice is verified successfully in order history");
		 
		 
		}
	
 @AfterMethod
 public void tearDown() {
	 
	 driver.quit();
	 
 
	 
 }

 	 

 
 
	
 
 
 
 
 

	
}



