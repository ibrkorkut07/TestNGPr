package tests.day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class Pr {
/*
      2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
       arama yapin ve aramanizin gerceklestigini Test edin
      3. Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
    $16.83 oldugunu test edin
*/
    WebDriver driver;
    @BeforeClass
    public  void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test1 () {
        String  currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertTrue(currentUrl.equals(expectedUrl));
    }

    @Test (dependsOnMethods = "test1")
    public void test2 () {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
    }

    @Test
    public void test3 () {
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        String fiyat = driver.findElement(By.xpath("(//span[@class='a-size-mini olpWrapper'])[2]")).getText();
        System.out.println(fiyat);
    }
}
