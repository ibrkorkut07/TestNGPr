package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWebelement extends TestBase {

    @Test
    public void nutellaTesti() throws InterruptedException, IOException {
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutella icin arama yapalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));

        String sonucSayisiStr=sonucYazisiElementi.getText();

        Assert.assertTrue(sonucSayisiStr.contains("Nutella"));

        // testin calistiginin ispati icin sonuc yazisi webelementinin screenshot'ini alalim
        // tum sayfa screenshot icin 4 adim gerekli
        // 1.adim screenshot cekecegimiz webelemnti locate edelim
        // 2. adim screenshot'i kaydedecegimiz bir file olusturalim
        File webelementSS=new File("target/screenShot/webelement.jpeg");

        // 3.adim
        File geciciResim= sonucYazisiElementi.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici resmi kayit yapacagimiz asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,webelementSS);

        Thread.sleep(5000);
    }
}