package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (30));
		driver.get("https://www.nykaa.com/");
		WebElement Bd = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions Ac = new Actions(driver);
		Ac.moveToElement(Bd).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='css-150nd8c']//a)[2]")).click();
		driver.findElement(By.xpath("//h1[@class='css-1h2cpk7']"));
		String title = driver.getTitle();
		String Url = driver.getCurrentUrl();
		System.out.println(title);
		System.out.println(Url);
		driver.findElement(By.id("filter-sort")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("(//span[text()='Shampoo'])")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		String filter = driver.findElement(By.xpath("//div[@class='css-rgv4i5']/span")).getText();
		System.out.println(filter);
		String text = driver.findElement(By.xpath("(//div[@class='css-3i7s5s']/span)[1]")).getText();
		System.out.println(text);
		String text2 = driver.findElement(By.xpath("(//div[@class='css-3i7s5s']/span)[2]")).getText();
		System.out.println(text2);
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		Set<String> window1 = driver.getWindowHandles();
		List<String>w1=new ArrayList<String>(window1);
		driver.switchTo().window(w1.get(1));
		driver.findElement(By.xpath("//span[text()='650ml']")).click();
		String MRP = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']")).getText();
		System.out.print(MRP);
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		driver.switchTo().frame(0);
		String total = driver.findElement(By.xpath("//span[text()='Grand Total']")).getText();
		System.out.println(total);
		driver.close();
		driver.switchTo().window(w1.get(0));
		driver.close();
	}
}