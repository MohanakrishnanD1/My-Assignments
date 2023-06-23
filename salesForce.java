package Marathon2;

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

import io.github.sukgu.Shadow;

public class salesForce {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> childWindow = driver.getWindowHandles();
		List<String> ch = new ArrayList<String>(childWindow);
		driver.switchTo().window(ch.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow sH =new Shadow(driver);
		sH.findElementByXPath("//span[text()='Learning']").click();
		Actions act = new Actions(driver);
		WebElement mouHo = sH.findElementByXPath("//span[text()='Learning on Trailhead']");
		act.moveToElement(mouHo).perform();
		WebElement salesCert = sH.findElementByXPath("//a[text()='Salesforce Certification']");
		act.moveToElement(salesCert).perform();
		salesCert.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
		String arcTit = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']")).getText();
		System.out.println("Role :" + arcTit);
		Thread.sleep(2000);
		String arcSumm = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']")).getText();
		System.out.println("Summary : "+ arcSumm);
		List<WebElement> Cert = driver.findElements(By.xpath("//div[@class='slds-container--center slds-container--x-large slds-p-top--small']"));
		for (int i = 0; i < Cert.size(); i++) {
			System.out.println(Cert.get(i).getText());
			System.out.println("----------------------------------------------------");
			driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
			List<WebElement>cert1 = driver.findElements(By.xpath("//div[@class='slds-container--center slds-container--x-large slds-p-top--small']"));
			for (int j = 0; j < cert1.size(); j++) {
				Thread.sleep(1000);
				System.out.println(cert1.get(j).getText());
				System.out.println("----------------------------------------------------------------");
				Thread.sleep(1000);
				File sc = driver.getScreenshotAs(OutputType.FILE);
				File des = new File("./snap/shot.png");
				FileUtils.copyFile(sc, des);
				driver.close();
				driver.switchTo().window(ch.get(0));
				driver.close();
			}
		}
	}
}
