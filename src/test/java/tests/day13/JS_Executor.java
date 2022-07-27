package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class JS_Executor extends TestBase {

    @Test
    public void scrollIntoView1() throws InterruptedException {

        driver.get("https://www.amazon.com");

        JavascriptExecutor jse=(JavascriptExecutor)driver;

        WebElement sellElementi= driver.findElement(By.xpath("//a[text()='Sell']"));
        // jse.executeScript("arguments[0].click();",sellElementi);

        Thread.sleep(2000);
        WebElement altSignIn=driver.findElement(By.xpath("//span[@class='action-inner']"));


        jse.executeScript("arguments[0].scrollIntoView(true);",altSignIn);

        Thread.sleep(5000);

        jse.executeScript("arguments[0].click();",altSignIn);

    }

    @Test
    public void test02() throws InterruptedException {

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        driver.get("https://www.koalaresorthotels.com");

        Thread.sleep(3000);

        WebElement ourRooms = driver.findElement(By.xpath("(//a[text()='View Room Details '])[1]"));

        jse.executeScript("arguments[0].scrollIntoView(true);",ourRooms);

        Thread.sleep(4000);

        jse.executeScript("arguments[0].click();",ourRooms);

        Thread.sleep(4000);
    }

}
