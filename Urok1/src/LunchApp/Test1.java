package LunchApp;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex Korn\\Desktop\\ALEX\\QA\\eclipse\\webdriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://sberbank.ru/ru/person");
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/div[1]/div[1]/div[3]/div/div[2]/div[1]/div[3]/div/div/a/span")).click();
        driver.findElement(By.cssSelector("div.kit-input.kit-autocomplete-input__input > input.kit-input__control")).sendKeys("Нижегородская область");
        driver.findElement(By.cssSelector(".region-search-box__option>u")).click();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        WebElement region = driver.findElement(By.cssSelector(".region-list__name"));
        String regionlist = region.getText();
        Assert.assertEquals("Нижегородская область", regionlist);
   //     ((JavascriptExecutor)driver).executerScript("document.getElementById('class="social__icon social__icon_type_yt'").click");
        driver.quit();
	}
}