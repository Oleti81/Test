package pageAction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericLibrary.TestBase;
import genericLibrary.Xls_Reader;
import objectReporting.OR_fb;

public class facebookmav extends TestBase   {

	@Test
	public void Launch() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream("E:\\eclipse\\maven\\src\\main\\java\\genericLibrary\\config.properties");
		Properties prop=new Properties();
		prop.load(fs);
		facebookmav o=new facebookmav();
		Xls_Reader xl=new Xls_Reader("F:\\login\\fb.xlsx");
		System.out.println(prop.getProperty("browserType"));
		driver = o.LaunchBrowser(prop.getProperty("browserType"));
		//TestBase tb=new TestBase(); 
		driver.get(prop.getProperty("URL"));
		OR_fb obj=PageFactory.initElements(driver,OR_fb.class );
		/*obj.firstname.sendKeys(xl.getCellData("Sheet1", "firstname", 1));
		obj.lastname.sendKeys(xl.getCellData("Sheet1", "lastname", 1));
		obj.reg_email__.sendKeys(xl.getCellData("Sheet1", "mobileno", 1));
		obj.birthday_day.sendKeys(xl.getCellData("Sheet1", "date", 1));
		obj.birthday_month.sendKeys(xl.getCellData("Sheet1", "month", 1));
		obj.birthday_year.sendKeys(xl.getCellData("Sheet1", "year", 1));*/	
		o.waitUntil(obj.firstname);
		o.setText(obj.firstname, xl.getCellData("Sheet1", "firstname", 3));
		o.setText(obj.lastname, xl.getCellData("Sheet1", "lastname", 3));
		o.setText(obj.reg_email__, xl.getCellData("Sheet1", "mobileno", 3));
		o.SelectfromDropdown(obj.birthday_day,"15", "byIndex");
		o.SelectfromDropdown(obj.birthday_month,"Jan","byText");	
		o.SelectfromDropdown(obj.birthday_year,"2012", "byValue");
		//o.setText(obj.birthday_day, xl.getCellData("Sheet1", "date", 3));
		//o.setText(obj.birthday_month, xl.getCellData("Sheet1", "month", 3));
		//o.setText(obj.birthday_year, xl.getCellData("Sheet1", "year", 3))
		o.performclick(obj.websubmit);
		
		//driver.findElement(By.name("firstname")).sendKeys(xl.getCellData("Sheet1", "firstname", 1));
		//driver.findElement(By.name("lastname")).sendKeys(xl.getCellData("Sheet1", "lastname", 1));
		//driver.findElement(By.name("reg_email__")).sendKeys(xl.getCellData("Sheet1", "mobileno", 1));
		//Select s=new Select(driver.findElement(By.name("birthday_day")));
		//s.selectByVisibleText(xl.getCellData("Sheet1", "date", 1));
		//Select v=new Select(driver.findElement(By.name("birthday_month")));
		//v.selectByVisibleText(xl.getCellData("Sheet1", "month", 1));
		//Select z=new Select(driver.findElement(By.name("birthday_year")));
		//z.selectByVisibleText(xl.getCellData("Sheet1", "year", 1));
		String x=driver.findElement(By.xpath("//span[contains(text(),'Create an account')]")).getText();
		xl.setCellData("Sheet1", "test", 3, x);
		xl.setCellData("Sheet1", "result", 3, "pass");
		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys(prop.getProperty("userName"));
		//driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(prop.getProperty("password"));
		//o.capturescreenshot("befre login");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.findElement(By.id("inputtext _58mg _5dba _2ph-")).sendKeys();
		//Thread.sleep(3000);
		
		//o.capturescreenshot("after login");
	}

			
	}


