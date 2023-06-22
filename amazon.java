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

public class amazon {
public static void main(String[] args) throws InterruptedException, IOException {
	ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.amazon.in/");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
WebElement onePl = driver.findElement(By.xpath("//div[text()='oneplus 9 pro']"));
Actions ac = new Actions(driver);
ac.moveToElement(onePl).perform();
onePl.click();
driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']")).click();
Thread.sleep(2000);
String phName = driver.findElement(By.xpath("//span[text()='(Renewed) OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).getText();
System.out.println("PhoneName : " + phName);
String ratE = driver.findElement(By.xpath("(//span[text()='1.3 out of 5'])[2]")).getText();
System.out.println("Rating :" + ratE);
driver.findElement(By.xpath("//span[text()='(Renewed) OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
Set<String> childWindow = driver.getWindowHandles();
List<String> ch =new ArrayList<String>(childWindow);
driver.switchTo().window(ch.get(1));
Thread.sleep(1000);
File sc = driver.getScreenshotAs(OutputType.FILE);
File des = new File("./snaps/shot.png");
FileUtils.copyFile(sc, des);
driver.findElement(By.id("add-to-cart-button")).click();
String addCart = driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']")).getText();
System.out.println(addCart);
driver.close();
driver.switchTo().window(ch.get(0));
driver.close();
}
}
