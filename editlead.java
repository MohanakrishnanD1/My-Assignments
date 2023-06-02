package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class editlead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
	     
	    driver.get("http://leaftaps.com/opentaps/control/login");
	    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TESTLEAF");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Dhamu");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("dharan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("D");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("SENIOR MIS");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Management Information systems");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("DhamuD@gmail.com");
		WebElement State=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select Option=new Select (State);
		Option.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		WebElement Description=driver.findElement(By.id("updateLeadForm_description"));
		Description.sendKeys ("Management Information systems");
		Description.clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("management");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(3000);
}
}
