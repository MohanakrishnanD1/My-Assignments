package week2.day1;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Createlead {
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			ChromeDriver driver= new ChromeDriver();
		     
		    
			Thread.sleep(3000);
			driver.get("http://leaftaps.com/opentaps/control/login");
		    driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("PENNA INDUSTRIES LTD");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("RAJASEKAR");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("VENKATESAN");
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("MR");
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("SENIOR MIS");
			driver.findElement(By.id("createLeadForm_description")).sendKeys("Management Information systems");
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("raja29jan@gmail.com");
			WebElement State=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select Option=new Select (State);
			Option.selectByVisibleText ("New York");
			driver.findElement(By.name("submitButton")).click();
		}
	}

