package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class snapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		WebElement mShoe = driver.findElement(By.xpath("//span[@class='catText']"));
		WebElement spShoe = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		Actions Act = new Actions(driver);
		Act.moveToElement(mShoe).perform();
		Act.moveToElement(spShoe).perform();
		spShoe.click();
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Sports Shoes for Men :" + count);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		Thread.sleep(1000);
		WebElement lowToHi = driver.findElement(By.xpath("(//li[@data-index='1'])[2]"));
		Act.moveToElement(lowToHi).perform();
		lowToHi.click();
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900",Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200",Keys.ENTER);			
		// Step9 no navy colour 
		//Step 10 verify all applied filters
		Thread.sleep(1000);
		WebElement selShoe = driver.findElement(By.xpath("//p[text()='Vector X RAZOR 2.0 Red Training Shoes']"));
		Actions Acct = new Actions (driver);
		Acct.moveToElement(selShoe).perform();
		driver.findElement(By.xpath("//div[@class='product-tuple-image ']")).click();
		Thread.sleep(2000);
		Set<String> childWindow = driver.getWindowHandles();
		List<String> cW =new ArrayList<String>(childWindow);
		driver.switchTo().window(cW.get(1));
		//String totPri =driver.findElement(By.xpath("//span[text()='1099']")).getText();
		//System.out.println("MRP" + totPri);
		//Thread.sleep(2000);
		//String totDisc = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		//String totDisc =driver.findElement(By.xpath("//span[@class='pdpDiscount']")).getText();
		//System.out.println(totDisc);
		String totalDes = driver.findElement(By.xpath("//div[@class='disp-table']")).getText();
		System.out.println(totalDes);
		File sc = driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./snaps/shot.png");
		FileUtils.copyFile(sc, des);
		driver.close();
		Set<String> parentWindow = driver.getWindowHandles();
		List<String> pW = new ArrayList<String>(parentWindow);
		driver.switchTo().window(pW.get(0));
		driver.close();	
	}
}