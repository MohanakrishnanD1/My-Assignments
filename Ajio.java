package week3.day2;

	import java.time.Duration;
import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Ajio {
		    public static void main(String[] args) throws InterruptedException {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (20));

			
			driver.get("https://www.ajio.com/");   
			driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("bags");
			driver.findElement(By.className("ic-search")).click();
			driver.findElement(By.xpath("//label[@for='Men']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
			String t = driver.findElement(By.xpath("//div[@class='length']")).getText();
			System.out.println(t);
			String brands = driver.findElement(By.xpath("(//div[@class='items'])[96]")).getText();
			System.out.println(brands);
			
	}
		}

