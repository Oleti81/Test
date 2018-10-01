package genericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
	public WebDriver LaunchBrowser(String browser){
		
				if(browser.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();}
				else if (browser.equals("firefox"))
				{
		System.setProperty("webdriver.firefox.driver", "E:\\geckodriver-v0.21.0-win64");			
				}
		
		return driver;
	}
	public void waitUntil(WebElement obj){
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(obj));	
	}
	public void SelectfromDropdown(WebElement obj,String value,String type){
		Select s=new Select(obj);
		if(type.equals("byText")){
			s.selectByVisibleText(value);
		}
		else if(type.equals("byValue")){
			s.selectByValue(value);
		}
		else if(type.equals("byIndex")){
			s.selectByIndex(Integer.parseInt(value));	
		}
		
	}
	public void setText(WebElement obj,String value){
		obj.sendKeys(value);
	}
	public void performclick(WebElement obj){
		obj.click();
	}
 public void capturescreenshot(String Filename) throws IOException{
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File("E:\\eclipse\\maven\\screenshoot\\"+Filename+".png");
	//FileUtils.copyFile(SrcFile, DestFile);
	FileHandler.copy(SrcFile, DestFile);

}

}
