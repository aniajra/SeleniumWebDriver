package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ScrollingExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);

        WebElement target = driver.findElement(By.xpath("//h2[text()='HTML Table Tags']"));

        JavascriptExecutor objExecutor = (JavascriptExecutor) driver;
        //objExecutor.executeScript("arguments[0].scrollIntoView();", target);

        //objExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        //objExecutor.executeScript("window.scrollTo(0,-document.body.scrollHeight);");

        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();

        act.keyDown(Keys.COMMAND).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();


    }
}
