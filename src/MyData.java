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
	
	
	// global variables to be used later 

		String myWebSite = "https://automationteststore.com/";

		String SignupPage = "https://automationteststore.com/index.php?rt=account/create";

		Connection con;

		Statement stmt;

		ResultSet rs;
		
		// the data inside mydata base 

		String CustomerFirstNameInDataBase;
		String CustomerLastNameInDataBase;
		String email;
		String password;
		String CustomerCountryInDataBase;

	
		
		
			

}
