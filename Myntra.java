package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.myntra.com/");
		WebElement men = driver.findElement(By.xpath("//a[@class='desktop-main']"));
		Actions Act = new Actions (driver);
		Act.moveToElement(men).perform();
		WebElement mJac = driver.findElement(By.linkText("Jackets"));
		Act.moveToElement(mJac).perform();
		mJac.click();
		Thread.sleep(2000);
		String jacCount = driver.findElement(By.xpath("//div[@class='title-container']")).getText();
		System.out.print(jacCount);
		String catVerf = driver.findElement(By.xpath("//div[@class='vertical-filters-filters categories-container']")).getText();
		System.out.println(catVerf);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		WebElement clDia = driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']"));
		Act.moveToElement(clDia).perform();
		clDia.click();
		//Step10 confirm all the coats are the brand 
		Thread.sleep(2000);
		WebElement moRec = driver.findElement(By.xpath("//span[text()='Recommended']"));
		Actions Act1 =new Actions(driver);
		Act1.moveToElement(moRec).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
		driver.findElement(By.xpath("//img[@title='Duke Men Blue Solid Puffer Jacket']")).click();
		Thread.sleep(1000);
		Set<String> childWindow = driver.getWindowHandles();
		List<String> cW = new ArrayList<String>(childWindow);
		driver.switchTo().window(cW.get(1));
		File sc = driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./snaps/shot.png");
		FileUtils.copyFile(sc, des);
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.close();
		Set<String>	parentWindow = driver.getWindowHandles();
		List<String> pW = new ArrayList<String>(parentWindow);
		driver.switchTo().window(pW.get(0));
		driver.close();
	}

}