package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		//To launchbrowser
		//step-1
		ChromeDriver driver=new ChromeDriver();
		
		//max screen
		driver.manage().window().maximize();
		
		//step-2 load the url
		//obj.method()
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//syntax-driver.findElement(By.id("value"));
		
		//webelement-ctrl+2+l
		//findelement returntype-----webelement
		
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("demoslaesManager");
		user.clear();
		user.sendKeys("DemoCsr");
		
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Mohana");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Krishnan");
		driver.findElement(By.name("departmentName")).sendKeys("EEE");
		driver.findElement(By.name("description")).sendKeys("Need Good Learing Platform");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("krissh295@gmail.com");
		driver.findElement(By.linkText("departmentName")).sendKeys("EEE");
		WebElement State=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select Option=new Select (State);
		Option.selectByVisibleText ("New York");
		driver.findElement(By.name("submitButton")).click();

		driver.close();
	}
	}