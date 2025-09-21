

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


                       //inheritance
public class MyTestCases extends MyData{
WebDriver driver = new EdgeDriver();
Connection con;
Statement stmt; 
ResultSet rs;
	
@BeforeTest
public void myBeforeTest() throws SQLException {
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "asa113355");

	
	driver.get(myWebSite);

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

}

@Test(priority = 1, enabled = true)

public void AddNewRecord() throws SQLException {

	String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country, salesRepEmployeeNumber, creditLimit) VALUES (999, 'Abc Company', 'ali', 'ahmad', '962797700235', '123 Main St', 'Los Angeles', 'Spain', 1370, 50000.00)";

	stmt = con.createStatement();

	int rowInserted = stmt.executeUpdate(query);

}

@Test(priority = 3)

public void ReadData() throws SQLException {

	String query = "select * from customers where customerNumber =999 ";
	stmt = con.createStatement();

	rs = stmt.executeQuery(query);

	System.out.println(rs);

	while (rs.next()) {
		int customerNumberInDataBase = rs.getInt("customerNumber");

		CustomerFirstNameInDataBase = rs.getString("contactFirstName").toString().trim();

		CustomerLastNameInDataBase = rs.getString("contactLastName").toString().trim();
		CustomerCountryInDataBase = rs.getString("country").toString().trim();

		;

		email = CustomerFirstNameInDataBase + CustomerLastNameInDataBase + "@gmail.com";
		password = "123!@#P@ssw0rd";

	}

}

@Test(priority = 2, enabled = true)

public void updateData() throws SQLException {

	String query = "UPDATE customers SET contactLastName = 'asaad' WHERE customerNumber = 999;";

	stmt = con.createStatement();

	int rowInserted = stmt.executeUpdate(query);

}

@Test(priority = 4, enabled = true)

public void deleteData() throws SQLException {

	String query = "delete from customers where customerNumber =999";

	stmt = con.createStatement();

	int rowInserted = stmt.executeUpdate(query);

}

@Test(priority = 5,enabled = true)
public void SignupTest() throws InterruptedException {

	driver.navigate().to(SignupPage);


	// Webelements
	WebElement FirstName = driver.findElement(By.id("AccountFrm_firstname"));
	WebElement LastName = driver.findElement(By.id("AccountFrm_lastname"));
	WebElement Email = driver.findElement(By.id("AccountFrm_email"));
	WebElement Telephone = driver.findElement(By.id("AccountFrm_telephone"));
	WebElement TheFax = driver.findElement(By.id("AccountFrm_fax"));
	WebElement AddressOne = driver.findElement(By.id("AccountFrm_address_1"));

	WebElement Thecountry = driver.findElement(By.id("AccountFrm_country_id"));

	WebElement TheState = driver.findElement(By.id("AccountFrm_zone_id"));
	Select mySelectElementForcountry = new Select(Thecountry);
	Select mySelectElementForState = new Select(TheState);

	mySelectElementForcountry.selectByVisibleText(CustomerCountryInDataBase);
	Thread.sleep(2000);
	mySelectElementForState.selectByIndex(1);

	List<WebElement> AlltheStates = TheState.findElements(By.tagName("option"));

//	String theCity = AlltheStates.get(theSelectStateIndex).getText();
//
//	WebElement TheCityInput = driver.findElement(By.id("AccountFrm_city"));
//
//	WebElement ThePostalCode = driver.findElement(By.id("AccountFrm_postcode"));
//
//	WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));
//
//	WebElement ThePassword = driver.findElement(By.id("AccountFrm_password"));
//	WebElement TheConfirmPassword = driver.findElement(By.id("AccountFrm_confirm"));
//
//	WebElement AgreeCheckBox = driver.findElement(By.id("AccountFrm_agree"));
//
//	WebElement CountinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
//	// -- Actions --
//	FirstName.sendKeys(TheFirstName);
//	LastName.sendKeys(TheLastName);
//	Email.sendKeys(TheEmail);
//	Telephone.sendKeys(TelePhone);
//	TheFax.sendKeys(TheFaxNumber);
//	AddressOne.sendKeys(TheAddressOne);
//	;
//
//	TheCityInput.sendKeys(theCity);
//
//	ThePostalCode.sendKeys(postalCode);
//
//	LoginName.sendKeys(LOGINAME);
//	ThePassword.sendKeys(Password);
//	TheConfirmPassword.sendKeys(Password);
//	AgreeCheckBox.click();
//	CountinueButton.click();
//	Thread.sleep(5000);
//	String ActualSignUpMessage = driver.findElement(By.className("maintext")).getText();
//
//	// test case ( بتقارن القيمة الحقيقة بالمتوقعة وبتشتغل زي ال if )
//	Assert.assertEquals(ActualSignUpMessage, ExpectedTextForTheSignUp);

}

//@Test (priority = 6,enabled = false)
//public void LogoutTest() throws InterruptedException {
//	
//	Thread.sleep(2000);
//	driver.findElement(By.partialLinkText("Logo")).click();;
//	
//	
//	//System.out.println(driver.getPageSource());
//	
//	boolean ActualValueForLogout = driver.getPageSource().contains(TheLogoutMessage);
//	
//	Assert.assertEquals(ActualValueForLogout, true);
//}
//
//@Test(priority = 7,enabled = false)
//
//public void Login() throws InterruptedException {
//	
//	//driver.findElement(By.partialLinkText("Login or ")).click();;
//	
//	
//	//driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=account/login']")).click();
//	
//	
//	driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a")).click();
//	
//	WebElement LoginNameInput = driver.findElement(By.id("loginFrm_loginname"));
//	
//	WebElement LoginPasswordInput = driver.findElement(By.id("loginFrm_password"));
//	WebElement LoginButton =driver.findElement(By.cssSelector("button[title='Login']"));
//
//	
//	
//	LoginNameInput.sendKeys(LOGINAME);
//	LoginPasswordInput.sendKeys(Password);
//	
//	Thread.sleep(5000);
//	
//	LoginButton.click();
//	
//	boolean ActualVlaue = driver.getPageSource().contains(welcomemessage);
//	boolean Expectedvalue = true ; 
//	
//	Assert.assertEquals(ActualVlaue, Expectedvalue);;
//	
//}
//
//@Test(priority = 8,invocationCount = 1)
//public void AddItemToTheCart() {
//    driver.navigate().to(myWebSite);
//    Random rand = new Random();
//
//    for (int i = 0; i < 10; i++) { // max 10 attempts here we can increase momkin 16 
//        // pick a random item and open it
//        List<WebElement> items = driver.findElements(By.className("prdocutname"));
//        int randomItem = rand.nextInt(items.size());
//        items.get(randomItem).click();
//
//        // check availability
//        boolean outOfStock = driver.getPageSource().contains("Out of Stock"); // true
//        boolean blockedProduct = driver.getCurrentUrl().contains("product_id=116");//false
//
//        if (!outOfStock && !blockedProduct) {
//            driver.findElement(By.cssSelector(".cart")).click();
//            System.out.println("Added to cart: " + driver.getCurrentUrl());
//            return; // success
//        }
//
//        driver.navigate().back(); // try again
//    }
//
//    throw new RuntimeException("No in-stock item found after 10 attempts.");
//}
//
//
//
//@AfterTest
//public void AfterMyTest() {
//
//	// driver.close();
//
//	// driver.quit();
//}


}
