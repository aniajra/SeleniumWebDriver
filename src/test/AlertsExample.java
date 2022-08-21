package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertsExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);


        WebElement AlertButton = driver.findElement(By.id("alertButton"));
        AlertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();


        WebElement ConfirmButton = driver.findElement(By.id("confirmButton"));
        ConfirmButton.click();
        alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        WebElement PromptButton = driver.findElement(By.id("promtButton"));
        PromptButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Hello There");
        System.out.println(alert.getText());
        alert.accept();

    }
}
