import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyData {
	
	
WebDriver driver = new EdgeDriver();
	
	// global variables to be used later 

	String myWebSite = "https://automationteststore.com/";

	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

	Connection con;

	Statement stmt;

	ResultSet rs;
	Random rand = new Random(); 

	//its for elenamte the duplicate
	int randomNumberForTheEmail1 = rand.nextInt(54789);
	int randomNumberForTheEmail2 = rand.nextInt(5472);
	int randomNumberForTheEmail3 = rand.nextInt(1600);

	String ExpectedTextForTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!" ;
	
	int randomNumberForTheEmail = randomNumberForTheEmail1*randomNumberForTheEmail2 -randomNumberForTheEmail3 ; 

	
	// the data inside mydata base 

	String CustomerFirstNameInDataBase;
	String CustomerLastNameInDataBase;
	String email;
	String password = "123!@#P@ssw0rd";
	String CustomerCountryInDataBase;
	
	String address ; 

	String ThePostalcode ; 
	
	String loginName ; 
	
String TelePhone;
String TheFaxNumber="0000";
		
		
String welcomemessage = "Welcome back "+ CustomerFirstNameInDataBase;

String TheLogoutMessage ="You have been logged off your account. It is now safe to leave the computer.";
}
