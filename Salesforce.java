package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		String childwindow = driver.getWindowHandle();
		WebDriver window = driver.switchTo().window(childwindow);
		Set<String> childWindow = driver.getWindowHandles();
		List<String> openedWindow = new ArrayList<String> (childWindow);
		driver.switchTo().window(openedWindow.get(1));
		driver.findElement(By.xpath("//button[text() ='Confirm']")).click();
		String Title = driver.getTitle();
		driver.switchTo().window(childwindow);
		driver.close();
		Set<String> parentWindow =driver.getWindowHandles();
		List<String> parentWindow1 = new ArrayList<String>(parentWindow);
		driver.switchTo().window(parentWindow1.get(0));
		driver.close();
	}
}
