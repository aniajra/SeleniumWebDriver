package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FIleUploadExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);

        WebElement FileUpload = driver.findElement(By.name("uploadfile_0"));
        FileUpload.sendKeys("//Users//anitharaj//Documents//Projects//fileupload.txt");

        WebElement TnC = driver.findElement(By.id("terms"));
        TnC.click();

        WebElement Submit = driver.findElement(By.id("submitbutton"));
        Submit.click();
    }
}
