package tests.day14;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_Screenshot extends TestBase {

    @Test
    public void screenTest() throws IOException {

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Godkänn alla']")).click();
        // 1.adim : screenshot almak icin obje olusturalim ve deger olarak driver'imizi atayalim
        //          deger olarak driver'i kabul etmesi icin casting yapmamiz gerekir
        TakesScreenshot tss=(TakesScreenshot) driver;


        // 2.adim :  tum sayfanin screenshot'ini almak icin bir File olusturalim ve
        // dosya yolunu belirtelim

        File tumSayfaSsh=new File("tumSayfa.png");

        // 3.adim : olusturdugumuz file ile takescreenshot objesini iliskilendirelim

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfaSsh);

        // eger spesifik bir webelementin screenshot'ini almak istiyorsaniz

        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));
        File logoResmi=new File("logo.png");
        File GeciciLogoResmi=logoElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(GeciciLogoResmi,logoResmi);


    }
}
