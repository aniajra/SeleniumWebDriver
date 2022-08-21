package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FBLogin {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);


        //Step2: Enter Username
        WebElement UserName = driver.findElement(By.xpath("//input[@name='email']"));
        UserName.sendKeys("abc@xyz.com");


        WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
        UserName.sendKeys("test@123");

        WebElement LoginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        LoginButton.click();


    }
}